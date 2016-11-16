package com.wsy.plan.map.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wsy.plan.R;
import com.wsy.plan.common.MyEditorActionListener;
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

    private EditText editBackupLess;
    private EditText editBackupMore;
    private EditText editBackupPercent;
    private EditText editNecessaryPercent;
    private EditText editCustom1;
    private EditText editCustom2;
    private EditText editCustom3;
    private EditText editCustom4;
    private EditText editCustom5;
    private EditText editCustom1Percent;
    private EditText editCustom2Percent;
    private EditText editCustom3Percent;
    private EditText editCustom4Percent;
    private EditText editCustom5Percent;

    private MyEditorActionListener listener = new MyEditorActionListener() {
        @Override
        public void doSomething(TextView textView) {
            update();
        }
    };

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
        findEditTextById(rootView);
        return rootView;
    }

    private void findEditTextById(View rootView) {
        editBackupLess = (EditText) rootView.findViewById(R.id.edit_backup_month_less);
        editBackupMore = (EditText) rootView.findViewById(R.id.edit_backup_month_more);
        editBackupPercent = (EditText) rootView.findViewById(R.id.edit_percent_store);
        editNecessaryPercent = (EditText) rootView.findViewById(R.id.edit_percent_necessary);
        editCustom1 = (EditText) rootView.findViewById(R.id.edit_name_1);
        editCustom1Percent = (EditText) rootView.findViewById(R.id.edit_percent_name_1);
        editCustom2 = (EditText) rootView.findViewById(R.id.edit_name_2);
        editCustom2Percent = (EditText) rootView.findViewById(R.id.edit_percent_name_2);
        editCustom3 = (EditText) rootView.findViewById(R.id.edit_name_3);
        editCustom3Percent = (EditText) rootView.findViewById(R.id.edit_percent_name_3);
        editCustom4 = (EditText) rootView.findViewById(R.id.edit_name_4);
        editCustom4Percent = (EditText) rootView.findViewById(R.id.edit_percent_name_4);
        editCustom5 = (EditText) rootView.findViewById(R.id.edit_name_5);
        editCustom5Percent = (EditText) rootView.findViewById(R.id.edit_percent_name_5);

        editBackupLess.setOnEditorActionListener(listener);
        editBackupMore.setOnEditorActionListener(listener);
        editBackupPercent.setOnEditorActionListener(listener);
        editNecessaryPercent.setOnEditorActionListener(listener);
        editCustom1.setOnEditorActionListener(listener);
        editCustom1Percent.setOnEditorActionListener(listener);
        editCustom2.setOnEditorActionListener(listener);
        editCustom2Percent.setOnEditorActionListener(listener);
        editCustom3.setOnEditorActionListener(listener);
        editCustom3Percent.setOnEditorActionListener(listener);
        editCustom4.setOnEditorActionListener(listener);
        editCustom4Percent.setOnEditorActionListener(listener);
        editCustom5.setOnEditorActionListener(listener);
        editCustom5Percent.setOnEditorActionListener(listener);
    }

    private void update() {
        // 进行赋值
        dbModel.backup_less = editBackupLess.getText().toString();
        dbModel.backup_more = editBackupMore.getText().toString();
        dbModel.backup_percent = editBackupPercent.getText().toString();
        dbModel.necessary_percent = editNecessaryPercent.getText().toString();
        dbModel.custom_1_percent = editCustom1Percent.getText().toString();
        dbModel.custom_2_percent = editCustom2Percent.getText().toString();
        dbModel.custom_3_percent = editCustom3Percent.getText().toString();
        dbModel.custom_4_percent = editCustom4Percent.getText().toString();
        dbModel.custom_5_percent = editCustom5Percent.getText().toString();
        dbModel.custom_1_name = editCustom1.getText().toString();
        dbModel.custom_2_name = editCustom2.getText().toString();
        dbModel.custom_3_name = editCustom3.getText().toString();
        dbModel.custom_4_name = editCustom4.getText().toString();
        dbModel.custom_5_name = editCustom5.getText().toString();
        // 如果有变化，则更新并保存新数据
        if (!dbModelOriginal.equals(dbModel)) {
            Toast.makeText(getActivity(),"保存",Toast.LENGTH_SHORT).show();
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
