package com.example.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.lv1)
    ListView lv1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.iv1)
    ImageView iv1;
    private List<Person> data = new ArrayList<>();
    private MyAdatper adatper;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //  setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);//

        tv1.setText("sdfsdfsdf");
        iv1.setImageResource(R.mipmap.ic_launcher);
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i + "", i + "");
            data.add(person);
        }
        adatper = new MyAdatper(this, data);
        lv1.setAdapter(adatper);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void btn1(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i("tag", "btn1: ");
                break;
            case R.id.btn2:
                Log.i("tag", "btn2: ");
                break;
        }
//        tv1.setText("btn1--onClick");
    }

    @OnItemClick(R.id.lv1)
    public void onItemClick(int postion) {
        Log.i("tag", "onItemClick: " + postion);
        tv1.setText("lv1--onItemClick" + postion);
    }

}
