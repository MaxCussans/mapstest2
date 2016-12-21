package com.example.computing.mapstest2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;

import java.net.URLEncoder;
import java.util.ArrayList;

import android.view.View;
import android.widget.*;

public class searchTweets extends Activity
{
    // array list to store tweet items from web service
    ArrayList<String> items = new ArrayList<String>();
    String search = null;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tweets);
    }


    public class AsyncTaskParseJson extends AsyncTask<String, String, String>
    {

        // set the url of the web service to call
        String searchURL = "https://api.twitter.com/1.1/search/tweets.json?q="+search;

        @Override
        // this method is used for......................
        protected void onPreExecute() {}

        @Override
        // this method is used for...................
        protected String doInBackground(String... arg0)  {

            try {
                // create new instance of the httpConnect class
                httpConnect jParser = new httpConnect();

                // get json string from service url
                String json = jParser.getJSONFromUrl(searchURL);

                // parse returned json string into json array
                JSONArray jsonArray = new JSONArray(json);

                // loop through json array and add each tweet to item in arrayList
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json_message = jsonArray.getJSONObject(i);

                    if (json_message != null) {
                        //add each tweet to ArrayList as an item
                        items.add(json_message.getString("text"));
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {
            ListView list = (ListView)findViewById(R.id.tweetList);
            ArrayAdapter<String> tweetArrayAdapter = new ArrayAdapter<String>(searchTweets.this, android.R.layout.simple_expandable_list_item_1, items);
            list.setAdapter(tweetArrayAdapter);
        }


    }

    public void onSearch(View view)
    {
        EditText et = (EditText)findViewById(R.id.searchText);
        String searchString = et.getText().toString();
        if(searchString == null || searchString.equals(""))
        {
        }
        else
        {
            try{
                search = URLEncoder.encode(searchString, "UTF-8");
                new AsyncTaskParseJson().execute();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}

