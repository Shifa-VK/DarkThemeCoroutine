package com.example.assessmentdarktheme.validation

object Validator {
    fun isValidate(userName:String, password:String): Boolean {
        return (userName.equals("admin") && password.equals("admin123"))
    }
}