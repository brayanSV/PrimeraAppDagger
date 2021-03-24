package com.user.brayan.primerapp.iu.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.user.brayan.primerapp.R
import com.user.brayan.primerapp.di.BaseApp
import com.user.brayan.primerapp.iu.profile.ProfileActivity
import kotlinx.android.synthetic.main.login_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), Login.View {

    @Inject
    lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        (application as BaseApp).getAppComponent().inject(this)
        presenter.serView(this)

        btnLogin.setOnClickListener {
            val user = etUser.text.toString()
            val passw = etPassword.text.toString()

            presenter.validarUsuario(user, passw)
        }
    }

    override fun usuarioValido() {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun error() {
        Toast.makeText(this, "Usuario no valido", Toast.LENGTH_SHORT).show()
    }
}