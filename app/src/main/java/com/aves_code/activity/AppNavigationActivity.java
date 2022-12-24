package com.aves_code.activity;

import android.graphics.Bitmap;

import androidx.fragment.app.FragmentManager;

import com.aves_code.FragmentState.FragmentState;
import com.aves_code.fragment.DetailFragment;
import com.aves_code.fragment.HomeFragment;
import com.aves_code.fragment.ProfileFragment;
import com.aves_code.listener.iAppNavigator;
import com.aves_code.model.photo.PhotoPojo;

import java.util.List;

public class AppNavigationActivity extends BaseActivity implements iAppNavigator {

    @Override
    public void openHomeFragment(FragmentState fragmentState) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentChange(HomeFragment.newInstance(), fragmentState);
    }

    @Override
    public void openDetailFragment(FragmentState fragmentState, PhotoPojo photoData) {
        fragmentChange(DetailFragment.newInstance(photoData), fragmentState);
    }

    @Override
    public void openProfileFragment(FragmentState fragmentState, PhotoPojo photoData) {
        fragmentChange(ProfileFragment.newInstance(photoData), fragmentState);
    }


}
