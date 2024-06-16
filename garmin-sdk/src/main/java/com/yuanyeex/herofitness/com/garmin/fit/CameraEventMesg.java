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



public class CameraEventMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int TimestampMsFieldNum = 0;
    
    public static final int CameraEventTypeFieldNum = 1;
    
    public static final int CameraFileUuidFieldNum = 2;
    
    public static final int CameraOrientationFieldNum = 3;
    

    protected static final  Mesg cameraEventMesg;
    static {
        // camera_event
        cameraEventMesg = new Mesg("camera_event", MesgNum.CAMERA_EVENT);
        cameraEventMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        cameraEventMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        cameraEventMesg.addField(new Field("camera_event_type", CameraEventTypeFieldNum, 0, 1, 0, "", false, Profile.Type.CAMERA_EVENT_TYPE));
        
        cameraEventMesg.addField(new Field("camera_file_uuid", CameraFileUuidFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        cameraEventMesg.addField(new Field("camera_orientation", CameraOrientationFieldNum, 0, 1, 0, "", false, Profile.Type.CAMERA_ORIENTATION_TYPE));
        
    }

    public CameraEventMesg() {
        super(Factory.createMesg(MesgNum.CAMERA_EVENT));
    }

    public CameraEventMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
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

    /**
     * Get camera_event_type field
     *
     * @return camera_event_type
     */
    public CameraEventType getCameraEventType() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return CameraEventType.getByValue(value);
    }

    /**
     * Set camera_event_type field
     *
     * @param cameraEventType The new cameraEventType value to be set
     */
    public void setCameraEventType(CameraEventType cameraEventType) {
        setFieldValue(1, 0, cameraEventType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get camera_file_uuid field
     *
     * @return camera_file_uuid
     */
    public String getCameraFileUuid() {
        return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set camera_file_uuid field
     *
     * @param cameraFileUuid The new cameraFileUuid value to be set
     */
    public void setCameraFileUuid(String cameraFileUuid) {
        setFieldValue(2, 0, cameraFileUuid, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get camera_orientation field
     *
     * @return camera_orientation
     */
    public CameraOrientationType getCameraOrientation() {
        Short value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return CameraOrientationType.getByValue(value);
    }

    /**
     * Set camera_orientation field
     *
     * @param cameraOrientation The new cameraOrientation value to be set
     */
    public void setCameraOrientation(CameraOrientationType cameraOrientation) {
        setFieldValue(3, 0, cameraOrientation.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
