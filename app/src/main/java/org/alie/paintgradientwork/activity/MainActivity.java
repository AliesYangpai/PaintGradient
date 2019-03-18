package org.alie.paintgradientwork.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.alie.paintgradientwork.Const;
import org.alie.paintgradientwork.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bitmap_gradient;
    private Button btn_linearLayout_gradient;
    private Button btn_sweep_gradient;
    private Button radial_gradient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView(){
        btn_bitmap_gradient = findViewById(R.id.btn_bitmap_gradient);
        btn_linearLayout_gradient = findViewById(R.id.btn_linearLayout_gradient);;
        btn_sweep_gradient = findViewById(R.id.btn_sweep_gradient);;
        radial_gradient = findViewById(R.id.radial_gradient);;

    }
    private void  initListener(){
        btn_bitmap_gradient.setOnClickListener(this);
        btn_linearLayout_gradient.setOnClickListener(this);
        btn_sweep_gradient.setOnClickListener(this);
        radial_gradient.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bitmap_gradient:
                goToNextPage(Const.BITMAP_GRADIENT);
                break;
            case R.id.btn_linearLayout_gradient:
                goToNextPage(Const.LINEARLAYOUT_GRADIENT);
                break;
            case R.id.btn_sweep_gradient:
                goToNextPage(Const.SWEEP_GRADIENT);
                break;
            case R.id.radial_gradient:
                goToNextPage(Const.RADIAL_GRADIENT);
                break;
        }
    }

    private void goToNextPage(String tag) {
        Intent intent = new Intent(this,ShowGradientActivity.class);
        intent.putExtra(Const.INTENT_GRADIENT_KEY,tag);
        startActivity(intent);

    }
}
