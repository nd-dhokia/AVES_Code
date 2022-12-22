package com.aves_code.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.aves_code.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment {

    HomeActivity homeActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HomeActivity) {
            homeActivity = (HomeActivity) context;
        }
    }

    public List<String> getStringList(int norecord, String DisplayContent) {
//        Toast.makeText(getActivity(), "Test", Toast.LENGTH_SHORT).show();
        List<String> datalist = new ArrayList<>();
        for (int i = 1; i <= norecord; i++) {
            datalist.add(DisplayContent);
        }
        return datalist;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
