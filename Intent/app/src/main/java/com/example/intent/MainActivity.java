package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*CÁC BƯỚC:
            BÊN activity1
        1.Tạo đối tượng Intent
        2.Gói dữ liệu vào
        3. +startActivity
        or startActivity forResult
        4. onActivityResult
            BÊN activity2
        1. getIntent()
        2.Bóc lấy data
        3.setResult()*/
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
    public  void ChuyenManHinh(View view){
            //1.Tạo intent
        Intent iMH = new Intent(MainActivity.this, MainActivity2.class);
            //2. Gói dữ liệu
        iMH.putExtra("ten","Vo Xuan Truong");  //Láy dữ liệu màn đầu hiện ra màn 2
            //3. Swaps màn hình
        startActivity(iMH);
    }
}