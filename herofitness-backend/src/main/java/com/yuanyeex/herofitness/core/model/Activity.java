package com.yuanyeex.herofitness.core.model;

import java.util.List;

public class Activity {
    private Long id;
    private String name;
    private String description;

    private SportType sportType;

    private ActivitySummary activitySummary;
    private List<SerialData<?>> details;
}
