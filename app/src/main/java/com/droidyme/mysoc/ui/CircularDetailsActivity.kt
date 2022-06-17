package com.droidyme.mysoc.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityCircularDetailsBinding
import com.droidyme.mysoc.utility.closeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CircularDetailsActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private lateinit var binding: ActivityCircularDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_circular_details)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Circular"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { onBackPressed() }
        binding.toolBarLayout.imgSingleAction.visibility = View.VISIBLE

        actionClick()
    }

    private fun actionClick() {
        binding.toolBarLayout.imgSingleAction.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                killMedia()
                prepare("https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3")
                mediaPlayer.start()
            }
        }
    }

    private fun playAudio(url: String) {
        GlobalScope.launch(Dispatchers.Main) {
            killMedia()
            prepare(url)
            mediaPlayer.start()
        }

    }

    private fun prepare(url: String) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()
    }

    private fun killMedia() {
        if (mediaPlayer.isPlaying) {
            try {
                mediaPlayer.release()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onBackPressed() {
        GlobalScope.launch(Dispatchers.Main) {
            killMedia()
            closeScreen()
        }
    }
}