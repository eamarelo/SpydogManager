package fr.mydigitalschool.spydogmanager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import fr.mydigitalschool.spydogmanager.R;
import fr.mydigitalschool.spydogmanager.adapter.ListVictimeAdapteur;
import fr.mydigitalschool.spydogmanager.adapter.SingleVictimeAdapteur;
import fr.mydigitalschool.spydogmanager.model.Position;

/**
 * Created by jp789 on 01/04/2018.
 */

public class SingleVictimeActivity extends AppCompatActivity {
    ArrayList<Position> positions ;
    GridLayoutManager gridLayoutManager;
    SingleVictimeAdapteur posiview;
    RecyclerView recyclerView;
    TextView tv_single_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_single_victime);
        final Bundle extras = getIntent().getExtras();
        positions = (ArrayList<Position>) extras.get( "listpos" );
        String name = extras.getString( "nameVic" );
        for(int j=0; j<positions.size(); j++){
            Log.d( "onCreate: ", String.valueOf( positions.get( j ).getDate() ) );
        }
        tv_single_name = findViewById( R.id.Tv_single_name );
        tv_single_name.setText( name );
        gridLayoutManager = new GridLayoutManager(this,1);
        posiview = new SingleVictimeAdapteur( positions,this );
        recyclerView = (RecyclerView) findViewById(R.id.rv_items_position);
        recyclerView.setAdapter(posiview);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged( childActivity, title );
    }
}
