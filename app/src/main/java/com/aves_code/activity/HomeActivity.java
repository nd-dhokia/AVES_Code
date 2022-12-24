package com.aves_code.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.aves_code.AppLevelClass;
import com.aves_code.FragmentState.FragmentState;
import com.aves_code.R;

public class HomeActivity extends AppNavigationActivity {

    FrameLayout fragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);

        openHomeFragment(FragmentState.REPLACE);
    }

    @Override
    public void onBackPressed() {
        int i = getSupportFragmentManager().getBackStackEntryCount();
        if (i > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
//            ExitFragmentDialog exitFragmentDialog = ExitFragmentDialog.newInstance();
//            exitFragmentDialog.show(getSupportFragmentManager(), exitFragmentDialog.getClass().getSimpleName());
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppLevelClass.getInstance().getBus().unregister(this);
    }
}