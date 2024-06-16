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



public class SegmentFileMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int FileUuidFieldNum = 1;
    
    public static final int EnabledFieldNum = 3;
    
    public static final int UserProfilePrimaryKeyFieldNum = 4;
    
    public static final int LeaderTypeFieldNum = 7;
    
    public static final int LeaderGroupPrimaryKeyFieldNum = 8;
    
    public static final int LeaderActivityIdFieldNum = 9;
    
    public static final int LeaderActivityIdStringFieldNum = 10;
    
    public static final int DefaultRaceLeaderFieldNum = 11;
    

    protected static final  Mesg segmentFileMesg;
    static {
        // segment_file
        segmentFileMesg = new Mesg("segment_file", MesgNum.SEGMENT_FILE);
        segmentFileMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        segmentFileMesg.addField(new Field("file_uuid", FileUuidFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        segmentFileMesg.addField(new Field("enabled", EnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        segmentFileMesg.addField(new Field("user_profile_primary_key", UserProfilePrimaryKeyFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        segmentFileMesg.addField(new Field("leader_type", LeaderTypeFieldNum, 0, 1, 0, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE));
        
        segmentFileMesg.addField(new Field("leader_group_primary_key", LeaderGroupPrimaryKeyFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        segmentFileMesg.addField(new Field("leader_activity_id", LeaderActivityIdFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        segmentFileMesg.addField(new Field("leader_activity_id_string", LeaderActivityIdStringFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        segmentFileMesg.addField(new Field("default_race_leader", DefaultRaceLeaderFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
    }

    public SegmentFileMesg() {
        super(Factory.createMesg(MesgNum.SEGMENT_FILE));
    }

    public SegmentFileMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get file_uuid field
     * Comment: UUID of the segment file
     *
     * @return file_uuid
     */
    public String getFileUuid() {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set file_uuid field
     * Comment: UUID of the segment file
     *
     * @param fileUuid The new fileUuid value to be set
     */
    public void setFileUuid(String fileUuid) {
        setFieldValue(1, 0, fileUuid, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get enabled field
     * Comment: Enabled state of the segment file
     *
     * @return enabled
     */
    public Bool getEnabled() {
        Short value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set enabled field
     * Comment: Enabled state of the segment file
     *
     * @param enabled The new enabled value to be set
     */
    public void setEnabled(Bool enabled) {
        setFieldValue(3, 0, enabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get user_profile_primary_key field
     * Comment: Primary key of the user that created the segment file
     *
     * @return user_profile_primary_key
     */
    public Long getUserProfilePrimaryKey() {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set user_profile_primary_key field
     * Comment: Primary key of the user that created the segment file
     *
     * @param userProfilePrimaryKey The new userProfilePrimaryKey value to be set
     */
    public void setUserProfilePrimaryKey(Long userProfilePrimaryKey) {
        setFieldValue(4, 0, userProfilePrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public SegmentLeaderboardType[] getLeaderType() {
        
        Short[] values = getFieldShortValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        SegmentLeaderboardType[] rv = new SegmentLeaderboardType[values.length];
        for(int i = 0; i < values.length; i++){
            rv[i] = SegmentLeaderboardType.getByValue(values[i]);
        }
        return rv;
        
    }

    /**
     * @return number of leader_type
     */
    public int getNumLeaderType() {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get leader_type field
     * Comment: Leader type of each leader in the segment file
     *
     * @param index of leader_type
     * @return leader_type
     */
    public SegmentLeaderboardType getLeaderType(int index) {
        Short value = getFieldShortValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SegmentLeaderboardType.getByValue(value);
    }

    /**
     * Set leader_type field
     * Comment: Leader type of each leader in the segment file
     *
     * @param index of leader_type
     * @param leaderType The new leaderType value to be set
     */
    public void setLeaderType(int index, SegmentLeaderboardType leaderType) {
        setFieldValue(7, index, leaderType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Long[] getLeaderGroupPrimaryKey() {
        
        return getFieldLongValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of leader_group_primary_key
     */
    public int getNumLeaderGroupPrimaryKey() {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get leader_group_primary_key field
     * Comment: Group primary key of each leader in the segment file
     *
     * @param index of leader_group_primary_key
     * @return leader_group_primary_key
     */
    public Long getLeaderGroupPrimaryKey(int index) {
        return getFieldLongValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set leader_group_primary_key field
     * Comment: Group primary key of each leader in the segment file
     *
     * @param index of leader_group_primary_key
     * @param leaderGroupPrimaryKey The new leaderGroupPrimaryKey value to be set
     */
    public void setLeaderGroupPrimaryKey(int index, Long leaderGroupPrimaryKey) {
        setFieldValue(8, index, leaderGroupPrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Long[] getLeaderActivityId() {
        
        return getFieldLongValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of leader_activity_id
     */
    public int getNumLeaderActivityId() {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get leader_activity_id field
     * Comment: Activity ID of each leader in the segment file
     *
     * @param index of leader_activity_id
     * @return leader_activity_id
     */
    public Long getLeaderActivityId(int index) {
        return getFieldLongValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set leader_activity_id field
     * Comment: Activity ID of each leader in the segment file
     *
     * @param index of leader_activity_id
     * @param leaderActivityId The new leaderActivityId value to be set
     */
    public void setLeaderActivityId(int index, Long leaderActivityId) {
        setFieldValue(9, index, leaderActivityId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public String[] getLeaderActivityIdString() {
        
        return getFieldStringValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of leader_activity_id_string
     */
    public int getNumLeaderActivityIdString() {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get leader_activity_id_string field
     * Comment: String version of the activity ID of each leader in the segment file. 21 characters long for each ID, express in decimal
     *
     * @param index of leader_activity_id_string
     * @return leader_activity_id_string
     */
    public String getLeaderActivityIdString(int index) {
        return getFieldStringValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set leader_activity_id_string field
     * Comment: String version of the activity ID of each leader in the segment file. 21 characters long for each ID, express in decimal
     *
     * @param index of leader_activity_id_string
     * @param leaderActivityIdString The new leaderActivityIdString value to be set
     */
    public void setLeaderActivityIdString(int index, String leaderActivityIdString) {
        setFieldValue(10, index, leaderActivityIdString, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get default_race_leader field
     * Comment: Index for the Leader Board entry selected as the default race participant
     *
     * @return default_race_leader
     */
    public Short getDefaultRaceLeader() {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set default_race_leader field
     * Comment: Index for the Leader Board entry selected as the default race participant
     *
     * @param defaultRaceLeader The new defaultRaceLeader value to be set
     */
    public void setDefaultRaceLeader(Short defaultRaceLeader) {
        setFieldValue(11, 0, defaultRaceLeader, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
