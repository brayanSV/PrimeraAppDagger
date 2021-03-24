package com.user.brayan.primerapp.di

import com.user.brayan.primerapp.iu.login.LoginActivity
import com.user.brayan.primerapp.iu.profile.ProfileActivity
import com.user.brayan.primerapp.iu.web_service.WebServiceActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(profileActivity: ProfileActivity)
    fun inject(webServiceActivity: WebServiceActivity)
}