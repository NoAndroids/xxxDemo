package com.example.mvpdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mvpdemo2.Persenter.MainPersenter;
import com.example.mvpdemo2.View.IMainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{
    private static final String TAG="tag";
    private MainPersenter persenter;
    private ListView list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1= (ListView) findViewById(R.id.list);
        persenter=new MainPersenter(this);
        persenter.load();
    }

    @Override
    public void showView(List<String> list) {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        list1.setAdapter(adapter);
        Log.i(TAG, "showView: "+list.toString());
    }
}
