package com.example.computing.mapstest2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class viewPhotos extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView newHouse = (TextView)findViewById(R.id.showHouseName);
        TextView postcode = (TextView)findViewById(R.id.showPostcode);

        SharedPreferences userInfo = getSharedPreferences("userData", Context.MODE_PRIVATE);

        newHouse.setText(userInfo.getString("house", ""));
        postcode.setText(userInfo.getString("post", ""));

    }




    public void onBack(View view)
    {
        Intent intent = new Intent(this, MapsActivity2.class);
        startActivity(intent);
    }

}
