package com.aves_code.apicall;

import com.aves_code.model.photo.PhotoPojo;

import java.util.HashMap;
import java.util.List;

public interface iApiMethodList {

    void callGetPhotoListDataApi(HashMap<String, String> param, iResponseCallback<List<PhotoPojo>> callback);
}
