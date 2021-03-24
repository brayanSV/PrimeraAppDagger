package com.user.brayan.primerapp.iu.login

import com.user.brayan.primerapp.model.User

class LoginPresenter(var user: User): Login.Presenter {
    private lateinit var view: Login.View

    override fun serView(view: Login.View) {
        this.view = view
    }

    override fun validarUsuario(user: String, passw: String) {
        if (this::view.isInitialized) {
            if (user == "Brayan" && passw == "1234") {
                this.user.name = "Brayan Villarraga"
                this.user.yearOld = 24

                view.usuarioValido()
            } else {
                view.error()
            }
        }
    }
}