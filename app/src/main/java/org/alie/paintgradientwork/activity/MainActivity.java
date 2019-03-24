package org.alie.paintgradientwork.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.alie.paintgradientwork.Const;
import org.alie.paintgradientwork.R;

import java.util.concurrent.CompletionService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bitmap_gradient;
    private Button btn_linearLayout_gradient;
    private Button btn_sweep_gradient;
    private Button radial_gradient;
    private Button compose_gradient;

    private Button btn_radar;
    private Button btn_neon_light;

    private Button btn_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        btn_bitmap_gradient = findViewById(R.id.btn_bitmap_gradient);
        btn_linearLayout_gradient = findViewById(R.id.btn_linearLayout_gradient);
        btn_sweep_gradient = findViewById(R.id.btn_sweep_gradient);
        radial_gradient = findViewById(R.id.radial_gradient);
        compose_gradient = findViewById(R.id.compose_gradient);

        btn_radar = findViewById(R.id.btn_radar);
        btn_neon_light = findViewById(R.id.btn_neon_light);

        btn_filter = findViewById(R.id.btn_filter);

    }

    private void initListener() {
        btn_bitmap_gradient.setOnClickListener(this);
        btn_linearLayout_gradient.setOnClickListener(this);
        btn_sweep_gradient.setOnClickListener(this);
        radial_gradient.setOnClickListener(this);
        compose_gradient.setOnClickListener(this);

        btn_radar.setOnClickListener(this);
        btn_neon_light.setOnClickListener(this);

        btn_filter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bitmap_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY, Const.BITMAP_GRADIENT, ShowGradientActivity.class);
                break;
            case R.id.btn_linearLayout_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY, Const.LINEARLAYOUT_GRADIENT, ShowGradientActivity.class);
                break;
            case R.id.btn_sweep_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY, Const.SWEEP_GRADIENT, ShowGradientActivity.class);
                break;
            case R.id.radial_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY, Const.RADIAL_GRADIENT, ShowGradientActivity.class);
                break;
            case R.id.compose_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY, Const.COMPOSE_GRADIENT, ShowGradientActivity.class);
                break;
            case R.id.btn_radar:
                goToNextPage(Const.INTENT_TARGET_KEY, Const.RADAR_VIEW, TargetViewActivity.class);
                break;
            case R.id.btn_neon_light:
                goToNextPage(Const.INTENT_TARGET_KEY, Const.LINEAR_GRADIENT_TEXT_VIEW, TargetViewActivity.class);
                break;
            case R.id.btn_filter:

                goToNextPage(Const.INTENT_FILTER_KEY, Const.FLITER_BACK_OR_WHITE, FilterActivity.class);
                break;

        }
    }

    private void goToNextPage(String key, String tag, Class<?> mClass) {
        Intent intent = new Intent(this, mClass);
        intent.putExtra(key, tag);
        startActivity(intent);

    }
}
