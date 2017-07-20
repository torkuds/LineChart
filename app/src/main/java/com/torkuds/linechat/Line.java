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
 * Des:
 * Created by wangtianchao
 * on 2017/7/20.
 */

public class Line {

    private int width;
    private int height;

    private int interval = 150;

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
        lastEntry = null;
        Iterator<Map.Entry<Integer, Integer>> iterator = values.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int value = entry.getValue();
            canvas.drawCircle(key * interval, height - (value * interval), 10, paint);
            if (lastEntry != null){
                int lastKey = lastEntry.getKey();
                int lastValue = lastEntry.getValue();
                canvas.drawLine(lastKey * interval, height - (lastValue * interval), key * interval, height - (value * interval), paint);
            }
            lastEntry = entry;
        }
    }
}
