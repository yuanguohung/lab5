package com.example.a3_11_a

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tìm các view bằng ID
        val emailField = findViewById<EditText>(R.id.emailField)
        val phoneField = findViewById<EditText>(R.id.phoneField)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Thiết lập sự kiện click cho nút Submit
        submitButton.setOnClickListener {
            val email = emailField.text.toString()
            val phone = phoneField.text.toString()

            // Kiểm tra tính hợp lệ của email
            val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

            // Kiểm tra tính hợp lệ của số điện thoại (chỉ chứa ký tự số)
            val isPhoneValid = phone.matches("\\d+".toRegex())

            // Hiển thị kết quả kiểm tra
            if (isEmailValid && isPhoneValid) {
                resultText.text = "Email và số điện thoại hợp lệ!"
            } else {
                if (!isEmailValid) {
                    resultText.text = "Email không hợp lệ!"
                }
                if (!isPhoneValid) {
                    resultText.text = "Số điện thoại không hợp lệ!"
                }
            }
        }
    }
}