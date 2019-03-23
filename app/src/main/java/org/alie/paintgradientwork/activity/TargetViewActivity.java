package org.alie.paintgradientwork.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.alie.paintgradientwork.Const;
import org.alie.paintgradientwork.R;
import org.alie.paintgradientwork.targetview.LinearGradientTextView;
import org.alie.paintgradientwork.targetview.RadarView;

public class TargetViewActivity extends AppCompatActivity {

    private RadarView rv;
    private LinearGradientTextView lgtv;
    private String currentTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_view);
        getIntentTag();
        initView();
        doShowDiffirentView();
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        lgtv = findViewById(R.id.lgtv);
    }

    private void doShowDiffirentView() {
        switch (currentTag){
            case Const.RADAR_VIEW:
                rv.setVisibility(View.VISIBLE);
                break;
            case Const.LINEAR_GRADIENT_TEXT_VIEW:
                lgtv.setVisibility(View.VISIBLE);
                break;

        }
    }


    private void getIntentTag() {
        Intent intent = this.getIntent();
        if (null != intent) {
            currentTag = intent.getStringExtra(Const.INTENT_TARGET_KEY);
        }
    }
}
