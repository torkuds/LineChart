package com.torkuds.linechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        YAxisView yAxisView = (YAxisView) findViewById(R.id.yAxis);
//        yAxisView.setDatas(8000, 5);
//
//        LineChart lineChart = (LineChart) findViewById(R.id.lineChart);
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            Random random = new Random();
            int value = random.nextInt(12000);
            datas.add(value);
            Log.i("随机数", value + "<--");
        }
//        lineChart.setDatas(datas);
//        lineChart.setValues(yAxisView.getInterval(), yAxisView.getStepValue(), yAxisView.getCount(), datas);

        LineChartView lineChartView = (LineChartView) findViewById(R.id.lineChartView);
        lineChartView.setValues(12000, 5, datas);
    }
}
