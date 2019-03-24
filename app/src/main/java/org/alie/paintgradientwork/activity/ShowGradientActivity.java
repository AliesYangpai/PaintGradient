package org.alie.paintgradientwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.alie.paintgradientwork.Const;
import org.alie.paintgradientwork.R;
import org.alie.paintgradientwork.view.gradient.BitmapGradientView;
import org.alie.paintgradientwork.view.gradient.ComposeGadientView;
import org.alie.paintgradientwork.view.gradient.LinearGradientView;
import org.alie.paintgradientwork.view.gradient.RadialGradientView;
import org.alie.paintgradientwork.view.gradient.SweepGradientView;


public class ShowGradientActivity extends AppCompatActivity {

    private String currentTag;
    private BitmapGradientView bgv;
    private RadialGradientView rgv;
    private LinearGradientView lgv;
    private SweepGradientView sgv;
    private ComposeGadientView cvp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gradient);
        initView();
        getIntentTag();
        doShowDiffirentView();
    }

    private void initView() {
        bgv = findViewById(R.id.bgv);
        lgv = findViewById(R.id.lgv);
        rgv = findViewById(R.id.rgv);
        sgv = findViewById(R.id.sgv);
        cvp = findViewById(R.id.cvp);
    }


    private void doShowDiffirentView() {
        switch (currentTag){
            case Const.BITMAP_GRADIENT:
                bgv.setVisibility(View.VISIBLE);
                break;
            case Const.LINEARLAYOUT_GRADIENT:
                lgv.setVisibility(View.VISIBLE);
                break;
            case Const.SWEEP_GRADIENT:
                sgv.setVisibility(View.VISIBLE);
                break;
            case Const.RADIAL_GRADIENT:
                rgv.setVisibility(View.VISIBLE);
                break;
            case Const.COMPOSE_GRADIENT:
                cvp.setVisibility(View.VISIBLE);
                break;
        }
    }


    private void getIntentTag() {
        Intent intent = this.getIntent();
        if (null != intent) {
            currentTag = intent.getStringExtra(Const.INTENT_GRADIENT_KEY);
        }
    }
}
