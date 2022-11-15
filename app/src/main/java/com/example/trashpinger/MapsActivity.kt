package com.example.trashpinger

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.trashpinger.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var lastLocation: Location
    private lateinit var FusedLocationClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        FusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        toHome()
        pingLocation()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_REQUEST_CODE
            )
            return
        }
        mMap.isMyLocationEnabled = true
        FusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null)
                lastLocation = location
            val currentLatLan = LatLng(location.latitude, location.longitude)
            placeMarkerOnMap(currentLatLan)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLan, 10f))
        }
    }

    private fun placeMarkerOnMap(currentLatLan: LatLng) {
        val markerOptions = MarkerOptions().position(currentLatLan)
        markerOptions.title("$currentLatLan")
        mMap.addMarker(markerOptions)
    }

    private fun toHome() {
        val tohome: Button = findViewById(R.id.mapsgoback)
        tohome.setOnClickListener() {
            val tohomeint = Intent(this, HomePage::class.java)
            startActivity(tohomeint)
        }
    }
    private fun pingLocation(){
        val pinglocation: Button = findViewById(R.id.pinglocationbutton)
        pinglocation.setOnClickListener(){
            val toPingScreenInt = Intent(this, LocationPing::class.java)
            startActivity(toPingScreenInt)
        }
    }
    override fun onMarkerClick(p0: Marker) = false
}