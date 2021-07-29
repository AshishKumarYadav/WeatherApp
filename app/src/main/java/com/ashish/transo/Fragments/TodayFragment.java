package com.ashish.transo.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ashish.transo.Cons;
import com.ashish.transo.Network.ApiClient;
import com.ashish.transo.Network.ApiInterface;
import com.ashish.transo.Pojo.ResponseModel;
import com.ashish.transo.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.sql.DriverManager.println;


public class TodayFragment extends Fragment {

    String TAG=TodayFragment.class.getSimpleName();

    TextView tempTv,dateTv,tv1,tv2;
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
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        callApi();
    }
    void initView(){

        tempTv=getView().findViewById(R.id.temperature);
        dateTv=getView().findViewById(R.id.date);
        tv1=getView().findViewById(R.id.tv1);
        tv2=getView().findViewById(R.id.tv2);
        imageView=getView().findViewById(R.id.imgView);




    }
    void callApi(){

        final ApiInterface requestInterface = ApiClient.getClient();
        Call<ResponseModel> call = requestInterface.getCurrentData("Guwahati");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                if(response.body()!= null){

                    Log.d("RES ",""+response.body().toString()+" , "+response.body().getSuccess()+" , "+response.body().getError());

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


        Log.d(TAG,"DATE_STRING_FORMAT " + formatted+" , ");

        tempTv.setText(""+responseModel.getCurrent().getTemperature()+" \u2103");
        dateTv.setText(formatted);
        tv1.setText("Feels like "+responseModel.getCurrent().getFeelslike()+" \u2103");
        tv2.setText(responseModel.getLocation().getName()+" , "+responseModel.getLocation().getCountry());

        String url=responseModel.getCurrent().getWeather_icons().get(0);


    }
}