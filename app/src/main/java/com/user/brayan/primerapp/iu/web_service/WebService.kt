package com.user.brayan.primerapp.iu.web_service

import com.user.brayan.primerapp.model.User

interface WebService {
    interface View {
        fun showUser(user: User)
    }

    interface Presenter {
        fun setView(view: View)
        fun solicitudWebService()
    }
}