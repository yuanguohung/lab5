package com.example.a3_12_a


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách các URL hình ảnh
        val imageUrls = listOf(
            "https://via.placeholder.com/600/92c952",
            "https://via.placeholder.com/600/771796",
            "https://via.placeholder.com/600/24f355",
            "https://via.placeholder.com/600/d32776",
            "https://via.placeholder.com/600/f66b97"
            // Thêm nhiều URL khác
        )

        // Tìm RecyclerView và cài đặt
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
