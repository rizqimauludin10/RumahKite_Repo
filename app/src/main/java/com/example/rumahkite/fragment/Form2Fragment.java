package com.example.rumahkite.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.rumahkite.MapsActivity;
import com.example.rumahkite.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.io.IOException;
import java.util.List;

public class Form2Fragment extends Fragment implements Step, OnMapReadyCallback {

    private Location mlocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final int Request_Code = 101;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private GoogleMap.OnCameraIdleListener onCameraIdleListener;
    private TextView resutText;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.form2_fragment, container, false);
        resutText = view.findViewById(R.id.dragg_result);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        GetLastLocation();
        configureCameraIdle();

        return view;
    }

    //tambahan eko

    private void GetLastLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, Request_Code);
            mMap.setMyLocationEnabled(true);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    mlocation = location;
                    /*Toast.makeText(getContext(), mlocation.getLatitude() + " " + mlocation.getLongitude(),
                            Toast.LENGTH_SHORT).show();*/
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager()
                            .findFragmentById(R.id.map);
                    supportMapFragment.getMapAsync(Form2Fragment.this);
                }
            }
        });
    }

    private void configureCameraIdle() {
        onCameraIdleListener = new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                LatLng latLng = mMap.getCameraPosition().target;
                Geocoder geocoder = new Geocoder(getActivity());

                try {
                    List<Address> addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        String locality = addressList.get(0).getAddressLine(0);
//                        String country = addressList.get(0).getCountryName();
                        if (!locality.isEmpty())
                            resutText.setText(locality);
                        resutText.setSelected(true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    //batas tambahan

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraIdleListener(onCameraIdleListener);

        LatLng latLng = new LatLng(mlocation.getLatitude(), mlocation.getLongitude());
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));

        //nambah tombol gps

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }
}
