package com.yuanyeex.herofitness.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LatitudeAndLongitude {
    private double latitude;
    private double longitude;
}
