package com.example.a3_11_b


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Biến để lưu trữ LinearLayout
    private lateinit var mainLayout: LinearLayout

    // Khởi tạo GestureDetector để phát hiện các cử chỉ
    private lateinit var gestureDetector: GestureDetector

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tìm LinearLayout theo ID
        mainLayout = findViewById(R.id.mainLayout)

        // Khởi tạo GestureDetector và xử lý các cử chỉ
        gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            // Phát hiện cử chỉ chạm (tap)
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                mainLayout.setBackgroundColor(Color.BLUE) // Thay đổi màu nền thành xanh
                return true
            }

            // Phát hiện cử chỉ vuốt lên (swipe up)
            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                if (e1 != null && e2 != null) {
                    val deltaY = e2.y - e1.y

                    if (deltaY < 0) {
                        // Vuốt lên
                        mainLayout.setBackgroundColor(Color.YELLOW) // Thay đổi màu nền thành vàng
                    } else if (deltaY > 0) {
                        // Vuốt xuống
                        mainLayout.setBackgroundColor(Color.RED) // Thay đổi màu nền thành đỏ
                    }
                }
                return true
            }
        })
    }

    // Override phương thức onTouchEvent để kết nối với GestureDetector
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            gestureDetector.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }
}
