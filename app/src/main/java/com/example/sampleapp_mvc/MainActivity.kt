package com.example.sampleapp_mvc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp_mvc.data.MainModel
import com.example.sampleapp_mvc.data.api.UserApi
import com.example.sampleapp_mvc.data.model.Users
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var model: MainModel

    private lateinit var updateButton: Button
    private lateinit var recyclerView: RecyclerView
    private val userAdapter = UserAdapter(arrayListOf())
    private lateinit var errorMsgTextView: TextView
    private lateinit var progressBar: ProgressBar

    private val job = Job()
    override val coroutineContext: CoroutineContext = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = MainModel(UserApi.retrofitService)

        initLayout()
    }

    private fun initLayout() {
        updateButton = findViewById(R.id.btn_update_data)
        recyclerView = findViewById(R.id.recyclerView)
        errorMsgTextView = findViewById(R.id.error_message)
        progressBar = findViewById(R.id.progressBar)

        updateButton.setOnClickListener {
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

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun hideUpdateButton() {
        updateButton.visibility = View.GONE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun updateUserList(users: Users) {
        recyclerView.visibility = View.VISIBLE
        userAdapter.addData(users)
    }

    private fun showErrorMessage() {
        errorMsgTextView.apply {
            text = resources.getString(R.string.network_error_msg)
            visibility = View.VISIBLE
        }
    }

}