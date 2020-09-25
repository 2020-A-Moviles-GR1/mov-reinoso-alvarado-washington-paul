package com.example.examen_1b_univ_alien

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.squareup.picasso.Picasso


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var listaAliens:ArrayList<AlienHttp>
    val urlPrincipal = "http://192.168.0.102:1337"
    private lateinit var mMap: GoogleMap
    lateinit var universo:UniversoHttp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        listaAliens = arrayListOf()
        universo= intent.getParcelableExtra<UniversoHttp>("universoA")
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        establecerConfiguracionMapa(mMap)

        ///EstrablecerPosiciones()
        obtenerAliens()
        Handler(Looper.getMainLooper()).postDelayed({
            //Do something after 1000ms
            //universo-ZM-32
            //universo-A-554
            CargarHijos(universo.nombreUniverso!!)
            //EstrablecerPosiciones()
        }, 8000)

    }

    fun CargarHijos(nombreUniverso:String){
        listaAliens.forEach {
            if (it.nombreUniverso == nombreUniverso) {
            val melbourne = mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(it.latitud!!.toDouble(), it.longitud!!.toDouble()))
                    .title("Paul")
            )

            val marker = PicassoMarker(melbourne);
            Picasso.with(this).load(it.url).resize(100, 100).into(marker);
            //agregdo nuevo
            mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourne ->
                val uri: Uri = Uri.parse(it.url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
                true
            })
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(listaAliens[0].latitud!!.toDouble(),listaAliens[0].longitud!!.toDouble()), 18F))
    }

    fun EstrablecerPosiciones(){

        //Primer Marcador
        val melbourne = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(listaAliens[0].latitud!!.toDouble(),listaAliens[0].longitud!!.toDouble()))
                .title("Paul"))

        val marker = PicassoMarker(melbourne);
        Picasso.with(this).load(listaAliens[0].url).resize(100, 100).into(marker);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourne ->
            val uri: Uri = Uri.parse(listaAliens[0].url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })
        //Segundo Marcador
        val melbourneDos = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(listaAliens[1].latitud!!.toDouble(),listaAliens[1].longitud!!.toDouble()))
                .title("Paul"))

        val markerDos = PicassoMarker(melbourneDos);
        Picasso.with(this).load(listaAliens[1].url).resize(100, 100).into(markerDos);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourneDos ->
            val uri: Uri = Uri.parse(listaAliens[1].url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })
        //Tercer Marcador
        val melbourneTres = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(listaAliens[2].latitud!!.toDouble(),listaAliens[2].longitud!!.toDouble()))
                .title("Paul"))

        val markerTres = PicassoMarker(melbourneTres);
        Picasso.with(this).load(listaAliens[2].url).resize(100, 100).into(markerTres);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourneTres ->
            val uri: Uri = Uri.parse(listaAliens[2].url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })
        //Cuarto Marcador
        val melbourneCuatro = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(listaAliens[3].latitud!!.toDouble(),listaAliens[3].longitud!!.toDouble()))
                .title("Paul"))

        val markerCuatro = PicassoMarker(melbourneCuatro);
        Picasso.with(this).load(listaAliens[3].url).resize(100, 100).into(markerCuatro);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { markerCuatro ->
            val uri: Uri = Uri.parse(listaAliens[3].url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })
        //Quinto Marcador
        /*val melbourneCinco = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(listaAliens[4].latitud!!.toDouble(),listaAliens[4].longitud!!.toDouble()))
                .title("Paul"))

        val markerCinco = PicassoMarker(melbourneCinco);
        Picasso.with(this).load(listaAliens[4].url).resize(100, 100).into(markerCinco);

        mMap.setOnMarkerClickListener(OnMarkerClickListener { melbourneCinco ->
            val uri: Uri = Uri.parse(listaAliens[4].url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })*/
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(listaAliens[0].latitud!!.toDouble(),listaAliens[0].longitud!!.toDouble()), 18F))
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

    fun obtenerAliens() {
        val url = urlPrincipal + "/alien"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")
                        val aliens= Klaxon()
                            .parseArray<AlienHttp>(data)
                        if(aliens!=null){
                            aliens.forEach{
                                Log.i("http-klaxon", "Nombre: ${it.nombreUniverso}  tamaño: ${it.razaAlien}")
                                listaAliens.add(it)
                            }
                            //runOnUiThread(Runnable {
                            //    adaptador.notifyDataSetChanged()
                            //})
                        }
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }
    }
}