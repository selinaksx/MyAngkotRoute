package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        LatLng Malang = new LatLng(-7.966739, 112.632123);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(Malang, 17);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng Moklet = new LatLng(-7.977199, 112.658868);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Moklet));
        Marker moklet = mMap.addMarker(new MarkerOptions()
                .position(Moklet)
                .title("Telkom Schools Malang")
                .snippet("Ini adalah Telkom Schools Malang"));
        moklet.hideInfoWindow();

        LatLng Alun = new LatLng(-7.981429, 112.630705);
        mMap.moveCamera((CameraUpdateFactory.newLatLng(Alun)));
        Marker alun = mMap.addMarker(new MarkerOptions()
                .position(Alun)
                .title("Alun - Alun Malang")
                .snippet("Ini adalah Alun - Alun Malang"));
        alun.hideInfoWindow();

    }
}
