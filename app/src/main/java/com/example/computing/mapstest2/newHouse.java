package com.example.computing.mapstest2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class newHouse extends AppCompatActivity {
    Context ctx = this;
    String HOUSE_NAME, POSTCODE;
    public static int columnsize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_house);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            }



    public void onSave(View view)
    {
        EditText house = (EditText)findViewById(R.id.houseName);
        EditText post = (EditText)findViewById(R.id.postcode);

        try {
           // workshop 7
            SharedPreferences userInfo = getSharedPreferences("userData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = userInfo.edit();
            editor.putString("house", house.getText().toString());
            editor.putString("post", post.getText().toString());
            editor.commit();
       // HOUSE_NAME = house.getText().toString();
       // POSTCODE = post.getText().toString();

       Context context = getApplicationContext();
      // DatabaseOperations db = new DatabaseOperations(ctx);
      // db.populateDatabase(db, HOUSE_NAME, POSTCODE);
      //     columnsize++;
        CharSequence text = "House saved";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();



        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }



    public void onCancel(View view)
    {
        Intent intent = new Intent(this, MapsActivity2.class);
        startActivity(intent);
    }
}
