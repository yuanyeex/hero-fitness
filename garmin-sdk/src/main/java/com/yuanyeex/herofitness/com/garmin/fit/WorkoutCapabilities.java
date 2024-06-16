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


package com.yuanyeex.herofitness.com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

public class WorkoutCapabilities  {
    public static final long INTERVAL = 0x00000001;
    public static final long CUSTOM = 0x00000002;
    public static final long FITNESS_EQUIPMENT = 0x00000004;
    public static final long FIRSTBEAT = 0x00000008;
    public static final long NEW_LEAF = 0x00000010;
    public static final long TCX = 0x00000020; // For backwards compatibility. Watch should add missing id fields then clear flag.
    public static final long SPEED = 0x00000080; // Speed source required for workout step.
    public static final long HEART_RATE = 0x00000100; // Heart rate source required for workout step.
    public static final long DISTANCE = 0x00000200; // Distance source required for workout step.
    public static final long CADENCE = 0x00000400; // Cadence source required for workout step.
    public static final long POWER = 0x00000800; // Power source required for workout step.
    public static final long GRADE = 0x00001000; // Grade source required for workout step.
    public static final long RESISTANCE = 0x00002000; // Resistance source required for workout step.
    public static final long PROTECTED = 0x00004000;
    public static final long INVALID = Fit.UINT32Z_INVALID;

    private static final Map<Long, String> stringMap;

    static {
        stringMap = new HashMap<Long, String>();
        stringMap.put(INTERVAL, "INTERVAL");
        stringMap.put(CUSTOM, "CUSTOM");
        stringMap.put(FITNESS_EQUIPMENT, "FITNESS_EQUIPMENT");
        stringMap.put(FIRSTBEAT, "FIRSTBEAT");
        stringMap.put(NEW_LEAF, "NEW_LEAF");
        stringMap.put(TCX, "TCX");
        stringMap.put(SPEED, "SPEED");
        stringMap.put(HEART_RATE, "HEART_RATE");
        stringMap.put(DISTANCE, "DISTANCE");
        stringMap.put(CADENCE, "CADENCE");
        stringMap.put(POWER, "POWER");
        stringMap.put(GRADE, "GRADE");
        stringMap.put(RESISTANCE, "RESISTANCE");
        stringMap.put(PROTECTED, "PROTECTED");
    }


    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    public static String getStringFromValue( Long value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Returns the enum constant with the specified name.
     * @param value The enum string value
     * @return The enum constant or INVALID if unknown
     */
    public static Long getValueFromString( String value ) {
        for( Map.Entry<Long, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
