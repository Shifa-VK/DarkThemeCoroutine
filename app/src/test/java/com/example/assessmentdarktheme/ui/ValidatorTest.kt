package com.example.assessmentdarktheme.ui

import com.example.assessmentdarktheme.validation.Validator
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun validateTest(){
        val userName = "admin"
        val password = "admin123"
        val result = Validator.isValidate(userName, password)
        assertThat(result)
    }
}