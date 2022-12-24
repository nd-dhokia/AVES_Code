package com.aves_code.apicall;

import com.aves_code.model.photo.PhotoPojo;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface iApiService {

    //get Restaurant list
    @GET(ApiParam.CHILD_URL)
    Call<List<PhotoPojo>> callGetPhotoListData(@QueryMap HashMap<String, String> map);

}
