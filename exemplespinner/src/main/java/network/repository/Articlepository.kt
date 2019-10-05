package network.repository

import adaptateur.Article
import network.ArticleService
import retrofit2.Retrofit

class Articlepository {
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        }.build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article> {
        val response =  service.list().execute()
        return response.body() ?: emptyList()
    }
}