package com.yuanyeex.herofitness.infra.fit;

import com.yuanyeex.herofitness.com.garmin.fit.ActivityMesg;
import com.yuanyeex.herofitness.com.garmin.fit.FitDecoder;
import com.yuanyeex.herofitness.com.garmin.fit.FitMessages;
import com.yuanyeex.herofitness.com.garmin.fit.SessionMesg;
import com.yuanyeex.herofitness.core.model.Activity;
import com.yuanyeex.herofitness.core.model.ActivitySummary;
import com.yuanyeex.herofitness.core.model.CyclingSummary;
import com.yuanyeex.herofitness.core.model.LatitudeAndLongitude;
import com.yuanyeex.herofitness.core.service.ActivityParser;

import java.io.*;
import java.util.List;

// Data,4,record,
// timestamp,"1087305775",s,
// position_lat,"365881036",semicircles,
// position_long,"1240506464",semicircles,
// distance,"168.2",m,
// altitude,"582.0",m,
// speed,"3.6",m/s,
// power,"0",watts,
// heart_rate,"106",bpm,
// cadence,"31",rpm,
// temperature,"27",C,
// enhanced_altitude,"582.0",m,
// enhanced_speed,"3.6",m/s
// ,,,,

/**
 * 需要提取的信息：
 * 1.
 */
public class FitActivityParser implements ActivityParser {

    @Override
    public void parse(InputStream is) {
        FitDecoder fitDecoder = new FitDecoder();
        FitMessages fitMessages = fitDecoder.decode(is);
        convertToActivity(fitMessages);
    }


    private Activity convertToActivity(FitMessages fitMessages) {
        System.out.println(fitMessages);
        List<ActivityMesg> activityMesgs = fitMessages.getActivityMesgs();
        return new Activity();
    }

    private ActivitySummary composeActivitySummary(FitMessages fitMessages) {
        List<SessionMesg> sessionMesgs = fitMessages.getSessionMesgs();
        CyclingSummary cyclingSummary = new CyclingSummary();
        if (sessionMesgs == null || sessionMesgs.isEmpty()) {
            return cyclingSummary;
        }
        // 只取一个活动session，假设只有一个session
        SessionMesg sessionMesg = sessionMesgs.get(0);
        cyclingSummary.setTimestamp(sessionMesg.getTimestamp().getTimestamp())
                .setStartTime(sessionMesg.getStartTime().getTimestamp())
                .setStartPosition(LatitudeAndLongitude)
    }
}

