package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void SayHello(View v) {
        EditText soThuNhat = findViewById(R.id.edtNum1);
        EditText soThuHai = findViewById(R.id.edtNum2);
        //Lấy dữ liệu bằng getter
        String s1 = soThuNhat.getText().toString();
        String s2 = soThuHai.getText().toString();
        //Chuyển kiểu
        double num1 = Integer.parseInt(s1);
        double num2 = Integer.parseInt(s2);
        //Tính toán
        double tong = num1+ num2;
        //Xuất chuyển từ int sang string
        String chuoiXuat = "Tổng là:" + String.valueOf(tong);
        Toast.makeText(this, chuoiXuat, Toast.LENGTH_SHORT).show();
    }

}