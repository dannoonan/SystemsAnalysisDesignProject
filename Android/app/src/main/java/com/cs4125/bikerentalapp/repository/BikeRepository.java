package com.cs4125.bikerentalapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.cs4125.bikerentalapp.model.entity.ReturnDetails;
import com.cs4125.bikerentalapp.web.ResponseBody;
import com.cs4125.bikerentalapp.web.Webservice;

import java.io.IOException;
import java.util.concurrent.Executor;

import retrofit2.Response;

public class BikeRepository implements IBikeRepository{
    private final Webservice webservice;
    private final Executor executor;

    public BikeRepository(Webservice webservice, Executor executor){
        this.webservice = webservice;
        this.executor = executor;
    }


    public LiveData<Response> setBikeStatus(int UserId, int StatusId){
        MutableLiveData<Response> liveResponse = new MutableLiveData<>();

        executor.execute(() -> {
            Response response;
            try {
                response = webservice.setBikeStatus(UserId, StatusId).execute();
                liveResponse.postValue(response);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        });

        return liveResponse;
    }

    public LiveData<ResponseBody> rentBike(int bikeId, int userId){
        MutableLiveData<ResponseBody> liveResponse = new MutableLiveData<>();

        executor.execute(() -> {
            Response<ResponseBody> response;
            try {
                response = webservice.rentBike(bikeId, userId).execute();
                liveResponse.postValue(response.body());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        });

        return liveResponse;
    }

    public LiveData<ResponseBody> returnBike(ReturnDetails details){
        MutableLiveData<ResponseBody> liveResponse = new MutableLiveData<>();

        executor.execute(() -> {
            Response<ResponseBody> response;
            try {
                response = webservice.returnBike(
                        details.getOrderId(),
                        details.getLatitude(),
                        details.getLongitude(),
                        details.getAmountPaid(),
                        details.getStudentCardId(),
                        details.getNodeId()).execute();

                liveResponse.postValue(response.body());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        });

        return liveResponse;
    }
}