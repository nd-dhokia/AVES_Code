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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.imgTopbarLeft)
    ImageView imgTopbarLeft;
    @BindView(R.id.txtTopbarTitle)
    TextView txtTopbarTitle;
    @BindView(R.id.relativeTopBar)
    RelativeLayout relativeTopBar;
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtLocation)
    TextView txtLocation;
    @BindView(R.id.txtBio)
    TextView txtBio;

    public ProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtTopbarTitle.setText(R.string.profile);

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