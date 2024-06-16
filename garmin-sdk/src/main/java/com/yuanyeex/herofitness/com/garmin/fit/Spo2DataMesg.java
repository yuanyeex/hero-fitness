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



public class Spo2DataMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int ReadingSpo2FieldNum = 0;
    
    public static final int ReadingConfidenceFieldNum = 1;
    
    public static final int ModeFieldNum = 2;
    

    protected static final  Mesg spo2DataMesg;
    static {
        // spo2_data
        spo2DataMesg = new Mesg("spo2_data", MesgNum.SPO2_DATA);
        spo2DataMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        spo2DataMesg.addField(new Field("reading_spo2", ReadingSpo2FieldNum, 2, 1, 0, "percent", false, Profile.Type.UINT8));
        
        spo2DataMesg.addField(new Field("reading_confidence", ReadingConfidenceFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        spo2DataMesg.addField(new Field("mode", ModeFieldNum, 0, 1, 0, "", false, Profile.Type.SPO2_MEASUREMENT_TYPE));
        
    }

    public Spo2DataMesg() {
        super(Factory.createMesg(MesgNum.SPO2_DATA));
    }

    public Spo2DataMesg(final Mesg mesg) {
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
     * Get reading_spo2 field
     * Units: percent
     *
     * @return reading_spo2
     */
    public Short getReadingSpo2() {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set reading_spo2 field
     * Units: percent
     *
     * @param readingSpo2 The new readingSpo2 value to be set
     */
    public void setReadingSpo2(Short readingSpo2) {
        setFieldValue(0, 0, readingSpo2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get reading_confidence field
     *
     * @return reading_confidence
     */
    public Short getReadingConfidence() {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set reading_confidence field
     *
     * @param readingConfidence The new readingConfidence value to be set
     */
    public void setReadingConfidence(Short readingConfidence) {
        setFieldValue(1, 0, readingConfidence, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get mode field
     * Comment: Mode when data was captured
     *
     * @return mode
     */
    public Spo2MeasurementType getMode() {
        Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Spo2MeasurementType.getByValue(value);
    }

    /**
     * Set mode field
     * Comment: Mode when data was captured
     *
     * @param mode The new mode value to be set
     */
    public void setMode(Spo2MeasurementType mode) {
        setFieldValue(2, 0, mode.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}