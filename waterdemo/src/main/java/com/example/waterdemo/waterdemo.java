package com.example.waterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import cn.modificator.waterwave_progress.WaterWaveProgress;

public class waterdemo extends AppCompatActivity {
    WaterWaveProgress waveProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterdemo);
//        SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
        waveProgress = (WaterWaveProgress) findViewById(R.id.waterWaveProgress1);
        waveProgress.setShowProgress(false);
        waveProgress.animateWave();
        waveProgress.setWaveSpeed(0.020F);
//        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress,
//                                          boolean fromUser) {
//                setTitle("" + progress);
//                waveProgress.setProgress(progress);
//
//            }
//        });
//        ((CheckBox) findViewById(R.id.checkBox1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                waveProgress.setShowProgress(isChecked);
//            }
//        });
//        ((CheckBox) findViewById(R.id.checkBox2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                waveProgress.setShowNumerical(isChecked);
//            }
//        });
    }
}

