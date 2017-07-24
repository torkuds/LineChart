package com.torkuds.linechat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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

    private int interval = 150;

    private List<Integer> datas;    //数据集合

    private int lastValue = -1;     //上一个点的值，用来画线，默认是-1

    private Paint paint = new Paint();

    Map<Integer, Integer> values = new LinkedHashMap<>();
    Map.Entry<Integer, Integer> lastEntry;

    public Line(int width, int height) {
        this.width = width;
        this.height = height;
        paint.setColor(Color.RED);
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

        if (datas != null && datas.size() > 0){
            lastValue = -1;
            for (int i = 0; i < datas.size(); i++){
                canvas.drawCircle(interval * (i + 1), height - (datas.get(i) * interval), 10, paint);
                if (lastValue >= 0){
                    canvas.drawLine(interval * i, height - (datas.get(i - 1) * interval), interval * (i + 1), height - (datas.get(i) * interval), paint);
                }
                lastValue = datas.get(i);
            }
        }
    }

    public void setDatas(List<Integer> datas) {
        this.datas = datas;

//        if (datas != null && datas.size() > 0){
//            lastValue = -1;
//            for (int i = 0; i < datas.size(); i++){
//                canvas.drawCircle(interval * (i + 1), height - (datas.get(i) * interval), 10, paint);
//                if (lastValue >= 0){
//                    canvas.drawLine(interval * i, height - (datas.get(i - 1) * interval), interval * (i + 1), height - (datas.get(i) * interval), paint);
//                }
//                lastValue = datas.get(i);
//            }
//        }
    }
}
