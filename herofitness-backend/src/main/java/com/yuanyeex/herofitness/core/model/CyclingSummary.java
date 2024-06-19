package com.yuanyeex.herofitness.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class CyclingSummary extends ActivitySummary {
    /**
     * 活动时间 - 结束时间
     */
    private long timestamp;
    /**
     * 活动开始时间
     */
    private long startTime;
    /**
     * 活动开始位置
     */
    private LatitudeAndLongitude startPosition;
    /**
     * 总时长-含休息时间
     */
    private long totalElapsedTime;
    /**
     * 总timer时间
     */
    private long totalTimerTime;
    /**
     * 总距离
     */
    private long totalDistance;
    /**
     * 总移动时长
     */
    private long totalMovingTime;
    /**
     * 平均速度 m/s
     */
    private double avgSpeed;
    /**
     * 最大速度
     */
    private double maxSpeed;
    /**
     * 平均功率 watt
     */
    private int avgPower;
    /**
     * 最大功率 watt
     */
    private int maxPower;
    /**
     * 归一化功率 watt
     */
    private int normalizedPower;
    /**
     * 总下降 m
     */
    private long totalAscent;
    /**
     * 总爬升 m
     */
    private long totalDescent;
    /**
     * 平均心率 bpm
     */
    private int avgHearRate;
    /**
     * 最大心率 bpm
     */
    private int maxHeartRate;
    /**
     * 平均踏频 rpm
     */
    private int avgCadence;
    /**
     * 最大踏频 rpm
     */
    private int maxCadence;
    /**
     * enhanced平均速度 m/s
     */
    private double enhancedAvgSpeed;
    /**
     * enhanced最大速度
     */
    private double enhancedMaxSpeed;
}
