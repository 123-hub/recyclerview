package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);

//        JsonArrayRequest JsonArrayRequest=new JsonArrayRequest(Request.Method.GET, "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=26bcf9bd9a644b13b53beef835bb6418", null, new Listener < JSONArray >() {
//            @Override
//            public void onResponse(JSONArray response) {
//                TextView textView=(TextView) findViewById(R.id.text);
//                textView.setText(response.toString());
//            }
//        }
//           , new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                   Toast.makeText(MainActivity.this,"fucking wrong", LENGTH_SHORT).show();
//            }
//        });
//
//        queue.add(JsonArrayRequest);



     final    ArrayList<objectes> arrayList=new ArrayList <>();
          JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://reqres.in/api/users?page=2", null, new Response.Listener < JSONObject >() {



            @Override
            public void onResponse(JSONObject response) {




                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("data");
                    Log.d("neeraj","response is:" + jsonArray.toString());
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject currentobject=jsonArray.getJSONObject(i);
                        int ids=currentobject.getInt("id");
                        String emails=currentobject.getString("email");
                        String firsts=currentobject.getString("first_name");
                        String lasts=currentobject.getString("last_name");
                        String avatars=currentobject.getString("avatar");

                        objectes ne=new objectes(ids,emails,firsts,lasts,avatars);

                        arrayList.add(ne);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "this is fucking wrong", Toast.LENGTH_SHORT).show();
            }


        });

        queue.add(jsonObjectRequest);



        adapter<objectes> arrayAdapter=new adapter<objectes>(MainActivity.this,arrayList);
      final   ListView list=(ListView) findViewById(R.id.listview);
        list.setAdapter(arrayAdapter);
    }




}









