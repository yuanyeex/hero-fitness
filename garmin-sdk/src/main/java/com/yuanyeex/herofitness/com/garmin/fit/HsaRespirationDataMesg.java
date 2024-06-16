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



public class HsaRespirationDataMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int ProcessingIntervalFieldNum = 0;
    
    public static final int RespirationRateFieldNum = 1;
    

    protected static final  Mesg hsaRespirationDataMesg;
    static {
        // hsa_respiration_data
        hsaRespirationDataMesg = new Mesg("hsa_respiration_data", MesgNum.HSA_RESPIRATION_DATA);
        hsaRespirationDataMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        hsaRespirationDataMesg.addField(new Field("processing_interval", ProcessingIntervalFieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        
        hsaRespirationDataMesg.addField(new Field("respiration_rate", RespirationRateFieldNum, 131, 100, 0, "breaths/min", false, Profile.Type.SINT16));
        
    }

    public HsaRespirationDataMesg() {
        super(Factory.createMesg(MesgNum.HSA_RESPIRATION_DATA));
    }

    public HsaRespirationDataMesg(final Mesg mesg) {
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
     * Get processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @return processing_interval
     */
    public Integer getProcessingInterval() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @param processingInterval The new processingInterval value to be set
     */
    public void setProcessingInterval(Integer processingInterval) {
        setFieldValue(0, 0, processingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getRespirationRate() {
        
        return getFieldFloatValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of respiration_rate
     */
    public int getNumRespirationRate() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get respiration_rate field
     * Units: breaths/min
     * Comment: Breaths * 100 /min -300 indicates invalid -200 indicates large motion -100 indicates off wrist
     *
     * @param index of respiration_rate
     * @return respiration_rate
     */
    public Float getRespirationRate(int index) {
        return getFieldFloatValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set respiration_rate field
     * Units: breaths/min
     * Comment: Breaths * 100 /min -300 indicates invalid -200 indicates large motion -100 indicates off wrist
     *
     * @param index of respiration_rate
     * @param respirationRate The new respirationRate value to be set
     */
    public void setRespirationRate(int index, Float respirationRate) {
        setFieldValue(1, index, respirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
