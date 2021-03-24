package com.user.brayan.primerapp.iu.profile

import com.user.brayan.primerapp.model.User

interface Profile {
    interface View {
        fun showUser(user: User)
        fun logout()
    }

    interface Presenter {
        fun setView(view: View)
        fun updateUser(user: User)
        fun logout()
    }
}