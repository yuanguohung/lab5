package com.example.a3_12_b


import retrofit2.http.GET

interface ApiService {
    @GET("users") // Đường dẫn từ BASE_URL
    suspend fun getUsers(): List<User> // Phương thức gọi API để lấy danh sách người dùng
}
