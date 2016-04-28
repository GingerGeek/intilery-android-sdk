package com.intilery.android.sdk;

import android.os.Bundle;

import com.intilery.android.sdk.obj.EventData;
import com.intilery.android.sdk.obj.IntileryEvent;
import com.intilery.android.sdk.util.MapBuilder;

/**
 * Created by zed on 28/04/2016.
 */
public class IntileryQuickCall {


    public void openDueToNotification(String intileryID) {
        Intilery.i().getIo().track(IntileryEvent.builder().eventData(EventData.builder("Notification cause App Open").data("campaign", new MapBuilder<String,Object>().put("email-id", intileryID).build()).build()).build());

    }

    public void notificationHook(String thing, Bundle data) {
        Intilery.i().getIo().track(IntileryEvent.builder().eventData(EventData.builder("Notification received").data("campaign", new MapBuilder<String,Object>().put("email-id",data.getString("__intilery-campaign-email-id")).build()).build()).build());
    }

    public void appOpen() {
        Intilery.i().getIo().track(IntileryEvent.builder().eventData(
                EventData.builder("App open").build()
        ).build());

    }

}
