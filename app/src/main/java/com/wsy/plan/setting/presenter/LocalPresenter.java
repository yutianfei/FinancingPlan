package com.wsy.plan.setting.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.wsy.plan.common.FormatUtils;
import com.wsy.plan.setting.model.HasTypesChanged;
import com.wsy.plan.setting.model.TypeModel;

import org.litepal.crud.DataSupport;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LocalPresenter implements ITypeModelPresenter {

    private Context context;

    public LocalPresenter(Context context) {
        this.context = context;
    }

    @Override
    public List<TypeModel> getSpecialModels(int firstId, int secondId) {
        String type = context.getString(firstId);
        List<TypeModel> list = DataSupport.where("type_first = ?", type).find(TypeModel.class);
        if (list.size() == 0) {
            HasTypesChanged hasTypesChanged = DataSupport.find(HasTypesChanged.class, 1);
            if (hasTypesChanged == null) { // 没有修改过，则添加默认数据
                // 设置新数据并存储
                String[] seconds = context.getResources().getStringArray(secondId);
                for (String fixed : seconds) {
                    TypeModel model = new TypeModel();
                    model.setType_first(type);
                    model.setType_second(fixed);
                    model.save();
                    list.add(model);
                }
                // 更新状态值
                hasTypesChanged = new HasTypesChanged();
                hasTypesChanged.setHasChanged(1);
                hasTypesChanged.save();
            }
        } else {
            List<TypeModel> sortList = new LinkedList<>();
            List<TypeModel> unSortList = new LinkedList<>();
            for (TypeModel model : list) {
                if (!TextUtils.isEmpty(model.getType_money())) {
                    sortList.add(model);
                } else {
                    unSortList.add(model);
                }
            }
            Collections.sort(sortList);
            list.clear();
            list.addAll(sortList);
            list.addAll(unSortList);
        }
        return list;
    }

    @Override
    public boolean saveModel(TypeModel model) {
        String date = model.getType_date();
        if (!TextUtils.isEmpty(date) && date.length() == 1) {
            model.setType_date("0" + date);
        }
        String money = model.getType_money();
        if (!TextUtils.isEmpty(money)) {
            model.setType_money(FormatUtils.formatMoney(money));
        }
        return model.save();
    }

    @Override
    public boolean deleteModel(long id) {
        return DataSupport.delete(TypeModel.class, id) > -1;
    }
}
