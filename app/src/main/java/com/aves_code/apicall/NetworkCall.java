package com.aves_code.apicall;

import com.aves_code.model.photo.PhotoPojo;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements  iApiMethodList{

    private static NetworkCall instance = new NetworkCall();
    private iApiService apiService;

    private NetworkCall() {
        apiService = RetroClient.getApiService();
    }

    public static NetworkCall getInstance() {
        return instance;
    }

    @Override
    public void callGetPhotoListDataApi(HashMap<String, String> param, iResponseCallback<List<PhotoPojo>> callback) {
        Call<List<PhotoPojo>> call = apiService.callGetPhotoListData(param);
        call.enqueue(new Callback<List<PhotoPojo>>() {
            @Override
            public void onResponse(Call<List<PhotoPojo>> call, Response<List<PhotoPojo>> response) {
                List<PhotoPojo> baseModel = response.body();
                if (response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    callback.onFailure(baseModel);
                }
            }

            @Override
            public void onFailure(Call<List<PhotoPojo>> call, Throwable t) {
                callback.onError(call, t);
            }
        });
    }
}
