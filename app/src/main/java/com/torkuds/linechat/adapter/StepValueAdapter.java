package com.torkuds.linechat.adapter;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/25.
 */

public class StepValueAdapter implements IBaseAdapter {

    private int max;
    private int min;
    private int count;

    public StepValueAdapter(int max, int min, int count) {
        this.max = max;
        this.min = min;
        this.count = count;
    }

    @Override
    public String getLabel(int position) {
        if (max > min && min >= 0 && count > 0){
            int stepValue = (max - min) / count;
            return String.valueOf(stepValue * position);
        }
        return "";
    }
}
