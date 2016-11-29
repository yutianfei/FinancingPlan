package com.wsy.plan.rxbus;

import java.util.HashMap;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;

/**
 * 用RxJava模拟EventBus
 * <p>
 * 参考链接：
 * http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650236844
 * &idx=1&sn=c424f8c3080c298f2fc43d8a06d0671a&mpshare=1&scene=23&srcid=1129nAySUU0sq1iSuc84RI1C#rd
 */

public class RxBus {

    private static volatile RxBus mInstance;

    private HashMap<String, CompositeSubscription> mSubscriptionMap;

    /**
     * 创建一个可同时充当Observer和Observable的Subject
     * Subject是非线程安全的，为避免该问题，将Subject转换为SerializedSubject
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    private Subject<Object, Object> mSubject;

    public RxBus() {
        mSubject = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 获取RxBus单例
     */
    public static RxBus getInstance() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    /**
     * 在需要发送事件的地方，将事件post至Subject，
     * 此时Subject作为Observer接收到事件（onNext），
     * 然后发射给所有订阅该Subject的订阅者
     */
    public void post(Object o) {
        mSubject.onNext(o);
    }

    /**
     * 返回通用型的Observable
     * <p>
     * 在需要接收事件的地方，
     * 订阅该Subject（此时Subject是作为Observable），
     * 在这之后，一旦Subject接收到事件，立即发射给该订阅者
     */
    public Observable<Object> toObserverable() {
        return mSubject;
    }

    /**
     * 根据传递的 eventType 类型返回指定类型(eventType)的Observable
     * <p>
     * 在需要接收事件的地方，
     * 订阅该Subject（此时Subject是作为Observable），
     * 在这之后，一旦Subject接收到事件，立即发射给该订阅者
     */
    public <T> Observable<T> toObserverable(Class<T> eventType) {
        // ofType操作符只发射指定类型的数据
        return mSubject.ofType(eventType);
    }

    /**
     * 是否已有观察者订阅
     */
    public boolean hasObservers() {
        return mSubject.hasObservers();
    }

    /**
     * 默认的订阅方法
     */
    public <T> Subscription doSubscribe(Class<T> type, Action1<T> next, Action1<Throwable> error) {
        return toObserverable(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(next, error);
    }

    /**
     * 保存订阅后的Subscription
     */
    public void addSubscription(Object o, Subscription subscription) {
        if (mSubscriptionMap == null) {
            mSubscriptionMap = new HashMap<>();
        }
        String key = o.getClass().getName();
        if (mSubscriptionMap.get(key) != null) {
            mSubscriptionMap.get(key).add(subscription);
        } else {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            compositeSubscription.add(subscription);
            mSubscriptionMap.put(key, compositeSubscription);
        }
    }

    /**
     * 取消订阅
     */
    public void unSubscribe(Object o) {
        if (mSubscriptionMap == null) {
            return;
        }

        String key = o.getClass().getName();
        if (!mSubscriptionMap.containsKey(key)) {
            return;
        }
        if (mSubscriptionMap.get(key) != null) {
            if (!mSubscriptionMap.get(key).isUnsubscribed()) {
                mSubscriptionMap.get(key).unsubscribe();
            }
        }
        mSubscriptionMap.remove(key);
    }

}
