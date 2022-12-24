package com.aves_code.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aves_code.R;
import com.aves_code.model.photo.PhotoPojo;
import com.aves_code.utils.DebugLog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.imgTopbarLeft)
    ImageView imgTopbarLeft;
    @BindView(R.id.txtTopbarTitle)
    TextView txtTopbarTitle;
    @BindView(R.id.relativeTopBar)
    RelativeLayout relativeTopBar;
    @BindView(R.id.imgItems)
    ImageView imgItems;
    @BindView(R.id.txtDiscription)
    TextView txtDiscription;

    private PhotoPojo photoPojos ;


    public void setPhotoPojos(PhotoPojo photoPojos) {
        this.photoPojos = photoPojos;
    }

    public DetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(PhotoPojo photoData) {
        DetailFragment fragment = new DetailFragment();
        fragment.setPhotoPojos(photoData);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtTopbarTitle.setText(photoPojos.getUser().getName());
        Glide.with(getActivity()).
                load(photoPojos.getUrls().getRegular())
                .thumbnail(Glide.with(getContext()).load(R.drawable.ic_launcher_background))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgItems);
        txtDiscription.setText(photoPojos.getUser().getBio());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.imgTopbarLeft)
    public void onClick() {
        homeActivity.onBackPressed();
    }
}