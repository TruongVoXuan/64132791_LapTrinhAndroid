package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các điều khiển
    Button bCong,bTru,bNhan,bChia;
    EditText editTextA, editTextB;
    TextView textViewKetQua;
    //2.Hàm tìm các điều khiển, cất vào biến ở trên
    void getControls(){
        bCong = findViewById(R.id.btnCong);
        bTru = findViewById(R.id.btnTru);
        bNhan = findViewById(R.id.btnNhan);
        bChia = findViewById(R.id.btnChia);
        editTextA = findViewById(R.id.editTextNumber);
        editTextB = findViewById(R.id.editTextNumber1);
        textViewKetQua = findViewById(R.id.tvKQ);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControls();

        //B2.Gán bộ lắng nghe vào nút trừ
        bTru.setOnClickListener(langNgheTru);
    }
//CÁCH 2 LÀ TẠO ONE_CLICK (GỒM 2 BƯỚC)
    //B1. Tạo bộ lắng nghe và đáp ứng lại sự kiện Use click lên nút trừ
    View.OnClickListener langNgheTru = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a=  Double.parseDouble(editTextA.getText().toString())  ;
        double b=  Double.parseDouble(editTextB.getText().toString())  ;
        double KQ=  a-b ;
    textViewKetQua.setText(String.valueOf(KQ));
        }
    };

    public  void XuLy_Cong(View v){
    double a=  Double.parseDouble(editTextA.getText().toString())  ;
        double b=  Double.parseDouble(editTextB.getText().toString())  ;
        double KQ=  a+b ;
        textViewKetQua.setText(String.valueOf(KQ));
    }

//    public  void XuLy_Tru(View v){
//        double a=  Double.parseDouble(editTextA.getText().toString())  ;
//        double b=  Double.parseDouble(editTextB.getText().toString())  ;
//        double KQ=  a-b ;
//        textViewKetQua.setText(String.valueOf(KQ));
//    }

    public  void XuLy_Nhan(View v){
        double a=  Double.parseDouble(editTextA.getText().toString())  ;
        double b=  Double.parseDouble(editTextB.getText().toString())  ;
        double KQ=  a*b ;
        textViewKetQua.setText(String.valueOf(KQ));
    }

    public  void XuLy_Chia(View v){
        double a=  Double.parseDouble(editTextA.getText().toString())  ;
        double b=  Double.parseDouble(editTextB.getText().toString())  ;
        double KQ=  a/b ;
        textViewKetQua.setText(String.valueOf(KQ));

    }
//
//    public void SayHello(View v) {
//        EditText soThuNhat = findViewById(R.id.edtNum1);
//        EditText soThuHai = findViewById(R.id.edtNum2);
//        //Lấy dữ liệu bằng getter
//        String s1 = soThuNhat.getText().toString();
//        String s2 = soThuHai.getText().toString();
//        //Chuyển kiểu
//        double num1 = Integer.parseInt(s1);
//        double num2 = Integer.parseInt(s2);
//        //Tính toán
//        double tong = num1+ num2;
//        //Xuất chuyển từ int sang string
//        String chuoiXuat = "Tổng là:" + String.valueOf(tong);
//        Toast.makeText(this, chuoiXuat, Toast.LENGTH_SHORT).show();
//    }

}