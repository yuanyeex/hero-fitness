package com.yuanyeex.herofitness.core.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public abstract class SerialData<T> {
    private Long activityId;
    private List<T> data;
    private double scale;
    private String unit;

    public abstract SerialType getSerialType();

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class RestingSerialData extends SerialData<Bool> {
        private final SerialType serialType = SerialType.resting;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class AltitudeSerialData extends SerialData<Double> {
        private final SerialType serialType = SerialType.altitude;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class HeartRateSerialData extends SerialData<Integer> {
        private final SerialType serialType = SerialType.heartrate;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class CadenceSerialData extends SerialData<Integer> {
        private final SerialType serialType = SerialType.cadence;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class TemperatureSerialData extends SerialData<Double> {
        private final SerialType serialType = SerialType.temp;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class DistanceSerialData extends SerialData<Double> {
        private final SerialType serialType = SerialType.distance;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class GradeSmoothSerialData extends SerialData<Double> {
        private final SerialType serialType = SerialType.grade_smooth;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class TimeSerialData extends SerialData<Long> {
        private final SerialType serialType = SerialType.time;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class GradeAdjustedDistanceSerialData extends SerialData<Double> {
        private final SerialType serialType = SerialType.grade_adjusted_distance;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class WattsCalcSerialData extends SerialData<Integer> {
        private final SerialType serialType = SerialType.watts_calc;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class LatitudeAndLongitudeSerialData extends SerialData<LatitudeAndLongitude> {
        private final SerialType serialType = SerialType.lati_longi;
    }
}
