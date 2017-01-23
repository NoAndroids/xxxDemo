package com.example.wavedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WaveProgressView waveProgressbar;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        waveProgressbar= (WaveProgressView) findViewById(R.id.waveProgressbar);
        waveProgressbar.setCurrent(2,20+"%");
        waveProgressbar.setWaveColor("#5b9ef4");
        waveProgressbar.setMaxProgress(10);
        waveProgressbar.setText("#FFFF00", 41);
    }
}
