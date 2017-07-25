package com.torkuds.linechat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Des:折线
 * Created by wangtianchao
 * on 2017/7/20.
 */

public class Line {

    private int width;
    private int height;

    private int xInterval = 150;

    private int yInterval = 150;

    private float stepValue;

    private int bottomHeight;   //底部标签占得高度

    private float realHeight;     //除去底部标签，顶部到x轴的高度

    private List<Integer> datas;    //数据集合

    private int lastValue = -1;     //上一个点的值，用来画线，默认是-1

    private Paint paint = new Paint();

    Map<Integer, Integer> values = new LinkedHashMap<>();
    Map.Entry<Integer, Integer> lastEntry;

    public Line(int width, int height, int stepValue, int xInterval, int yInterval, int bottom) {
        this.width = width;
        this.height = height;
        this.stepValue = stepValue;
        this.xInterval = xInterval;
        this.yInterval = yInterval;
        this.bottomHeight = bottom;
        realHeight = height - bottomHeight;
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    public void setValue(int key, int value){
        values.put(key, value);
    }

    /**
     * 画折线
     * @param canvas
     */
    public void drawSelf(Canvas canvas){
//        lastEntry = null;
//        Iterator<Map.Entry<Integer, Integer>> iterator = values.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, Integer> entry = iterator.next();
//            int key = entry.getKey();
//            int value = entry.getValue();
//            canvas.drawCircle(key * interval, height - (value * interval), 10, paint);
//            if (lastEntry != null){
//                int lastKey = lastEntry.getKey();
//                int lastValue = lastEntry.getValue();
//                canvas.drawLine(lastKey * interval, height - (lastValue * interval), key * interval, height - (value * interval), paint);
//            }
//            lastEntry = entry;
//        }

        Log.i("折线", "yInterval:" + yInterval + ",stepValue:" + stepValue + "<--line");

        if (datas != null && datas.size() > 0){
            lastValue = -1;
            for (int i = 0; i < datas.size(); i++){
                canvas.drawCircle(xInterval * (i + 1), realHeight - (datas.get(i) / stepValue * yInterval), 10, paint);
                if (lastValue >= 0){
                    canvas.drawLine(xInterval * i, realHeight - (datas.get(i - 1) / stepValue * yInterval), xInterval * (i + 1), realHeight - (datas.get(i) / stepValue * yInterval), paint);
                }
                lastValue = datas.get(i);
            }
        }
    }

    public void setDatas(List<Integer> datas) {
        this.datas = datas;
    }
}
