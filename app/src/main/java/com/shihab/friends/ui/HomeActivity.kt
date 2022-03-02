package com.shihab.friends.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.shihab.friends.R
import com.shihab.friends.databinding.ActivityMainBinding
import com.shihab.friends.model.User
import com.shihab.friends.utils.NetworkResult
import com.shihab.friends.utils.onItemClickListener
import com.shihab.friends.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), onItemClickListener {

    val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = UserAdapter(this)
        binding.recyclerUser.adapter = adapter

        viewModel.userList.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        adapter.addAllUser(it.results!!)
                    }
                    binding.progressBar.visibility = View.GONE
                }

                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkResult.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        this,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            viewModel.getUserListWithFlow()
        }
    }

    override fun onClicked(user: User) {
        val intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }
}