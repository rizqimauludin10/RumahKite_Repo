package com.example.rumahkite;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceTranstitonService extends IntentService {


    public GeofenceTranstitonService() {
        super("GeofenceTranstitonService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            Toast.makeText(this, "Geo Gagal", Toast.LENGTH_LONG).show();
        } else {
            int transition = geofencingEvent.getGeofenceTransition();
            List<Geofence> geofenceList = geofencingEvent.getTriggeringGeofences();
            Geofence geofence = geofenceList.get(0);
            String requestId = geofence.getRequestId();
            if (transition == Geofence.GEOFENCE_TRANSITION_ENTER || transition == Geofence.GEOFENCE_TRANSITION_EXIT) {
                Toast.makeText(this,"mantaaap", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"eror", Toast.LENGTH_LONG).show();
            }


        }
    }
}

//    private String getGeofenceTransitionDetails(
//        int geofenceTransition,
//        List<Geofence> trigge