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



public class ZonesTargetMesg extends Mesg   {

    
    public static final int MaxHeartRateFieldNum = 1;
    
    public static final int ThresholdHeartRateFieldNum = 2;
    
    public static final int FunctionalThresholdPowerFieldNum = 3;
    
    public static final int HrCalcTypeFieldNum = 5;
    
    public static final int PwrCalcTypeFieldNum = 7;
    

    protected static final  Mesg zonesTargetMesg;
    static {
        // zones_target
        zonesTargetMesg = new Mesg("zones_target", MesgNum.ZONES_TARGET);
        zonesTargetMesg.addField(new Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        zonesTargetMesg.addField(new Field("threshold_heart_rate", ThresholdHeartRateFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        zonesTargetMesg.addField(new Field("functional_threshold_power", FunctionalThresholdPowerFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        zonesTargetMesg.addField(new Field("hr_calc_type", HrCalcTypeFieldNum, 0, 1, 0, "", false, Profile.Type.HR_ZONE_CALC));
        
        zonesTargetMesg.addField(new Field("pwr_calc_type", PwrCalcTypeFieldNum, 0, 1, 0, "", false, Profile.Type.PWR_ZONE_CALC));
        
    }

    public ZonesTargetMesg() {
        super(Factory.createMesg(MesgNum.ZONES_TARGET));
    }

    public ZonesTargetMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get max_heart_rate field
     *
     * @return max_heart_rate
     */
    public Short getMaxHeartRate() {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set max_heart_rate field
     *
     * @param maxHeartRate The new maxHeartRate value to be set
     */
    public void setMaxHeartRate(Short maxHeartRate) {
        setFieldValue(1, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get threshold_heart_rate field
     *
     * @return threshold_heart_rate
     */
    public Short getThresholdHeartRate() {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set threshold_heart_rate field
     *
     * @param thresholdHeartRate The new thresholdHeartRate value to be set
     */
    public void setThresholdHeartRate(Short thresholdHeartRate) {
        setFieldValue(2, 0, thresholdHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get functional_threshold_power field
     *
     * @return functional_threshold_power
     */
    public Integer getFunctionalThresholdPower() {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set functional_threshold_power field
     *
     * @param functionalThresholdPower The new functionalThresholdPower value to be set
     */
    public void setFunctionalThresholdPower(Integer functionalThresholdPower) {
        setFieldValue(3, 0, functionalThresholdPower, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get hr_calc_type field
     *
     * @return hr_calc_type
     */
    public HrZoneCalc getHrCalcType() {
        Short value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return HrZoneCalc.getByValue(value);
    }

    /**
     * Set hr_calc_type field
     *
     * @param hrCalcType The new hrCalcType value to be set
     */
    public void setHrCalcType(HrZoneCalc hrCalcType) {
        setFieldValue(5, 0, hrCalcType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get pwr_calc_type field
     *
     * @return pwr_calc_type
     */
    public PwrZoneCalc getPwrCalcType() {
        Short value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return PwrZoneCalc.getByValue(value);
    }

    /**
     * Set pwr_calc_type field
     *
     * @param pwrCalcType The new pwrCalcType value to be set
     */
    public void setPwrCalcType(PwrZoneCalc pwrCalcType) {
        setFieldValue(7, 0, pwrCalcType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
