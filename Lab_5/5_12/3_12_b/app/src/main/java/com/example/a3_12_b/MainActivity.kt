package com.example.a3_12_b

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var userViewModel: UserViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Lắng nghe sự thay đổi của danh sách người dùng
        userViewModel.users.observe(this, Observer { users ->
            userAdapter = UserAdapter(users)
            recyclerView.adapter = userAdapter
        })
    }
}
