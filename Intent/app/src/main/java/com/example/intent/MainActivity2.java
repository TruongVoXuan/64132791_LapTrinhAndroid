package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public  void ChuyenLaiMan(View view){
        //1. Lấy intent về

        Intent iNhanDuoc = getIntent();

        //2.Bốc dữ liệu

        String data = iNhanDuoc.getStringExtra("ten");

        //3.Hiển lên màn

        Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();

        //4.Chuyển về màn hình chính
        Intent iManHinhChinh = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(iManHinhChinh);
    }
}