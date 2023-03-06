package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//     1.Creating the Data that that is to be populated in the Recycler View
        val newsImg = intArrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5)
        val newsHeadline = arrayOf(
            "Cool Captain MS Dhoni retires from international cricket, will continue in IPL",
            "MATCH REPORT: MATCH 1, GG VS MI, WPL 2023",
            "19 Lesser-Known Facts About Subrahmanyam Jaishankar, Minister Of External Affairs",
            "News updates from HT: India may lead the world by 2030, says ex-US envoy and all the latest news",
            "Coronavirus India Updates: India locks down for 21 days but no need to panic"

        )
        val newsLink = arrayOf(
            "https://english.newsnationtv.com/sports/cricket/cool-captain-ms-dhoni-retires-from-international-cricket-will-continue-in-ipl-258911.html",
            "https://www.wplt20.com/news/match-report-match-1-gg-vs-mi-wpl-2023",
            "https://www.postoast.com/subrahmanyam-jaishankar/",
            "https://www.hindustantimes.com/india-news/news-updates-from-ht-india-may-lead-the-world-by-2030-says-ex-us-envoy-101627975096338.html",
            "https://timesofindia.indiatimes.com/sports/cricket/wpl/gujarat-giants-vs-mumbai-indians-live-score-wpl-updates-womens-premier-league/liveblog/98413201.cms"

        )
        val newsList = arrayListOf<News>()
        for (index in newsImg.indices){
            val newsElem = News(newsImg[index],newsHeadline[index],newsLink[index])
            newsList.add(newsElem)
        }
//        Setting Up the Recycler View Adapter
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NewsAdapter(this,newsList)
    }
}