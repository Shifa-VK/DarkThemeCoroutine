package com.example.assessmentdarktheme.ui

import android.app.UiModeManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.assessmentdarktheme.R
import com.example.assessmentdarktheme.databinding.HomeActivityBinding
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivityBinding
//    private lateinit var uiModeManager: UiModeManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//        uiModeManager = getSystemService(UI_MODE_SERVICE) as UiModeManager
//        uiModeManager.nightMode = UiModeManager.MODE_NIGHT_NO
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
        binding.themeSwitch.setOnCheckedChangeListener { compoundButton: CompoundButton, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.text = getString(R.string.select_night_theme)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.text = getString(R.string.select_day_theme)
            }
        }
}
}