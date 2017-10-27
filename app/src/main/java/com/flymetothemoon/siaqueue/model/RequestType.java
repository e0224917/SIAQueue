package com.flymetothemoon.siaqueue.model;

import android.content.Context;
import android.content.res.Resources;

import com.flymetothemoon.siaqueue.R;

/**
 * Created by nhatton on 10/27/17.
 */

public enum RequestType {
    reservation_ticketing,
    schedule_aircraft_change,
    krisflyer_pps,
    special_handling,
    silkair,
    travel_agent,
    others;

    public String getLabel(Context context) {
        Resources res = context.getResources();
        return res.getStringArray(R.array.request_types)[this.ordinal()];
    }

    public String[] getList(Context context) {
        Resources res = context.getResources();
        return res.getStringArray(res.getIdentifier(this.name(), "array", context.getPackageName()));
    }
}
