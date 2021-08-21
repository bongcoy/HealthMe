package com.example.labhealthme.maps

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.labhealthme.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var isPermissionGranted: Boolean = false
    private var GPS_REQUEST_CODE = 9001

    private lateinit var googleMap: GoogleMap

    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    private lateinit var latLng: LatLng
    private lateinit var cameraUpdate: CameraUpdate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        checkMyPermission()

        initMap()

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

//        binding.btn_my_current.setOnClickListener {
//            currentLoc()
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GPS_REQUEST_CODE){
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

            if (providerEnable){
                Toast.makeText(this@MapsActivity, "GPS is enable", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MapsActivity, "GPS is not enable", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun currentLoc() {
        mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                lastLocation = task.result
                goToLocation(lastLocation.latitude, lastLocation.longitude)
            }
        }
    }

    private fun goToLocation(latitude: Double, longitude: Double) {
        latLng = LatLng(latitude, longitude)
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10F)
        googleMap.moveCamera(cameraUpdate)
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
    }

    private fun initMap() {
        if (isPermissionGranted && isGpsEnabled()) {
            val mapFragment = supportFragmentManager.findFragmentById(R.id.map_view_fragment) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
    }

    //Todo: onActivityResult
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == GPS_REQUEST_CODE){
//            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
//            val providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//
//            if (providerEnable){
//                Toast.makeText(this@MapsActivity, "GPS is enable", Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(this@MapsActivity, "GPS is not enable", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    private fun isGpsEnabled(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        val providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (providerEnable){
            return true
        }else{
            AlertDialog.Builder(this)
                .setTitle("GPS Permission")
                .setMessage("GPS is required for this app to work. Please enable GPS")
                .setPositiveButton("Go To Settings") { _, _ ->
                    //Todo: startActivityForResult
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivityForResult(intent,GPS_REQUEST_CODE);
                }
                .setCancelable(false)
                .show()
        }
        return false
    }

    private fun checkMyPermission() {
        val permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        Dexter.withContext(this)
            .withPermissions(permissions)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    if (p0!!.areAllPermissionsGranted()) {
                        Toast.makeText(this@MapsActivity, "Permission Granted !", Toast.LENGTH_SHORT).show()
                        isPermissionGranted = true
                    }
                    if (p0.isAnyPermissionPermanentlyDenied) {
                        showSettingsDialog()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    p1?.continuePermissionRequest()
                }
            }).check()
    }

    private fun showSettingsDialog(){
        AlertDialog.Builder(this)
            .setTitle("Need Permission")
            .setMessage("This app needs permission to use this feature. You can grant this from app settings")
            .setPositiveButton("Go To Settings") { dialog, _ ->
                dialog.cancel()
                openSettings()
            }
            .setNegativeButton("Cancel"){ dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    private fun openSettings() {
        val intent = Intent()
        val uri = Uri.fromParts("package", packageName, null)
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.data = uri
        startActivity(intent)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
        googleMap.isMyLocationEnabled = true
        googleMap.uiSettings.isMyLocationButtonEnabled = true
    }
}