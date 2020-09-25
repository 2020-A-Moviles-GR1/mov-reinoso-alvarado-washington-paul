package com.example.examen_1b_univ_alien

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.squareup.picasso.Picasso


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(mMap)
        EstrablecerPosiciones()


    }

    fun EstrablecerPosiciones(){

        val origen = LatLng(-0.243340, -78.536083)
        val origenUno = LatLng(-0.243399, -78.536471)
        val origenDos = LatLng(-0.243683, -78.537662)
        val origenTres = LatLng(-0.243584, -78.538880)
        val origenCuatro = LatLng(-0.243603, -78.539277)

        mMap.addMarker(MarkerOptions().position(origen).title("Paul uno"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen, 18F))

        val circle: Circle = mMap.addCircle(
            CircleOptions()
                .center(origen)
                .radius(15.0)//radio en metros
                .strokeWidth(10f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 0, 180, 0))
                .clickable(true)
        )

        val url = "https://www.pngitem.com/pimgs/m/661-6619038_alien-chibi-hd-png-download.png"

        val melbourne = mMap.addMarker(
            MarkerOptions()
                .position(origenUno)
                .title("Paul"))

        val marker = PicassoMarker(melbourne);
        Picasso.with(this).load(url).resize(100, 100).into(marker);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourne ->
            val uri: Uri = Uri.parse("https://www.pngitem.com/pimgs/m/661-6619038_alien-chibi-hd-png-download.png")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })




        val melbourneDos = mMap.addMarker(
            MarkerOptions().position(origenDos)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul 3")
        )

        val melbourneTres = mMap.addMarker(
            MarkerOptions().position(origenTres)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul 4")
        )

        val melbourneCuatro = mMap.addMarker(
            MarkerOptions().position(origenCuatro)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul 5")
        )

    }


    fun establecerConfiguracionMapa(mapa:GoogleMap){
        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermisos = permisosFineLocation== PackageManager.PERMISSION_GRANTED
            if(tienePermisos){
                mapa.isMyLocationEnabled=true
            }
            uiSettings.isZoomControlsEnabled =true
            uiSettings.isMyLocationButtonEnabled=true
        }
    }
}