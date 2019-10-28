package com.example.rumahkite.fragment;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.rumahkite.GeofenceTranstitonService;
import com.example.rumahkite.MapsActivity;
import com.example.rumahkite.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class TabMapsFragment extends Fragment implements OnMapReadyCallback {

    View param;
    PendingIntent pendingIntent;
    GeofencingRequest geofencingRequest;
    GeofencingClient geofencingClient;
    Geofence geofenceList;
    private GoogleMap mMap;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int req = 101;
    Float rad = 900f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        param = inflater.inflate(R.layout.fragment_maps, container, false);
        geofencingClient = LocationServices.getGeofencingClient(getActivity());
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        getLastLocation();
        return param;

    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION }, req);

            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null) {
                    currentLocation = location;
                    Double latitude = currentLocation.getLatitude();
                    Double longitude = currentLocation.getLongitude();

                    // Toast.makeText(getApplicationContext(),latitude+""+longitude,Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
                    supportMapFragment.getMapAsync(TabMapsFragment.this);
                }
            }
        });

    }

    public void buildGeofence() {
        geofenceList = (new Geofence.Builder()
                .setRequestId("Okeee")
                .setCircularRegion(
                        -0.016854,
                        109.312225,
                        900f
                )
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)
                .setNotificationResponsiveness(0)
                .build());

    }

    public GeofencingRequest getGeofencingRequest() {
        geofencingRequest = (new GeofencingRequest.Builder()
                .setInitialTrigger(Geofence.GEOFENCE_TRANSITION_ENTER)
                .addGeofence(geofenceList)
                .build()
        );
        return geofencingRequest;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        buildGeofence();
        addGeofence();


        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Lokasi Saat Ini");
        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
    }

    private PendingIntent getGeofencePendingIntent() {
//        if (pendingIntent != null) {
//            return pendingIntent;
//        }
        Intent intent = new Intent(getActivity(), GeofenceTranstitonService.class);
        pendingIntent = PendingIntent.getService(getActivity(), 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

    private void addGeofence() {
        geofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Toast.makeText(getContext(),"tessssssssssssssssst", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(getActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Toast.makeText(getContext(),"salah", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case req:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                }
                break;
        }

    }


}
