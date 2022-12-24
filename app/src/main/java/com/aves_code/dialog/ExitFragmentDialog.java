package com.aves_code.dialog;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import com.aves_code.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ExitFragmentDialog extends DialogFragment {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtMessage)
    TextView txtMessage;
    @BindView(R.id.linearLine)
    LinearLayout linearLine;
    @BindView(R.id.txtOk)
    TextView txtOk;
    Unbinder unbinder;
    @BindView(R.id.imgCancel)
    ImageView imgCancel;

    public static ExitFragmentDialog newInstance() {

        ExitFragmentDialog fragment = new ExitFragmentDialog();
//        fragment.setNotificationModel(notificationModel);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);

        View view = inflater.inflate(R.layout.dialog_fragment_exit, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtMessage.setText(R.string.exit_dialog);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.imgCancel, R.id.txtOk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgCancel:
                dismiss();
                break;
            case R.id.txtOk:
                dismiss();
                getActivity().finish();
                break;
        }
    }
}
