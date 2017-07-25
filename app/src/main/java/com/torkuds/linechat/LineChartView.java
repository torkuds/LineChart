package com.torkuds.linechat;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/25.
 */

public class LineChartView extends LinearLayout {

    private LineChart lineChart;

    private YAxisView yAxisView;

    private int yMax;   //y轴最大值

    private int yCount; //y轴分几段

    private List<Integer> datas;

    public LineChartView(Context context) {
        this(context, null, 0);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_linechart, this, true);
        init();
    }

    private void init() {
        lineChart = (LineChart) findViewById(R.id.lineChart);
        yAxisView = (YAxisView) findViewById(R.id.yAxis);
    }

    public void setValues(int yMax, final int yCount, final List<Integer> datas){
        this.yMax = yMax;
        this.yCount = yCount;
        this.datas = datas;

        yAxisView.setDatas(yMax, yCount);

        yAxisView.setOnMeasureSuccessListener(new YAxisView.OnMeasureSuccessListener() {
            @Override
            public void onMeasureSucceess() {
                lineChart.setValues(yAxisView.getInterval(), yAxisView.getStepValue(), yCount, datas);
            }
        });

    }
}
