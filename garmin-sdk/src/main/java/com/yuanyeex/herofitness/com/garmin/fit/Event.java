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


public enum Event  {
    TIMER((short)0),
    WORKOUT((short)3),
    WORKOUT_STEP((short)4),
    POWER_DOWN((short)5),
    POWER_UP((short)6),
    OFF_COURSE((short)7),
    SESSION((short)8),
    LAP((short)9),
    COURSE_POINT((short)10),
    BATTERY((short)11),
    VIRTUAL_PARTNER_PACE((short)12),
    HR_HIGH_ALERT((short)13),
    HR_LOW_ALERT((short)14),
    SPEED_HIGH_ALERT((short)15),
    SPEED_LOW_ALERT((short)16),
    CAD_HIGH_ALERT((short)17),
    CAD_LOW_ALERT((short)18),
    POWER_HIGH_ALERT((short)19),
    POWER_LOW_ALERT((short)20),
    RECOVERY_HR((short)21),
    BATTERY_LOW((short)22),
    TIME_DURATION_ALERT((short)23),
    DISTANCE_DURATION_ALERT((short)24),
    CALORIE_DURATION_ALERT((short)25),
    ACTIVITY((short)26),
    FITNESS_EQUIPMENT((short)27),
    LENGTH((short)28),
    USER_MARKER((short)32),
    SPORT_POINT((short)33),
    CALIBRATION((short)36),
    FRONT_GEAR_CHANGE((short)42),
    REAR_GEAR_CHANGE((short)43),
    RIDER_POSITION_CHANGE((short)44),
    ELEV_HIGH_ALERT((short)45),
    ELEV_LOW_ALERT((short)46),
    COMM_TIMEOUT((short)47),
    AUTO_ACTIVITY_DETECT((short)54),
    DIVE_ALERT((short)56),
    DIVE_GAS_SWITCHED((short)57),
    TANK_PRESSURE_RESERVE((short)71),
    TANK_PRESSURE_CRITICAL((short)72),
    TANK_LOST((short)73),
    RADAR_THREAT_ALERT((short)75),
    TANK_BATTERY_LOW((short)76),
    TANK_POD_CONNECTED((short)81),
    TANK_POD_DISCONNECTED((short)82),
    INVALID((short)255);

    protected short value;

    private Event(short value) {
        this.value = value;
    }

    public static Event getByValue(final Short value) {
        for (final Event type : Event.values()) {
            if (value == type.value)
                return type;
        }

        return Event.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( Event value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
