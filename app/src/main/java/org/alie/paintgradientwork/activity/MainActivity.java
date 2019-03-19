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

    private Button btn_radar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView(){
        btn_bitmap_gradient = findViewById(R.id.btn_bitmap_gradient);
        btn_linearLayout_gradient = findViewById(R.id.btn_linearLayout_gradient);
        btn_sweep_gradient = findViewById(R.id.btn_sweep_gradient);
        radial_gradient = findViewById(R.id.radial_gradient);

        btn_radar = findViewById(R.id.btn_radar);

    }
    private void  initListener(){
        btn_bitmap_gradient.setOnClickListener(this);
        btn_linearLayout_gradient.setOnClickListener(this);
        btn_sweep_gradient.setOnClickListener(this);
        radial_gradient.setOnClickListener(this);

        btn_radar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bitmap_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY,Const.BITMAP_GRADIENT,ShowGradientActivity.class);
                break;
            case R.id.btn_linearLayout_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY,Const.LINEARLAYOUT_GRADIENT,ShowGradientActivity.class);
                break;
            case R.id.btn_sweep_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY,Const.SWEEP_GRADIENT,ShowGradientActivity.class);
                break;
            case R.id.radial_gradient:
                goToNextPage(Const.INTENT_GRADIENT_KEY,Const.RADIAL_GRADIENT,ShowGradientActivity.class);
                break;

            case R.id.btn_radar:
                goToNextPage(Const.INTENT_TARGET_KEY,Const.RADAR_VIEW,TargetViewActivity.class);
                break;
        }
    }

    private void goToNextPage(String key,String tag,Class<?> mClass) {
        Intent intent = new Intent(this,mClass);
        intent.putExtra(key,tag);
        startActivity(intent);

    }
}
