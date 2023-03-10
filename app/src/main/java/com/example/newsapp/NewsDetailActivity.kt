package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsImg = intent.getIntExtra("newsImg",R.drawable.img1)
        val newsHeadLine = intent.getStringExtra("newsHeadLine")
        val newsContent = intent.getStringExtra("newsContent")

        binding.ivNews.setImageResource(newsImg)
        binding.tvNewsHeadline.text = newsHeadLine
        binding.tvNewsContent.text = newsContent
    }
}