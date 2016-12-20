package com.example.computing.mapstest2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
    String HOUSE_NAME, POSTCODE;
    Context ctx;
    int columns = newHouse.columnsize;
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
       //DatabaseOperations dop = new DatabaseOperations(ctx);
       //Cursor cr = dop.getData(dop);
       //cr.moveToFirst();
       ////iterate through number of columns
       //for(int i =0; i < columns - 1; i++)
       //{
       //    //add a data entry
       //    newHouse.setText(cr.getString(i));
       //    postcode.setText(cr.getString(i + 1));
       //    //cr.moveToNext();
       //}
        newHouse.setText(userInfo.getString("house", ""));
        postcode.setText(userInfo.getString("post", ""));

    }




    public void onBack(View view)
    {
        Intent intent = new Intent(this, MapsActivity2.class);
        startActivity(intent);
    }

}
