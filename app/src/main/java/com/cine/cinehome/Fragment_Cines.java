package com.cine.cinehome;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class Fragment_Cines extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    Marker Iztacalco, Coyoacan;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cines, container, false);

        final SupportMapFragment myMAPF = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        myMAPF.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng lasPalmas = new LatLng(19.39068, -99.2836994);
        LatLng coyoacan = new LatLng(19.3614493, -99.1729881);

        Coyoacan = googleMap.addMarker(new MarkerOptions()
                .position(coyoacan)
                .title("Coyoacan")
                .snippet("Cine libre de humo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        Iztacalco = googleMap.addMarker(new MarkerOptions()
                .position(lasPalmas)
                .title("Las palmas")
                .snippet("Compra aqui perro")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coyoacan,15f));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Log.e("market","market: " + marker.getTitle());
                if(marker.getTitle().equals("Coyoacan"))
                {
                    marker.showInfoWindow();
                }
                else if(marker.getTitle().equals("Las palmas")){

                }
                return true;
            }
        });
    }

}
