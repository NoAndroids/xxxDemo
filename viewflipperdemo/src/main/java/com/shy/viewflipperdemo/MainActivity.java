package com.shy.viewflipperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
ViewFlipper vf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vf= (ViewFlipper) findViewById(R.id.vf);
        vf.addView(View.inflate(this,R.layout.viewflipper_layout,null));
        vf.addView(View.inflate(this,R.layout.viewflipper_layout1,null));
        vf.addView(View.inflate(this,R.layout.viewflipper_layout2,null));
    }
}
