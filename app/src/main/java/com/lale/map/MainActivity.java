package com.lale.map;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;
        LatLng galle = new LatLng(6.0329, 80.2168);
        myMap.addMarker(new
                MarkerOptions().position(galle).title("Galle"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(galle));

        myMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        myMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        LatLng Galle = new LatLng(6.0329, 80.2168);
        myMap.addMarker(new MarkerOptions().position(galle).title("galle")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(galle));

        Galle = new LatLng(6.0329, 80.2168);
        myMap.addMarker(new
                MarkerOptions().position(galle).title("galle")

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.download)));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(galle));

    }
}