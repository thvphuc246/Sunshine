package com.example.vinhphuc.udacitysunshine.sync;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by VINH PHUC on 20/3/2018.
 */

public class SunshineSyncIntentService extends IntentService {
    public SunshineSyncIntentService() {
        super("SunshineSyncIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SunshineSyncTask.syncWeather(this);
    }
}
