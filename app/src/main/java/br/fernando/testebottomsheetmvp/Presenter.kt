package br.fernando.testebottomsheetmvp

import android.util.Log

class Presenter(val view: DataName.View?): DataName.Presenter {


    private val login = Login()

    private var isNameValid: Boolean = false
    private var canToOpen: Boolean = false

    override fun sendNameForLogin(name: String) {
        isNameValid = login.validateName(name)
        if (isNameValid){
            loginSuccess()
            canToOpen = isNameValid
        }else{
            loginError()
           canToOpen = isNameValid
        }
    }

    override fun toOpenCanSession(): Boolean = canToOpen

    fun loginSuccess(){
        view?.showMessageSuccess("Login Realizado com Sucesso")
    }

    fun loginError(){
        view?.showMessageError("Erro ao fazer Login")
    }


}