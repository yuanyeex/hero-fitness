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



public class TankSummaryMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int SensorFieldNum = 0;
    
    public static final int StartPressureFieldNum = 1;
    
    public static final int EndPressureFieldNum = 2;
    
    public static final int VolumeUsedFieldNum = 3;
    

    protected static final  Mesg tankSummaryMesg;
    static {
        // tank_summary
        tankSummaryMesg = new Mesg("tank_summary", MesgNum.TANK_SUMMARY);
        tankSummaryMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        tankSummaryMesg.addField(new Field("sensor", SensorFieldNum, 140, 1, 0, "", false, Profile.Type.ANT_CHANNEL_ID));
        
        tankSummaryMesg.addField(new Field("start_pressure", StartPressureFieldNum, 132, 100, 0, "bar", false, Profile.Type.UINT16));
        
        tankSummaryMesg.addField(new Field("end_pressure", EndPressureFieldNum, 132, 100, 0, "bar", false, Profile.Type.UINT16));
        
        tankSummaryMesg.addField(new Field("volume_used", VolumeUsedFieldNum, 134, 100, 0, "L", false, Profile.Type.UINT32));
        
    }

    public TankSummaryMesg() {
        super(Factory.createMesg(MesgNum.TANK_SUMMARY));
    }

    public TankSummaryMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sensor field
     *
     * @return sensor
     */
    public Long getSensor() {
        return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sensor field
     *
     * @param sensor The new sensor value to be set
     */
    public void setSensor(Long sensor) {
        setFieldValue(0, 0, sensor, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get start_pressure field
     * Units: bar
     *
     * @return start_pressure
     */
    public Float getStartPressure() {
        return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set start_pressure field
     * Units: bar
     *
     * @param startPressure The new startPressure value to be set
     */
    public void setStartPressure(Float startPressure) {
        setFieldValue(1, 0, startPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get end_pressure field
     * Units: bar
     *
     * @return end_pressure
     */
    public Float getEndPressure() {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set end_pressure field
     * Units: bar
     *
     * @param endPressure The new endPressure value to be set
     */
    public void setEndPressure(Float endPressure) {
        setFieldValue(2, 0, endPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get volume_used field
     * Units: L
     *
     * @return volume_used
     */
    public Float getVolumeUsed() {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set volume_used field
     * Units: L
     *
     * @param volumeUsed The new volumeUsed value to be set
     */
    public void setVolumeUsed(Float volumeUsed) {
        setFieldValue(3, 0, volumeUsed, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
