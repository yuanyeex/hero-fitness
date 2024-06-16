/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.141.0Release
// Tag = production/release/21.141.0-0-g2aa27e1
/////////////////////////////////////////////////////////////////////////////////////////////


package com.yuanyeex.herofitness.com.garmin.fit.util;

public final class SemicirclesConverter {
    static final double PI_RADIANS = 0x80000000L;

    static final double CONVERSION_FACTOR = 180.0 / PI_RADIANS;

    /**
     * Converts a value in semicircles to degrees.
     *
     * @param semicircles the value in semicircles
     * @return the converted value in degrees
     */
    public static double semicirclesToDegrees(int semicircles) {
        double degrees = 0.0;

        degrees = semicircles * CONVERSION_FACTOR;

        return degrees;
    }

    /**
     * Converts a value in degrees to semicircles.
     *
     * @param degrees the value in degrees
     * @return the converted value in semicircles.
     */
    public static int degreesToSemicircles(double degrees) {
        int semicircles = 0;

        semicircles = (int) (degrees / CONVERSION_FACTOR);

        return semicircles;
    }
}
