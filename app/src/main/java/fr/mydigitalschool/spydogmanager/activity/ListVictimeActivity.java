package fr.mydigitalschool.spydogmanager.activity;

/**
 * Created by jp789 on 31/03/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import fr.mydigitalschool.spydogmanager.R;
import fr.mydigitalschool.spydogmanager.adapter.ListVictimeAdapteur;
import fr.mydigitalschool.spydogmanager.model.Position;
import fr.mydigitalschool.spydogmanager.model.Victime;

public class ListVictimeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListVictimeAdapteur victimeview;
    private ArrayList<Victime> victimes;
    GridLayoutManager gridLayoutManager;
    Button btn_list_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_victime);
        String URL = "http://5.51.221.85:1337/track/";
        victimes = new ArrayList<>();
        boolean test ;
        recyclerView= (RecyclerView) findViewById(R.id.rv_items_victime);
        try {
            JSONArray toto = getJSONObjectFromURL(URL);

            for (int i = 0;i<=toto.length()-1;i++){
                test = true;
                for(int j=0; j<victimes.size(); j++){
                    if ((victimes.get(j).getIdentification()).equals(toto.getJSONObject( i ).getString("identification")  )){
                        Position p = new Position( toto.getJSONObject( i ).getString("time"),toto.getJSONObject( i ).getString("longitude"),toto.getJSONObject( i ).getString("latitude") );
                        victimes.get(j).setPostion(p);
                        Log.d("MyTagGoesHere", String.valueOf(  victimes.get(j).getId() ) );
                        test = false;
                    }
                }
                if (test){
                    createNewVictimes( i, toto.getJSONObject( i ).getString("identification"),toto.getJSONObject( i ).getString("latitude"),toto.getJSONObject( i ).getString("longitude"), toto.getJSONObject( i ).getString("time") );
                }

            }
            gridLayoutManager = new GridLayoutManager(this,1);
            victimeview = new ListVictimeAdapteur( victimes,this );
            recyclerView = (RecyclerView) findViewById(R.id.rv_items_victime);
            recyclerView.setAdapter(victimeview);
            recyclerView.setLayoutManager(gridLayoutManager);


        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "test1");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("error", "test2" );
        }
        btn_list_map = findViewById( R.id.btn_list_map );
        btn_list_map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListVictimeActivity.this, MapActivity.class);
                intent.putExtra( "listvictime", (Serializable) victimes );
                startActivity(intent);
            }

        });

    }
    public static JSONArray getJSONObjectFromURL(String urlString) throws IOException, JSONException {
        HttpURLConnection urlConnection = null;
        java.net.URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */ );
        urlConnection.setConnectTimeout(15000 /* milliseconds */ );
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();

        String jsonString = sb.toString();
        Log.d("MyTagGoesHere", "This is my log message at the debug level here");
        System.out.println("JSON: " + jsonString);

        return new JSONArray(jsonString);
    }

    public void createNewVictimes(int id,String identification, String latitude, String longitude, String date){
        Victime poke = new Victime(id, identification, latitude,longitude,date);
        victimes.add(poke);
    }

}