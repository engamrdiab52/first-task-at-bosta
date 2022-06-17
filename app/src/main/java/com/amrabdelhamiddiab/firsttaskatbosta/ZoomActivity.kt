package com.amrabdelhamiddiab.firsttaskatbosta

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.MenuItemCompat
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.ActivityZoomBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class ZoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityZoomBinding
    private lateinit var imageView: ImageView
    private var shareIntent: Intent? = null
    private lateinit var shareActionProvider: androidx.appcompat.widget.ShareActionProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView = binding.imageSingle
        val url = intent.getStringExtra("url")
        if (url != null) {
            Log.d("ZoomActivity", url)
        }
        val rightImage = GlideUrl(url, LazyHeaders.Builder().addHeader("User-Agent", "5").build())
        Glide.with(this).asBitmap().load(rightImage).into(object : CustomTarget<Bitmap?>() {
            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap?>?) {
                imageView.setImageBitmap(resource)
                prepareShareIntent(resource)
                attachShareIntentAction()
            }

        })
        binding.button2.setOnClickListener {
            startActivity(Intent.createChooser(shareIntent, "Share image"))
        }
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_zoom_activity, menu)
        val shareItem = menu.findItem(R.id.menu_item_share)
        shareActionProvider =
            MenuItemCompat.getActionProvider(shareItem) as androidx.appcompat.widget.ShareActionProvider
        attachShareIntentAction()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_share -> Toast.makeText(this, "share now", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun prepareShareIntent(bitmap: Bitmap) {
        val uri = getContentUri(bitmap)
        if (uri != null) {
            shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent!!.putExtra(Intent.EXTRA_STREAM, uri).type = "image/*"
        } else {
            Toast.makeText(this, "uri null", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getContentUri(bitmap: Bitmap): Uri? {
        val imagesFolder = File(cacheDir, "images")
        var contentUri: Uri? = null
        try {
            imagesFolder.mkdirs()// create folder if not exist
            val file = File(imagesFolder, "share_image.png")
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream)
            stream.flush()
            stream.close()
            contentUri =
                FileProvider.getUriForFile(
                    this,
                    "com.amrabdelhamiddiab.firsttaskatbosta.fileprovider",
                    file
                )

        } catch (e: Exception) {
            Toast.makeText(this, "uri error", Toast.LENGTH_SHORT).show()
        }
        return contentUri
    }

    private fun attachShareIntentAction() {
        if (shareIntent != null)
            shareActionProvider.setShareIntent(shareIntent)

    }
}