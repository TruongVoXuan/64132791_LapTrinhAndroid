package vn.voxuantruong64132791_thigiuaki;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list); // Sử dụng layout phù hợp

        // Nhận dữ liệu từ Intent
        String content = getIntent().getStringExtra("content");

        // Hiển thị dữ liệu trong TextView
        TextView contentTextView = findViewById(R.id.contentTextView);
        if (content != null) {
            contentTextView.setText(content);
        } else {
            contentTextView.setText("Nội dung không có!"); // Thêm giá trị mặc định
        }

        // Thiết lập sự kiện nhấn cho nút quay lại
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại và trở về List_Activity
            }
        });
    }
}