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


public enum BikeLightNetworkConfigType  {
    AUTO((short)0),
    INDIVIDUAL((short)4),
    HIGH_VISIBILITY((short)5),
    TRAIL((short)6),
    INVALID((short)255);

    protected short value;

    private BikeLightNetworkConfigType(short value) {
        this.value = value;
    }

    public static BikeLightNetworkConfigType getByValue(final Short value) {
        for (final BikeLightNetworkConfigType type : BikeLightNetworkConfigType.values()) {
            if (value == type.value)
                return type;
        }

        return BikeLightNetworkConfigType.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( BikeLightNetworkConfigType value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
