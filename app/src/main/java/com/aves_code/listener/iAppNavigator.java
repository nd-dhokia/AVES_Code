package com.aves_code.listener;

import android.graphics.Bitmap;

import com.aves_code.FragmentState.FragmentState;
import com.aves_code.model.photo.PhotoPojo;

import java.util.List;

public interface iAppNavigator {

    void openHomeFragment(FragmentState fragmentState);

    void openDetailFragment(FragmentState fragmentState, PhotoPojo photoData);

    void openProfileFragment(FragmentState fragmentState, PhotoPojo photoData);

}
