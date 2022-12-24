package com.aves_code.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aves_code.FragmentState.FragmentState;
import com.aves_code.R;
import com.aves_code.adapter.generic_adapter.GenericAdapter;
import com.aves_code.adapter.viewholder.HomeHolder;
import com.aves_code.apicall.ApiParam;
import com.aves_code.apicall.NetworkCall;
import com.aves_code.apicall.iResponseCallback;
import com.aves_code.model.photo.PhotoPojo;
import com.aves_code.utils.DebugLog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.imgTopbarLeft)
    ImageView imgTopbarLeft;
    @BindView(R.id.txtTopbarTitle)
    TextView txtTopbarTitle;
    @BindView(R.id.relativeTopBar)
    RelativeLayout relativeTopBar;
    @BindView(R.id.rvHome)
    RecyclerView rvHome;

    GenericAdapter<String, HomeHolder> adapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtTopbarTitle.setText(R.string.photo);
        imgTopbarLeft.setVisibility(View.GONE);


        LinearLayoutManager lLayout = new LinearLayoutManager(getContext());
        rvHome.setLayoutManager(lLayout);

        callPhotoListApi();
    }

    private void callPhotoListApi() {
        homeActivity.showProgressDialog();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(ApiParam.CLIENT_ID, ApiParam.CLIENT_ID_V);

        NetworkCall.getInstance().callGetPhotoListDataApi(params, new iResponseCallback<List<PhotoPojo>>() {
            @Override
            public void success(List<PhotoPojo> data) {
                setAdapter(data);
            }


            @Override
            public void onFailure(List<PhotoPojo> baseModel) {
                DebugLog.e("Status onFailure: API Fail");
            }

            @Override
            public void onError(Call<List<PhotoPojo>> responseCall, Throwable T) {
                DebugLog.e("Throwable onError: " + T.toString());
            }

        });
        homeActivity.hideProgressDialog();
    }

    private void setAdapter(List<PhotoPojo> data1) {
        GenericAdapter<PhotoPojo, HomeHolder> adapter = new GenericAdapter<PhotoPojo, HomeHolder>(R.layout.row_home, HomeHolder.class, data1) {
            @Override
            public void setViewHolderData(HomeHolder viewHolderData, PhotoPojo data, int position) {
                viewHolderData.txtProfileName.setText(data.getUser().getName());
                viewHolderData.txtDiscription.setText(data.getUser().getBio());
                RequestOptions requestOptions = new RequestOptions();
                requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(25));
                Glide.with(getActivity()).
                        load(data.getUser().getProfileImage().getLarge())
                        .thumbnail(Glide.with(getContext()).load(R.drawable.ic_launcher_background))
                        .apply(requestOptions)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(viewHolderData.imgProfile);

                Glide.with(getActivity()).
                        load(data.getUrls().getRegular())
                        .thumbnail(Glide.with(getContext()).load(R.drawable.ic_launcher_background))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(viewHolderData.imgItems);

                viewHolderData.imgItems.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        homeActivity.openDetailFragment(FragmentState.ADD, data);
                    }
                });

                viewHolderData.imgProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        homeActivity.openProfileFragment(FragmentState.ADD, data);
                    }
                });

                viewHolderData.txtProfileName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        homeActivity.openProfileFragment(FragmentState.ADD, data);
                    }
                });
            }
        };
        if (rvHome != null)
            rvHome.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}