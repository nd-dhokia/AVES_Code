package com.aves_code.adapter.viewholder;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aves_code.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imgItems)
    public  ImageView imgItems;
    @BindView(R.id.Discription)
    public TextView Discription;
    @BindView(R.id.imgProfile)
    public ImageView imgProfile;
    @BindView(R.id.txtProfileName)
    public TextView txtProfileName;
    @BindView(R.id.linearItem)
    public LinearLayout linearItem;
    @BindView(R.id.cardViewRoot)
    public CardView cardViewRoot;

    public HomeHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
