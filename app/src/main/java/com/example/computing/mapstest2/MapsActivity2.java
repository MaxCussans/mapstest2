package com.example.computing.mapstest2;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private UiSettings myUISettings;
    //bool switch so user can only use camera while close to a location
    boolean canUseCamera = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onSearch(View view)
    {
        EditText search_Address = (EditText)findViewById(R.id.searchAddress);
        String location = search_Address.getText().toString();
        List<Address> addressList = null;

        if(location == null || location.equals(""))
        {
        }
        else
        {
            Geocoder geocoder = new Geocoder(this);
            try {
               addressList = geocoder.getFromLocationName(location, 1);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng addressLoc = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(addressLoc).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(addressLoc, 15.0f));

        }
    }

    public void onclickPhotos(View view){
       // if(canUseCamera == true)
        {
            int REQUEST_IMAGE_CAPTURE = 1;
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void onclickView(View view)
    {
        Intent intent = new Intent(this, viewPhotos.class);
        startActivity(intent);
    }

    public void onclickNew(View view)
    {
        Intent intent = new Intent(this, newHouse.class);
        startActivity(intent);
    }


    public void onMyLocationChange(Location myLocation, Address addressLocation)
    {
        //check if my location is close to address
        if(((myLocation.getLatitude() <= addressLocation.getLatitude() + 0.00005) || (myLocation.getLatitude() >= addressLocation.getLatitude() - 0.0005)) && ((myLocation.getLongitude() <= addressLocation.getLongitude() + 0.00005) || (myLocation.getLongitude() >= addressLocation.getLongitude() - 0.0005)) )
        {
            //allow button to access camera
            canUseCamera = true;
        }
        else
        {
            canUseCamera = false;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        myUISettings = mMap.getUiSettings();
        myUISettings.setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);
    }
}