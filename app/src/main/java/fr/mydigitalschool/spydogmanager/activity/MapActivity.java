package fr.mydigitalschool.spydogmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;;import java.util.ArrayList;

import fr.mydigitalschool.spydogmanager.R;
import fr.mydigitalschool.spydogmanager.model.Position;
import fr.mydigitalschool.spydogmanager.model.Victime;

/**
 * Created by jp789 on 01/04/2018.
 */

public class MapActivity  extends FragmentActivity implements OnMapReadyCallback {
    ArrayList<Victime> victimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        final Bundle extras = getIntent().getExtras();
        victimes = (ArrayList<Victime>) extras.get( "listvictime" );
        float latitude, longitude;
        for(int j=0; j<victimes.size(); j++){
            latitude = Float.parseFloat( victimes.get( j ).getPostion().get( victimes.get( j ).getPostion().size()-1 ).getLatitude() );
            longitude = Float.parseFloat( victimes.get( j ).getPostion().get( victimes.get( j ).getPostion().size()-1 ).getLongitude() );
            map.addMarker(new MarkerOptions().position(new LatLng(longitude, latitude)).title(victimes.get( j ).getIdentification()));

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
