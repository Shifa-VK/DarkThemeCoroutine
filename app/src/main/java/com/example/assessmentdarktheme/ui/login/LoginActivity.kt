package com.example.assessmentdarktheme.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assessmentdarktheme.R
import com.example.assessmentdarktheme.databinding.ActivityLoginBinding
import com.example.assessmentdarktheme.ui.home.HomeActivity
import com.example.assessmentdarktheme.validation.Validator

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.LoginBtn.setOnClickListener{
            val isValidated = Validator.isValidate(binding.userNameTV.text.toString(), binding.passwordTV.text.toString())
            if(isValidated){
                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)
            }
            else{
                Toast.makeText(this, getString(R.string.enter_valid_credentials), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /* fun validateCredentials(userName:String, password:String): Boolean {
        if(userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Username and password shouldn't be empty", Toast.LENGTH_SHORT).show()
            return false
        }
        else if(!userName.equals("admin") || !password.equals("admin123")){
            Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }*/
}