package com.fitucab.ds1617b.fitucab.UI.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.fitucab.ds1617b.fitucab.Model.Helper.OnFragmentSwap;
import com.fitucab.ds1617b.fitucab.R;
import com.fitucab.ds1617b.fitucab.UI.Fragments.M05.M05LogExerciseFragment;
import com.fitucab.ds1617b.fitucab.UI.Fragments.M05.M05TrackActivityFragment;

public class M05AddExerciseActivity extends AppCompatActivity implements OnFragmentSwap{
    private FragmentTabHost mTabHost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m05_add_exercise);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);


        onTabSwap(mTabHost);
    }

    public void onTabSwap(FragmentTabHost mTabHost){



        mTabHost.addTab(mTabHost.newTabSpec("track").setIndicator("TRACK ACTIVITY"),

                M05TrackActivityFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("log").setIndicator(getResources().getString(R.string.tab_m05_log)),
                M05LogExerciseFragment.class, null);

    }

    @Override
    public void onSwap(String fragmentName, Bundle bundle){

        mTabHost.addTab(mTabHost.newTabSpec("track").setIndicator("TRACK ACTIVITY"),
                M05TrackActivityFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("log").setIndicator("LOG ACTIVITY"),
                M05LogExerciseFragment.class, null);
    }

    @Override
    public void onSwapActivity(String activityName, Bundle bundle) {
        switch (activityName){
            case "MainActivity":
                Intent newActivity = new Intent(this, MainActivity.class);
                startActivity(newActivity);
                break;
        }
    }
}
