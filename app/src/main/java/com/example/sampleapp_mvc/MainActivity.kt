package com.example.sampleapp_mvc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp_mvc.data.MainModel
import com.example.sampleapp_mvc.data.api.UserApi
import com.example.sampleapp_mvc.data.model.User
import com.example.sampleapp_mvc.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainModel
    private val userAdapter = UserAdapter()

    private val job = Job()
    override val coroutineContext: CoroutineContext = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = MainModel(UserApi.retrofitService)

        initLayout()
    }

    private fun initLayout() {
        binding.btnUpdateData.setOnClickListener {
            launch(Dispatchers.Main) {
                hideUpdateButton()
                showProgressBar()
                try {
                    val users = withContext(Dispatchers.IO) {
                        model.getUsers()
                    }
                    if (users.isNotEmpty()) {
                        hideProgressBar()
                        updateUserList(users)
                    }
                } catch (e: Exception) {
                    hideProgressBar()
                    showErrorMessage()
                }
            }
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun hideUpdateButton() {
        binding.btnUpdateData.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun updateUserList(users: List<User>) {
        binding.recyclerView.visibility = View.VISIBLE
        userAdapter.diffUtil.submitList(users)
    }

    private fun showErrorMessage() {
        binding.errorMessage.apply {
            text = resources.getString(R.string.network_error_msg)
            visibility = View.VISIBLE
        }
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
    }
}