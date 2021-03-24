package com.user.brayan.primerapp.iu.web_service

import android.util.Log
import com.user.brayan.primerapp.api.ApiClient
import com.user.brayan.primerapp.model.GitHubRepo
import com.user.brayan.primerapp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebServicePresenter(var user: User, var  api: ApiClient): WebService.Presenter {
    private lateinit var view: WebService.View

    override fun setView(view: WebService.View) {
        this.view = view
        this.view.showUser(user)
    }

    override fun solicitudWebService() {
        val call: Call<List<GitHubRepo>> = api.getReposForUser("albertoandroid")
        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onResponse(
                call: Call<List<GitHubRepo>>,
                response: Response<List<GitHubRepo>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach { it ->
                        Log.e("datos", "Nombre: ${it.name}, Avatar: ${it.owner.avatar_url}")
                    }
                }
            }

            override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {

            }

        })
    }

}