package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.myClasses.User

class MainActivity : AppCompatActivity() {

    // binding object
    private lateinit var binding: ActivityMainBinding

    // the user
    private var user: User = User("ahmed", 33)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hold elements
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.theUser = user

        binding.doneButton.setOnClickListener {
            createAboutMe()
            Toast.makeText(this, "changed successfully", Toast.LENGTH_SHORT).show()
        }

    }

    private fun createAboutMe() {
        binding.apply {
            nickname.text = nameField.text
            theUser?.name = nameField.text.toString()
            theUser?.age = Integer.parseInt(ageField.text.toString())
            invalidateAll() // refresh the UI
            nickname.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            content.text = content.text.toString().replace("THENAME", theUser!!.name ?: "defaultName")
            content.text = content.text.toString().replace("THEAGE", theUser!!.age.toString() ?: "0")
        }

    }
}


















