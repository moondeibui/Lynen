package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocateLynenBin extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_lynen_bin);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sunway = new LatLng(3.0671, 101.6035);
        googleMap.addMarker(new MarkerOptions()
                .position(sunway)
                .title("You are here!"));
        // [START_EXCLUDE silent]
        float zoomLevel = 17.0f;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sunway, zoomLevel));

        LatLng sunway_pyramind = new LatLng(3.070166386, 101.604330916);
        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(sunway_pyramind)
                .title("Pyramind Bin")
                .snippet("1100m Away"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sunway_pyramind));

        LatLng sunway_familymart = new LatLng(3.0683, 101.6031);
        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(sunway_familymart)
                .title("FamilyMart Bin")
                .snippet("220m Away"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sunway_familymart));

        LatLng sunway_fishbowl = new LatLng(3.0660, 101.6024);
        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(sunway_fishbowl)
                .title("FishBowl Bin")
                .snippet("400-500m Away"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sunway_fishbowl));

        LatLng sunway_rockcafe = new LatLng(3.0688, 101.6022);
        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(sunway_rockcafe)
                .title("Rock Cafe Bin")
                .snippet("350m Away"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sunway_rockcafe));

        LatLng sunway_impulsegaming = new LatLng(3.0657, 101.6031);
        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(sunway_impulsegaming)
                .title("Impulse Gaming Bin")
                .snippet("350-400m Away"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sunway_impulsegaming));
    }
}