package com.user.brayan.primerapp.iu.login

interface Login {
    interface View {
        fun usuarioValido()
        fun error()
    }

    interface Presenter {
        fun serView(view: View)
        fun validarUsuario(user: String, passw: String)
    }
}