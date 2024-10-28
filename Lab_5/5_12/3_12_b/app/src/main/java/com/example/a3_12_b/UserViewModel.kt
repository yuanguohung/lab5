package com.example.a3_12_b

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                val userList = ApiClient.apiService.getUsers() // Lấy danh sách người dùng từ API
                _users.value = userList // Gán danh sách người dùng vào LiveData
            } catch (e: Exception) {
                e.printStackTrace() // In ra log để kiểm tra lỗi
                _users.value = emptyList() // Gán danh sách rỗng nếu có lỗi
            }
        }
    }
}
