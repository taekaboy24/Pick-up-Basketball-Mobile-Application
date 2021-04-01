package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.myproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class courtLocations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /// This a marker for Swords basketball court
        LatLng SwordsSkatepark = new LatLng(53.46570, -6.21859);
        mMap.addMarker(new MarkerOptions()
                .position(SwordsSkatepark)
                .title("Swords Basketball Court"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SwordsSkatepark));

        // Marker for Fairview Park basketball court
        LatLng Fairview = new LatLng(53.36492, -6.23109);
        mMap.addMarker(new MarkerOptions()
                .position(Fairview)
                .title("Fairview Park Basketball Court"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Fairview));

        // St Annes Park basketball court
        LatLng SaintAnnPark = new LatLng(53.47, -6.21);
        mMap.addMarker(new MarkerOptions()
                .position(SaintAnnPark)
                .title("St Annes Basketball Court"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SaintAnnPark));

        // St Vincents School basketball court
        LatLng StVincents = new LatLng(53.36828, -6.27534);
        mMap.addMarker(new MarkerOptions()
                .position(StVincents)
                .title("St. Vincent's Basketball Club"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(StVincents));

        // Ringssend basketball court
        LatLng Ringssend = new LatLng(53.34251, -6.21951);
        mMap.addMarker(new MarkerOptions()
                .position(Ringssend)
                .title("Ringsend Park Basketball Court"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ringssend));

        // Sandyford basketball court
        LatLng Sandyford = new LatLng(53.27518, -6.22183);
        mMap.addMarker(new MarkerOptions()
                .position(Sandyford)
                .title("Public Basketball Court, Moreen Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sandyford));

        // Mountjoy Dublin basketball court
        LatLng Mountjoy = new LatLng(53.35728, -6.25715);
        mMap.addMarker(new MarkerOptions()
                .position(Mountjoy)
                .title("Mountjoy Basketball Court"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mountjoy));
    }
}