package com.example.listadepaises;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import Model.Paises;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Paises paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //pega os paises
        paises = (Paises) getIntent().getSerializableExtra("ubs");

        //inicializa mapFragment
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //coordenadas da ubs
        LatLng Paiseslatlng = new LatLng(Double.parseDouble(paises.latitude), Double.parseDouble(paises.longitude));

        //adiciona marcador e move a camera do mapa p ele
        googleMap.addMarker(new MarkerOptions().position(Paiseslatlng).title(paises.name));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Paiseslatlng, 12.0f));
    }
}