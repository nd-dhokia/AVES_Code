package com.aves_code.apicall;


import com.aves_code.model.photo.PhotoPojo;

import java.util.List;

import retrofit2.Call;


public interface iResponseCallback<T> {
    void success(T data);

    void onFailure(List<PhotoPojo> photoPojo);

    void onError(Call<T> responseCall, Throwable T);
}
