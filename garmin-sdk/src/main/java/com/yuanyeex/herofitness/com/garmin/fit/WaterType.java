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


public enum WaterType  {
    FRESH((short)0),
    SALT((short)1),
    EN13319((short)2),
    CUSTOM((short)3),
    INVALID((short)255);

    protected short value;

    private WaterType(short value) {
        this.value = value;
    }

    public static WaterType getByValue(final Short value) {
        for (final WaterType type : WaterType.values()) {
            if (value == type.value)
                return type;
        }

        return WaterType.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( WaterType value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
