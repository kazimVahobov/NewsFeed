package com.example.newsfeed.ui.main_fragment

import com.example.newsfeed.data.db.entities.Article

interface MainFragmentInterface {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun onGetArticles(articles: MutableList<Article>)
    }

    interface Presenter {
        fun loadArticles()
    }
}