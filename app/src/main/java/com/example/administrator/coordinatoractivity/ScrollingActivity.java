package com.example.administrator.coordinatoractivity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class ScrollingActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private ImageButton player_btn_back;
    private ImageButton player_btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = findViewById(R.id.app_bar);
       /* player_btn_back = findViewById(R.id.player_btn_back);
        player_btn_share = findViewById(R.id.course_bar_share_btn);*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                if ((float) Math.abs(verticalOffset) / totalScrollRange >= 0.9f) {
                  /*  player_btn_back.setBackground(ScrollingActivity.this.getResources().getDrawable(R.color.colorAccent));
                    player_btn_share.setBackground(ScrollingActivity.this.getResources().getDrawable(R.color.colorAccent));*/
                } else {
                    //这个是我切换的本地的dev分支
                  /*  player_btn_back.setBackground(ScrollingActivity.this.getResources().getDrawable(R.color.colorPrimaryDark));
                    player_btn_share.setBackground(ScrollingActivity.this.getResources().getDrawable(R.color.colorPrimaryDark));*/
                }
            }
        });
        appBarLayout.setExpanded(true,false);
    }

}
