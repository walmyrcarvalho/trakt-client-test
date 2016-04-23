package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

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
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
