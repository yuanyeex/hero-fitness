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


package com.yuanyeex.herofitness.com.garmin.fit.csv;

import com.yuanyeex.herofitness.com.garmin.fit.BufferedMesgListener;
import com.yuanyeex.herofitness.com.garmin.fit.Mesg;
import com.yuanyeex.herofitness.com.garmin.fit.MesgListener;
import com.yuanyeex.herofitness.com.garmin.fit.MesgSource;

import java.util.ArrayList;
import java.util.List;

public class CSVDataMesgFieldCounter implements BufferedMesgListener, MesgSource {
    private final ArrayList<MesgListener> mesgListeners = new ArrayList<MesgListener>();
    private final ArrayList<Mesg> mesgs = new ArrayList<>();
    private int maxNumFields = 0;

    public CSVDataMesgFieldCounter() {
    }

    @Override
    public void onMesg(Mesg mesg) {
        mesgs.add(mesg);

        if (mesg.getNumFields() > maxNumFields) {
            maxNumFields = mesg.getNumFields();
        }

    }

    @Override
    public void flushMesgs() {
        flushMesgs(mesgs);
    }

    @Override
    public void addListener(MesgListener mesgListener) {
        if ((mesgListener != null) && !mesgListeners.contains(mesgListener)) {
            mesgListeners.add(mesgListener);
        }
    }

    private void flushMesg(Mesg mesg) {
        mesgListeners.forEach(mesgListener -> mesgListener.onMesg(mesg));
    }

    private void flushMesgs(List<? extends Mesg> mesgs) {
        mesgs.forEach(mesg -> flushMesg(mesg));
    }

    public int getMaxNumFields() {
        return maxNumFields;
    }
}
