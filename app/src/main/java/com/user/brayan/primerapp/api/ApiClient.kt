package com.user.brayan.primerapp.api

import com.user.brayan.primerapp.model.GitHubRepo
import com.user.brayan.primerapp.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/users/{user}/repos")
    fun getReposForUser(@Path("user") user: String): Call<List<GitHubRepo>>
}