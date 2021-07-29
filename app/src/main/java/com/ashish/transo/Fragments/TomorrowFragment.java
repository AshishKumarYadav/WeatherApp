package com.ashish.transo.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashish.transo.Network.ApiClient;
import com.ashish.transo.Network.ApiInterface;
import com.ashish.transo.Pojo.ForecastResponseModel;
import com.ashish.transo.Pojo.ResponseModel;
import com.ashish.transo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TomorrowFragment extends Fragment {

    String TAG=TomorrowFragment.class.getSimpleName();

    TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tomorrow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        callApi();
    }
    void initView(){

        textView=getView().findViewById(R.id.textView);

    }
    void callApi(){

        final ApiInterface requestInterface = ApiClient.getClient();
        Call<ForecastResponseModel> call = requestInterface.getForCastData("New York",4);
        call.enqueue(new Callback<ForecastResponseModel>() {
            @Override
            public void onResponse(Call<ForecastResponseModel> call, Response<ForecastResponseModel> response) {

                Log.d(TAG,"msg "+response.message()+" , "+response.code()+" , "+response.errorBody()+" , "+response.headers()+" , "+response.body()+" , "+response.isSuccessful());

                if(response.body()!= null){

                    if (response.code()==200){
                        Log.d("RES ",""+response.body().toString());

                        if (!response.body().getSuccess()){

                            textView.setText(response.body().getError().getInfo());
                        }

                    }



                }

            }
            @Override
            public void onFailure(Call<ForecastResponseModel> call, Throwable t) {

            }
        });


    }
}