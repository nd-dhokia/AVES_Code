package com.aves_code.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aves_code.R;
import com.aves_code.adapter.generic_adapter.GenericAdapter;
import com.aves_code.adapter.viewholder.HomeHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

        txtTopbarTitle.setText("TEST");
        imgTopbarLeft.setVisibility(View.GONE);


        LinearLayoutManager lLayout = new LinearLayoutManager(getContext());
        rvHome.setLayoutManager(lLayout);
        setAdapter();
    }

    private void setAdapter() {
        final List<String> data = getStringList(20, "Branch");
        GenericAdapter<String, HomeHolder> adapter = new GenericAdapter<String, HomeHolder>(R.layout.row_home, HomeHolder.class, data) {


            @Override
            public void loadMore() {

            }

            @Override
            public void setViewHolderData(HomeHolder viewHolderData, String data, int position) {



            }

            @Override
            public void setViewHolderData(HomeHolder holder, HomeHolder data, int position) {

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