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

    private boolean[] list1 = {false, false, true, true, true, true, true, true, true, true, true, false};
    private boolean[] list2 = {true, true, true, true, true};
    private boolean[] list3 = {false, false, false, false, false, false, false, false, false};
    private boolean[] list4 = {true, true, true, true, false};
    private boolean[] list5 = {false, false, false, false, false, false, false, false, false, false};
    private boolean[] list6 = {false, false, false, false, false, false};

    public String getLabel(Context context) {
        Resources res = context.getResources();
        return res.getStringArray(R.array.request_types)[this.ordinal()];
    }

    public String[] getList(Context context) {
        Resources res = context.getResources();
        return res.getStringArray(res.getIdentifier(this.name(), "array", context.getPackageName()));
    }

    public boolean[] getPNRrequiredList() {
        switch (this.ordinal()) {
            case 0:
                return list1;
            case 1:
                return list2;
            case 2:
                return list3;
            case 3:
                return list4;
            case 4:
                return list5;
            case 5:
                return list6;
            default:
                return null;
        }

    }
}
