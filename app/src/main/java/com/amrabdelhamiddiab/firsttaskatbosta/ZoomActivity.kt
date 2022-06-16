package com.amrabdelhamiddiab.firsttaskatbosta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.ActivityZoomBinding

class ZoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityZoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = intent.getStringExtra("url")
        if (url != null) {
            Log.d("ZoomActivity", url)
        }
        binding.url = url
    }
}