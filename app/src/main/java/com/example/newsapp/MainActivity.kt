package com.example.newsapp

import android.content.Intent
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
        val newsContent = arrayOf(
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content)
        )
        val newsList = arrayListOf<News>()
        for (index in newsImg.indices){
            val newsElem = News(newsImg[index],newsHeadline[index],newsContent[index])
            newsList.add(newsElem)
        }
//        Setting Up the Recycler View Adapter
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val newsAdapter = NewsAdapter(this,newsList)
        recyclerView.adapter = newsAdapter
        newsAdapter.setItemClickListener(object:NewsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity,NewsDetailActivity::class.java)
                intent.putExtra("newsImg",newsList[position].img)
                intent.putExtra("newsHeadLine",newsList[position].newsHeadLine)
                intent.putExtra("newsContent",newsList[position].newsContent)
                startActivity(intent)
            }

        })
    }
}