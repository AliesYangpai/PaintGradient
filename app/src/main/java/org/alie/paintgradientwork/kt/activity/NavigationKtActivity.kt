package org.alie.paintgradientwork.kt.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.alie.paintgradientwork.R
import org.alie.paintgradientwork.kt.Const
import org.alie.paintgradientwork.view.gradient.BitmapGradientView
import java.lang.StringBuilder

class NavigationKtActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn_bitmap_gradient: Button
    private lateinit var btn_linearLayout_gradient: Button
    private lateinit var btn_sweep_gradient: Button
    private lateinit var btn_radial_gradient: Button
    private lateinit var btn_compose_gradient: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_kt)
        initView()
        initListener()
    }

    fun initView() {
        btn_bitmap_gradient = findViewById(R.id.btn_bitmap_gradient)
        btn_linearLayout_gradient = findViewById(R.id.btn_linearLayout_gradient)
        btn_sweep_gradient = findViewById(R.id.btn_sweep_gradient)
        btn_radial_gradient = findViewById(R.id.btn_radial_gradient)
        btn_compose_gradient = findViewById(R.id.btn_compose_gradient)
    }

    fun initListener() {
        btn_bitmap_gradient.setOnClickListener(this)
        btn_linearLayout_gradient.setOnClickListener(this)
        btn_sweep_gradient.setOnClickListener(this)
        btn_radial_gradient.setOnClickListener(this)
        btn_compose_gradient.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_bitmap_gradient -> goToNextPage(
                Const.INTENT_GRADIENT_KEY,
                Const.GRADIENT_BITMAP,
                ShowGradientKtActivity::class.java
            )

            R.id.btn_linearLayout_gradient -> goToNextPage(
                Const.INTENT_GRADIENT_KEY,
                Const.GRADIENT_LINEAR,
                ShowGradientKtActivity::class.java
            )
            R.id.btn_sweep_gradient -> goToNextPage(
                Const.INTENT_GRADIENT_KEY,
                Const.GRADIENT_SWEEP,
                ShowGradientKtActivity::class.java
            )
            R.id.btn_radial_gradient -> goToNextPage(
                Const.INTENT_GRADIENT_KEY,
                Const.GRADIENT_RADIAL,
                ShowGradientKtActivity::class.java
            )
//            R.id.btn_compose_gradient -> goToNextPage()
        }
    }

    private fun goToNextPage(key: String, value: String, clazz: Class<*>) {
        val intent = Intent(this, clazz)
        intent.putExtra(key, value)
        startActivity(intent)
    }
}
