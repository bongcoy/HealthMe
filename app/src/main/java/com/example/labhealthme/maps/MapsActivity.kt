package com.example.labhealthme.maps

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.labhealthme.R
import com.example.labhealthme.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.util.*

// TODO : First run ga minta request
// TODO : ForResult nya ga jalan

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var isPermissionGranted: Boolean = false
    private var GPS_REQUEST_CODE = 1
    private val TAG = "MAPS ACT WOYYYYY"

    private lateinit var binding: ActivityMapsBinding
    private lateinit var googleMap: GoogleMap
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private lateinit var latLng: LatLng
    private lateinit var cameraUpdate: CameraUpdate

    private val activityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == GPS_REQUEST_CODE) {
                val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
                val providerEnable =
                    locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

                if (providerEnable) {
                    Toast.makeText(this@MapsActivity, "GPS is enable", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@MapsActivity, "GPS is not enable", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkMyPermission()
        initMap()

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        binding.apply {
//            ivSearchIcon.setOnClickListener(this@MapsActivity::geoLocate)
        }
//        binding.btn_my_current.setOnClickListener {
//            currentLoc()
//        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(p0: GoogleMap) {
        Log.d(TAG, "MAP dah readyyyyyy")
        googleMap = p0
        googleMap.isMyLocationEnabled = true
        // TODO: Munculin tombol saat buka pertama kali
        googleMap.uiSettings.isMyLocationButtonEnabled = true
    }

//    private fun geoLocate(view: View){
//        val locationName = binding.etSearch.text.toString()
//        val geocoder = Geocoder(this, Locale.getDefault())
//        try {
//            val addressList: List<Address> = geocoder.getFromLocationName(locationName,1)
//            if (addressList.isNotEmpty()){
//                val address = addressList[0]
//                goToLocation(address.latitude,address.longitude)
//                googleMap.addMarker(MarkerOptions().position(LatLng(address.latitude,address.longitude)))
//                Toast.makeText(
//                    this@MapsActivity,
//                    address.locality,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        } catch (e:IOException){
//            e.printStackTrace()
//        }
//    }

//    @SuppressLint("MissingPermission")
//    private fun currentLoc() {
//        mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
//            if (task.isSuccessful) {
//                lastLocation = task.result
//                goToLocation(lastLocation.latitude, lastLocation.longitude)
//            }
//        }
//    }

    private fun goToLocation(latitude: Double, longitude: Double) {
        latLng = LatLng(latitude, longitude)
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10F)
        googleMap.moveCamera(cameraUpdate)
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
    }

    private fun initMap() {
        if (isPermissionGranted && isGpsEnabled()) {
            val mapFragment =
                supportFragmentManager.findFragmentById(R.id.map_view_fragment) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
    }

    //TODO: Minta permission nya ko ga langsung nyalain GPS nya aja ya ?
    private fun isGpsEnabled(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        val providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (providerEnable) {
            return true
        } else {
            AlertDialog.Builder(this)
                .setTitle("GPS Permission")
                .setMessage("GPS is required for this app to work. Please enable GPS")
                .setPositiveButton("Go To Settings") { _, _ ->
                    val resultIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    Log.d(TAG, "INI POSITIVE BUTTON KALO UDAH DIPENCET")
                    activityResultLauncher.launch(resultIntent)
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
                    if (p0 != null) {
                        if (p0.areAllPermissionsGranted()) {
                            // TODO: Ini kalo GPS ga nyala KENAPA areAll == True ???
                            Toast.makeText(
                                this@MapsActivity,
                                "Permission Granted !",
                                Toast.LENGTH_SHORT
                            ).show()
                            isPermissionGranted = true
                        }

                        // if there were PERMANENT denied permissions
                        if (p0.isAnyPermissionPermanentlyDenied) {
                            Log.d(TAG, "isAnyPermanentDenied Jalannnnnnnnnnnnnn")
                            showSettingsDialog()
                        }
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

    private fun showSettingsDialog() {
        AlertDialog.Builder(this)
            .setTitle("Need Permission")
            .setMessage("This app needs permission to use this feature. You can grant this from app settings")
            .setPositiveButton("Go To Settings") { dialog, _ ->
                dialog.cancel()
                openSettings()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
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
}