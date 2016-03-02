package me.walmyrcarvalho.recrutamentoandroid.ui.screen.seasondetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;

public class SeasonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_detail);

        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            initFragment(SeasonDetailFragment.newInstance());
        }
    }

    private void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }
}
