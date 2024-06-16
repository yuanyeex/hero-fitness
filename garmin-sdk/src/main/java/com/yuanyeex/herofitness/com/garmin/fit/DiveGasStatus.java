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


public enum DiveGasStatus  {
    DISABLED((short)0),
    ENABLED((short)1),
    BACKUP_ONLY((short)2),
    INVALID((short)255);

    protected short value;

    private DiveGasStatus(short value) {
        this.value = value;
    }

    public static DiveGasStatus getByValue(final Short value) {
        for (final DiveGasStatus type : DiveGasStatus.values()) {
            if (value == type.value)
                return type;
        }

        return DiveGasStatus.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( DiveGasStatus value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
