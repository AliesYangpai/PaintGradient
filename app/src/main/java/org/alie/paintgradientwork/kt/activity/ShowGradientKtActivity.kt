package org.alie.paintgradientwork.kt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.alie.paintgradientwork.R
import org.alie.paintgradientwork.kt.Const
import org.alie.paintgradientwork.kt.gradient.BitmapGradientView
import org.alie.paintgradientwork.kt.gradient.LinearGradientView
import org.alie.paintgradientwork.kt.gradient.RadialGradientView
import org.alie.paintgradientwork.kt.gradient.SweepGradientView

class ShowGradientKtActivity : AppCompatActivity() {

    private var tag: String? = null
    private lateinit var bitmapGradientView: BitmapGradientView
    private lateinit var linearGradientView: LinearGradientView
    private lateinit var radialGradientView: RadialGradientView
    private lateinit var sweepGradientView: SweepGradientView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_gradient_kt)
        getIntentTag()
        initView()
        initData()
    }

    private fun getIntentTag() {
        tag = intent?.getStringExtra(Const.INTENT_GRADIENT_KEY)
    }

    private fun initView() {
        bitmapGradientView = findViewById(R.id.bitmapGradientView)
        linearGradientView = findViewById(R.id.linearGradientView)
        radialGradientView = findViewById(R.id.radialGradientView)
        sweepGradientView = findViewById(R.id.sweepGradientView)
    }

    private fun initData() {
        when (tag) {
            Const.GRADIENT_BITMAP -> bitmapGradientView.visibility = View.VISIBLE
            Const.GRADIENT_LINEAR -> linearGradientView.visibility = View.VISIBLE
            Const.GRADIENT_RADIAL -> radialGradientView.visibility = View.VISIBLE
            Const.GRADIENT_SWEEP -> sweepGradientView.visibility = View.VISIBLE
        }
    }

}
