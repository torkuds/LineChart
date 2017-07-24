package com.torkuds.linechat.adapter;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/24.
 */

public class MonthAdapter implements IBaseAdapter {

    private int month;

    public MonthAdapter(int month) {
        if (month >= 1 && month <= 12){
            this.month = month;
        }
    }

    @Override
    public String getLabel(int position) {
        return month > 0 ? month + "/" + position : "";
    }
}
