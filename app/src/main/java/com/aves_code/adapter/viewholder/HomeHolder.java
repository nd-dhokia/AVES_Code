package com.aves_code.adapter.viewholder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeHolder extends RecyclerView.ViewHolder {

//    @BindView(R.id.imgArticle)
//    public ImageView imgArticle;
//    @BindView(R.id.txtArticle)
//    public TextView txtArticle;
//    @BindView(R.id.cardViewRoot)
//    public CardView cardViewRoot;

    public HomeHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
