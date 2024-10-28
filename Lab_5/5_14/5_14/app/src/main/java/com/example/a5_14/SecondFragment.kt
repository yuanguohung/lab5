package com.example.a5_14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Nhận dữ liệu giỏ hàng từ Bundle
        val cartItems = arguments?.getStringArray("cartItems") ?: emptyArray()

        // Thiết lập RecyclerView để hiển thị giỏ hàng
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Tạo adapter cho RecyclerView với danh sách sản phẩm trong giỏ hàng
        recyclerView.adapter = ProductAdapter(cartItems.toList(), null) // Thay null bằng hành động khi nhấp vào nếu cần
    }
}
