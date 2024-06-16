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


public enum DiveAlert  {
    NDL_REACHED((short)0),
    GAS_SWITCH_PROMPTED((short)1),
    NEAR_SURFACE((short)2),
    APPROACHING_NDL((short)3),
    PO2_WARN((short)4),
    PO2_CRIT_HIGH((short)5),
    PO2_CRIT_LOW((short)6),
    TIME_ALERT((short)7),
    DEPTH_ALERT((short)8),
    DECO_CEILING_BROKEN((short)9),
    DECO_COMPLETE((short)10),
    SAFETY_STOP_BROKEN((short)11),
    SAFETY_STOP_COMPLETE((short)12),
    CNS_WARNING((short)13),
    CNS_CRITICAL((short)14),
    OTU_WARNING((short)15),
    OTU_CRITICAL((short)16),
    ASCENT_CRITICAL((short)17),
    ALERT_DISMISSED_BY_KEY((short)18),
    ALERT_DISMISSED_BY_TIMEOUT((short)19),
    BATTERY_LOW((short)20),
    BATTERY_CRITICAL((short)21),
    SAFETY_STOP_STARTED((short)22),
    APPROACHING_FIRST_DECO_STOP((short)23),
    SETPOINT_SWITCH_AUTO_LOW((short)24),
    SETPOINT_SWITCH_AUTO_HIGH((short)25),
    SETPOINT_SWITCH_MANUAL_LOW((short)26),
    SETPOINT_SWITCH_MANUAL_HIGH((short)27),
    AUTO_SETPOINT_SWITCH_IGNORED((short)28),
    SWITCHED_TO_OPEN_CIRCUIT((short)29),
    SWITCHED_TO_CLOSED_CIRCUIT((short)30),
    TANK_BATTERY_LOW((short)32),
    PO2_CCR_DIL_LOW((short)33),
    DECO_STOP_CLEARED((short)34),
    APNEA_NEUTRAL_BUOYANCY((short)35),
    APNEA_TARGET_DEPTH((short)36),
    APNEA_SURFACE((short)37),
    APNEA_HIGH_SPEED((short)38),
    APNEA_LOW_SPEED((short)39),
    INVALID((short)255);

    protected short value;

    private DiveAlert(short value) {
        this.value = value;
    }

    public static DiveAlert getByValue(final Short value) {
        for (final DiveAlert type : DiveAlert.values()) {
            if (value == type.value)
                return type;
        }

        return DiveAlert.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( DiveAlert value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
