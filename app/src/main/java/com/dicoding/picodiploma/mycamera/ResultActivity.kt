package com.dicoding.picodiploma.mycamera

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.mycamera.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityResultBinding.inflate(layoutInflater).apply {

            setContentView(root)

            val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
            imageUri?.let {
                Log.d("Image URI", "showImage: $it")
                resultImage.setImageURI(it)
            }
            val detectedText = intent.getStringExtra(EXTRA_RESULT)
            resultText.text = detectedText
        }

    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }
}