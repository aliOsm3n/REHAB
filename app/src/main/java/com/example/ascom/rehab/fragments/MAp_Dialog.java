package com.example.ascom.rehab.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.location.Address;

import com.example.ascom.rehab.R;
import com.example.ascom.rehab.SignupIII;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MAp_Dialog extends DialogFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,View.OnClickListener  {

    private SignupIII mActivityInstance;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 999;

    //Initializing the GoogleApiClient object
    private GoogleApiClient googleApiClient;
    public Marker marker;
    MapView mMapView;
    private GoogleMap googleMap;
    private CameraPosition cameraPosition;
    private Location location;
    Button infoBu;
    double CameraLat ;
    double CameraLong ;


//    public final SignupIII getActivityInstance() {
//        return mActivityInstance;
//    }


//    @Override
//    public void onAttach(Activity activity) {
//        mActivityInstance = (SignupIII) activity;
//        super.onAttach(activity);
////        googleApiClient.connect();
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityInstance = null;
//        googleApiClient.disconnect();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_dialog, container, false);
        //Building a instance of Google Api Client
        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .build();


        mMapView = view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        // needed to get the map to display immediately
        mMapView.onResume();

        try {
            MapsInitializer.initialize(mActivityInstance.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                LatLng sydney = new LatLng(24.7241503, 46.2620343);

                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setZoomGesturesEnabled(false);

                //marker=googleMap.addMarker(new MarkerOptions().position(sydney).draggable(true));
                cameraPosition = new CameraPosition.Builder().target(sydney).zoom(9).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        infoBu = view.findViewById(R.id.info);
        infoBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraLat = googleMap.getCameraPosition().target.latitude;
                CameraLong = googleMap.getCameraPosition().target.longitude;

                try {
                    Geocoder geo = new Geocoder(getActivity().getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = geo.getFromLocation(CameraLat, CameraLong, 1);
                    if (addresses.isEmpty()) {
                        Toast.makeText(getActivity(), ""+"Waiting for Location", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (addresses.size() > 0) {
                            Toast.makeText(getActivity(), ""+addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace(); // getFromLocation() may sometimes fail
                }
               // Toast.makeText(getActivity(), ""+googleMap.getCameraPosition().target, Toast.LENGTH_SHORT).show();
                 getDialog().dismiss();
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getActivity(), "Connection was suspended", Toast.LENGTH_SHORT);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getActivity(), "Connection failed", Toast.LENGTH_SHORT);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    getCurrentLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    private void getCurrentLocation() {
        //Checking if the location permission is granted

        //Fetching location using FusedLOcationProviderAPI
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Should we show an explanation?
            Toast.makeText(getActivity(),"aaaa",Toast.LENGTH_LONG).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user asynchronously -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(getActivity(),"bbb",Toast.LENGTH_LONG).show();
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
                Toast.makeText(getActivity(),"ffff",Toast.LENGTH_LONG).show();
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else {
            // Permission has already been granted

            FusedLocationProviderApi fusedLocationApi = LocationServices.FusedLocationApi;
            location= fusedLocationApi.getLastLocation(googleApiClient);

        }
        //In some rare cases Location obtained can be null
        if (location==null){
            Toast.makeText(getActivity(),"jjj",Toast.LENGTH_LONG).show();
        }
        else {
            marker.setPosition(new LatLng(location.getLatitude(),location.getLongitude()));
            cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(),location.getLongitude())).zoom(15).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

    }
}
