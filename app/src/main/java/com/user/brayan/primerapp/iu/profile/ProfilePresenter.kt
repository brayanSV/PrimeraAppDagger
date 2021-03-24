package com.user.brayan.primerapp.iu.profile

import com.user.brayan.primerapp.model.User

class ProfilePresenter(var user: User): Profile.Presenter {
    private lateinit var view: Profile.View

    override fun setView(view: Profile.View) {
        this.view = view
        this.view.showUser(this.user)
    }

    override fun updateUser(user: User) {
        if (this::view.isInitialized) {
            this.user.name = user.name
            this.user.yearOld = user.yearOld
        }
    }

    override fun logout() {
        user.name = ""
        user.yearOld = 0
        view.logout()
    }

}