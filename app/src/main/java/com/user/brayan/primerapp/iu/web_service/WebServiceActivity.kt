package com.user.brayan.primerapp.iu.web_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.brayan.primerapp.R
import com.user.brayan.primerapp.di.BaseApp
import com.user.brayan.primerapp.iu.profile.ProfileActivity
import com.user.brayan.primerapp.model.User
import kotlinx.android.synthetic.main.activity_web_service.*
import javax.inject.Inject

class WebServiceActivity : AppCompatActivity(), WebService.View {
    @Inject
    lateinit var presenter: WebService.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        (application as BaseApp).getAppComponent().inject(this)
        presenter.setView(this)

        btnHacerPeticionWeb.setOnClickListener {
            presenter.solicitudWebService()
        }

        btnVolverAProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun showUser(user: User) {
        tvUserName.setText("${user.name}")
        tvEdad.setText("${user.yearOld}")
    }
}