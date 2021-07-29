package com.ashish.transo.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ashish.transo.BuildConfig;
import com.ashish.transo.Cons;
import com.ashish.transo.Network.ApiClient;
import com.ashish.transo.Network.ApiInterface;
import com.ashish.transo.Pojo.ResponseModel;
import com.ashish.transo.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.sql.DriverManager.println;


public class TodayFragment extends Fragment {

    String TAG = TodayFragment.class.getSimpleName();

    protected Location mLastLocation;
    int REQUEST_PERMISSIONS_REQUEST_CODE = 1001;
    FusedLocationProviderClient mFusedLocationClient;

    TextView tempTv, dateTv, tv1, tv2,weatherTypeTv;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        if (!checkPermissions()){
            requestPermissions();
        }else {

            getLastLocation();
        }
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {

        mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful() && task.getResult() != null) {

                            mLastLocation = task.getResult();
                            Log.d(TAG,"Locates "+mLastLocation.getLatitude()+" , "+mLastLocation.getLongitude());
                            geocodeLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude());
                        } else {
                            showMessage("No Location found");
                        }
                    }
                });
    }

    void geocodeLocation(double latitude,double longitude) {

        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(getContext(), Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

        callApi(city);

    }
    public void showMessage(String message) {
        if (message == null || message.length() == 0)
            return;
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastLocation();

        } else {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {

            if (grantResults.length <= 0) {

                Toast.makeText(getContext(),"Permission denied",Toast.LENGTH_LONG);

            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.

                getLastLocation();
            } else {

                Toast.makeText(getContext(),"Permission denied",Toast.LENGTH_LONG);
                Intent intent = new Intent();
                intent.setAction(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package",
                        BuildConfig.APPLICATION_ID, null);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }
    void initView(){

        tempTv=getView().findViewById(R.id.temperature);
        dateTv=getView().findViewById(R.id.date);
        tv1=getView().findViewById(R.id.tv1);
        tv2=getView().findViewById(R.id.tv2);
        imageView=getView().findViewById(R.id.imgView);
        weatherTypeTv=getView().findViewById(R.id.weather_type);




    }
    void callApi(String city){


        final ApiInterface requestInterface = ApiClient.getClient();
        Call<ResponseModel> call = requestInterface.getCurrentData(city);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                if(response.body()!= null){

                    if (response.code()==200){

                        renderUI(response.body());

                    }else {

                        Toast.makeText(getContext(),""+response.body().getError().getInfo(),Toast.LENGTH_LONG).show();
                    }

                }

            }
            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    void renderUI(ResponseModel responseModel){

        Date date = new Date(responseModel.getLocation().getLocaltime_epoch() * 1000L);
        DateFormat format = new SimpleDateFormat("MMM d, yyyy - h:mm:ss a");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String formatted = format.format(date);

        tempTv.setText(""+responseModel.getCurrent().getTemperature()+" \u2103");
        dateTv.setText(formatted);
        tv1.setText("Feels like "+responseModel.getCurrent().getFeelslike()+" \u2103");
        tv2.setText(responseModel.getLocation().getName()+" , "+responseModel.getLocation().getCountry());
        weatherTypeTv.setText(responseModel.getCurrent().getWeather_descriptions().get(0));




    }
}