package com.torkuds.linechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart lineChart = (LineChart) findViewById(R.id.lineChart);
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            datas.add(2);
        }
        lineChart.setDatas(datas);
    }
}
