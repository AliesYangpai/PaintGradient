package org.alie.paintgradientwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.alie.paintgradientwork.R;
import org.alie.paintgradientwork.view.filter.FilterView;

/**
 * 滤镜的activity
 */
public class FilterActivity extends AppCompatActivity {
    private FilterView fv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        initView();
    }

    private void initView(){
        fv = findViewById(R.id.fv);
    }
}
