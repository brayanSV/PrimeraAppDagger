package com.user.brayan.primerapp.di

import android.app.Application
import android.content.Context
import com.user.brayan.primerapp.api.ApiClient
import com.user.brayan.primerapp.iu.login.Login
import com.user.brayan.primerapp.iu.login.LoginPresenter
import com.user.brayan.primerapp.iu.profile.Profile
import com.user.brayan.primerapp.iu.profile.ProfilePresenter
import com.user.brayan.primerapp.iu.web_service.WebService
import com.user.brayan.primerapp.iu.web_service.WebServicePresenter
import com.user.brayan.primerapp.model.User
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule(application: Application) {
    private var application: Application? = null

    companion object {
        internal const val BASE_URL = "https://api.github.com"
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = this.application as Application

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = this.application as Application

    @Provides
    @Singleton
    fun provideUser(): User = User()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(converterFactory)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)

    @Provides
    @Singleton
    fun providePresenterLogin(user: User): Login.Presenter = LoginPresenter(user)

    @Provides
    @Singleton
    fun providePresenterProfile(user: User): Profile.Presenter = ProfilePresenter(user)

    @Provides
    @Singleton
    fun providePresenterWebService(user: User, api: ApiClient): WebService.Presenter = WebServicePresenter(user, api)

    init {
        this.application = application
    }
}