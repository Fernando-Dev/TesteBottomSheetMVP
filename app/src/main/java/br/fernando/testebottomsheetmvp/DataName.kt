package br.fernando.testebottomsheetmvp

interface DataName {

    interface View{
        fun checkName(name: String): String

        fun showMessageSuccess(message: String)

        fun showMessageError(message: String)
    }

    interface Presenter{
        fun sendNameForLogin(name: String)

        fun toOpenCanSession(): Boolean
    }
}