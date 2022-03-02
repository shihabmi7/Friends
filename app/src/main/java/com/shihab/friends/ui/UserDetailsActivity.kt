package com.shihab.friends.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.load
import coil.transform.CircleCropTransformation
import com.shihab.friends.R
import com.shihab.friends.databinding.ActivityUserDetailsBinding
import com.shihab.friends.model.User


class UserDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val user = intent.getParcelableExtra<User>("user")
        binding.user = user

        binding.image.load(user?.picture?.medium) {
            transformations(CircleCropTransformation())
        }

        binding.txtEmail.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_EMAIL)
                this.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this,
                    "There is no email client installed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}