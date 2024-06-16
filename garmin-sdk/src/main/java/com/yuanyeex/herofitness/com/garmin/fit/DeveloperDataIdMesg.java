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



public class DeveloperDataIdMesg extends Mesg   {

    
    public static final int DeveloperIdFieldNum = 0;
    
    public static final int ApplicationIdFieldNum = 1;
    
    public static final int ManufacturerIdFieldNum = 2;
    
    public static final int DeveloperDataIndexFieldNum = 3;
    
    public static final int ApplicationVersionFieldNum = 4;
    

    protected static final  Mesg developerDataIdMesg;
    static {
        // developer_data_id
        developerDataIdMesg = new Mesg("developer_data_id", MesgNum.DEVELOPER_DATA_ID);
        developerDataIdMesg.addField(new Field("developer_id", DeveloperIdFieldNum, 13, 1, 0, "", false, Profile.Type.BYTE));
        
        developerDataIdMesg.addField(new Field("application_id", ApplicationIdFieldNum, 13, 1, 0, "", false, Profile.Type.BYTE));
        
        developerDataIdMesg.addField(new Field("manufacturer_id", ManufacturerIdFieldNum, 132, 1, 0, "", false, Profile.Type.MANUFACTURER));
        
        developerDataIdMesg.addField(new Field("developer_data_index", DeveloperDataIndexFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        developerDataIdMesg.addField(new Field("application_version", ApplicationVersionFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
    }

    public DeveloperDataIdMesg() {
        super(Factory.createMesg(MesgNum.DEVELOPER_DATA_ID));
    }

    public DeveloperDataIdMesg(final Mesg mesg) {
        super(mesg);
    }


    public Byte[] getDeveloperId() {
        
        return getFieldByteValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of developer_id
     */
    public int getNumDeveloperId() {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get developer_id field
     *
     * @param index of developer_id
     * @return developer_id
     */
    public Byte getDeveloperId(int index) {
        return getFieldByteValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set developer_id field
     *
     * @param index of developer_id
     * @param developerId The new developerId value to be set
     */
    public void setDeveloperId(int index, Byte developerId) {
        setFieldValue(0, index, developerId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Byte[] getApplicationId() {
        
        return getFieldByteValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of application_id
     */
    public int getNumApplicationId() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get application_id field
     *
     * @param index of application_id
     * @return application_id
     */
    public Byte getApplicationId(int index) {
        return getFieldByteValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set application_id field
     *
     * @param index of application_id
     * @param applicationId The new applicationId value to be set
     */
    public void setApplicationId(int index, Byte applicationId) {
        setFieldValue(1, index, applicationId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get manufacturer_id field
     *
     * @return manufacturer_id
     */
    public Integer getManufacturerId() {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set manufacturer_id field
     *
     * @param manufacturerId The new manufacturerId value to be set
     */
    public void setManufacturerId(Integer manufacturerId) {
        setFieldValue(2, 0, manufacturerId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get developer_data_index field
     *
     * @return developer_data_index
     */
    public Short getDeveloperDataIndex() {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set developer_data_index field
     *
     * @param developerDataIndex The new developerDataIndex value to be set
     */
    public void setDeveloperDataIndex(Short developerDataIndex) {
        setFieldValue(3, 0, developerDataIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get application_version field
     *
     * @return application_version
     */
    public Long getApplicationVersion() {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set application_version field
     *
     * @param applicationVersion The new applicationVersion value to be set
     */
    public void setApplicationVersion(Long applicationVersion) {
        setFieldValue(4, 0, applicationVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
