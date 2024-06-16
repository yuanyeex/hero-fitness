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



public class BarometerDataMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int TimestampMsFieldNum = 0;
    
    public static final int SampleTimeOffsetFieldNum = 1;
    
    public static final int BaroPresFieldNum = 2;
    

    protected static final  Mesg barometerDataMesg;
    static {
        // barometer_data
        barometerDataMesg = new Mesg("barometer_data", MesgNum.BAROMETER_DATA);
        barometerDataMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        barometerDataMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        barometerDataMesg.addField(new Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        barometerDataMesg.addField(new Field("baro_pres", BaroPresFieldNum, 134, 1, 0, "Pa", false, Profile.Type.UINT32));
        
    }

    public BarometerDataMesg() {
        super(Factory.createMesg(MesgNum.BAROMETER_DATA));
    }

    public BarometerDataMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @return timestamp_ms
     */
    public Integer getTimestampMs() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @param timestampMs The new timestampMs value to be set
     */
    public void setTimestampMs(Integer timestampMs) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Integer[] getSampleTimeOffset() {
        
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of sample_time_offset
     */
    public int getNumSampleTimeOffset() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the barometer sample with the corrosponding index was taken. The samples may span across seconds. Array size must match the number of samples in baro_cal
     *
     * @param index of sample_time_offset
     * @return sample_time_offset
     */
    public Integer getSampleTimeOffset(int index) {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the barometer sample with the corrosponding index was taken. The samples may span across seconds. Array size must match the number of samples in baro_cal
     *
     * @param index of sample_time_offset
     * @param sampleTimeOffset The new sampleTimeOffset value to be set
     */
    public void setSampleTimeOffset(int index, Integer sampleTimeOffset) {
        setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Long[] getBaroPres() {
        
        return getFieldLongValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of baro_pres
     */
    public int getNumBaroPres() {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get baro_pres field
     * Units: Pa
     * Comment: These are the raw ADC reading. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of baro_pres
     * @return baro_pres
     */
    public Long getBaroPres(int index) {
        return getFieldLongValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set baro_pres field
     * Units: Pa
     * Comment: These are the raw ADC reading. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of baro_pres
     * @param baroPres The new baroPres value to be set
     */
    public void setBaroPres(int index, Long baroPres) {
        setFieldValue(2, index, baroPres, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
