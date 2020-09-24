package com.example.examen_1b_univ_alien

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import java.net.URL
import java.nio.file.Paths.get


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

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    fun EstrablecerPosiciones(){

        val origen = LatLng(-0.243340, -78.536083)
        val origenUno = LatLng(-0.243399, -78.536471)
        val origenDos = LatLng(-0.243683, -78.537662)
        val origenTres = LatLng(-0.243584, -78.538880)
        val origenCuatro = LatLng(-0.243603, -78.539277)

        mMap.addMarker(MarkerOptions().position(origen).title("Paul"))
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

        val url = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/38c109ad-e096-41f5-a3f9-517a757e5ab2/d6vxse2-8322106a-99ad-439b-9675-6d3588c6c782.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMzhjMTA5YWQtZTA5Ni00MWY1LWEzZjktNTE3YTc1N2U1YWIyXC9kNnZ4c2UyLTgzMjIxMDZhLTk5YWQtNDM5Yi05Njc1LTZkMzU4OGM2Yzc4Mi5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.4UgVWHHobLvr3O4oe-hSoPKvTBb3F9XqiNSxXgWGroA"
        val picasso = Picasso.get()
        //picasso.load(url).into(posterImageView)//agrega el luga donde se pondra la imagen

        /*Picasso.get().load(url).into(object : com.squareup.picasso.Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                // loaded bitmap is here (bitmap)
            }
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
        })*/

        //val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())

        val melbourne = mMap.addMarker(
            MarkerOptions().position(origenUno)
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

        val melbourneDos = mMap.addMarker(
            MarkerOptions().position(origenDos)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

        val melbourneTres = mMap.addMarker(
            MarkerOptions().position(origenTres)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
        )

        val melbourneCuatro = mMap.addMarker(
            MarkerOptions().position(origenCuatro)
                .icon(
                    BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                )
                .title("Paul")
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