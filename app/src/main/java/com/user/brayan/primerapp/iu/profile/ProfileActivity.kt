package com.user.brayan.primerapp.iu.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.brayan.primerapp.R
import com.user.brayan.primerapp.di.BaseApp
import com.user.brayan.primerapp.iu.login.LoginActivity
import com.user.brayan.primerapp.iu.web_service.WebServiceActivity
import com.user.brayan.primerapp.model.User
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class ProfileActivity : AppCompatActivity(), Profile.View {
    @Inject
    lateinit var presenter: Profile.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        (application as BaseApp).getAppComponent().inject(this)
        presenter.setView(this)

        tvLogout.setOnClickListener {
            presenter.logout()
        }

        btnUpdate.setOnClickListener {
            val name = etName.text.toString()
            val yearsOld = Integer.parseInt(etEdad.text.toString())
            presenter.updateUser(User(name, yearsOld))
        }

        btnNextActivity.setOnClickListener {
            val intent = Intent(this, WebServiceActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun showUser(user: User) {
        etName.setText("${user.name}")
        etEdad.setText("${user.yearOld}")
    }

    override fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}