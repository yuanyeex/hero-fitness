package com.yuanyeex.herofitness.core.model;


import lombok.Getter;

@Getter
public enum SerialType {
    resting("是否休息"),
    altitude("海拔"),
    heartrate("心率"),
    cadence("踏频"),
    temp("温度"),
    distance("距离"),
    grade_smooth("坡度"),
    grade_adjusted_distance("坡度调整后的距离"),
    time("时间"),
    watts_calc("预估功率"),
    lati_longi("经纬度");

    private final String description;

    SerialType(String description) {
        this.description = description;
    }
}
