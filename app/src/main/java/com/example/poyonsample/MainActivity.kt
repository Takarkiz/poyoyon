package com.example.poyonsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.poyonsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.purinImage.setOnClickListener {
            startSmallerEmojiAnimation()
        }
    }

    private lateinit var binding: ActivityMainBinding

    private val xScaleAnimation: SpringAnimation by lazy {
        SpringAnimation(binding.purinImage, SpringAnimation.SCALE_X).apply {
            spring = SpringForce(1f).apply {
                dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
                stiffness = SpringForce.STIFFNESS_LOW
            }
        }
    }

    private val yScaleAnimation: SpringAnimation by lazy {
        SpringAnimation(binding.purinImage, SpringAnimation.SCALE_Y).apply {
            spring = SpringForce(1f).apply {
                dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
                stiffness = SpringForce.STIFFNESS_LOW
            }
        }
    }

    private fun startSmallerEmojiAnimation() {
        binding.purinImage.scaleX = 0.6f
        binding.purinImage.scaleY = 0.6f

        xScaleAnimation.start()
        yScaleAnimation.start()
    }
}