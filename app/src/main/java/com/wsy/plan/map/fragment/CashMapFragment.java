package com.wsy.plan.map.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;
import com.wsy.plan.databinding.FragmentMapCashBinding;
import com.wsy.plan.map.model.CashMapDBModel;
import com.wsy.plan.map.model.CashMapModel;
import com.wsy.plan.map.presenter.ICashMapModelPresenter;
import com.wsy.plan.map.presenter.LocalPresenter;

public class CashMapFragment extends Fragment {

    private ICashMapModelPresenter presenter = new LocalPresenter();
    private CashMapDBModel dbModel;
    private CashMapDBModel dbModelOriginal; // 用于比较数据是否发生变化
    private CashMapModel model = new CashMapModel();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CashMapFragment newInstance() {
        return new CashMapFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 读取数据
        dbModel = presenter.getDBModel(1);
        // 给作为比较的数据赋值
        try {
            dbModelOriginal = (CashMapDBModel) dbModel.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 设置显示数据
        model.setData(dbModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_cash, container, false);
        FragmentMapCashBinding binding = DataBindingUtil.bind(rootView);
        binding.setModel(model);
        return rootView;
    }

    public void update() {
        // 进行赋值
        dbModel.setData(model);
        // 如果有变化，则更新并保存新数据
        if (!dbModelOriginal.equals(dbModel)) {
            // 保存修改的数据
            presenter.updateDBModel(dbModel);
            // 重新给作为比较的数据赋值
            try {
                dbModelOriginal = (CashMapDBModel) dbModel.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            // 更新数据显示
            model.setData(dbModel);
        }
    }
}
