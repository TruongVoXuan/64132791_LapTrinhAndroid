package com.example.appbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;

import org.w3c.dom.Text;

public class AppBMI extends AppCompatActivity {
    Button btnCalculate;
    EditText editText1, editText2;
    double Cannang,Chieucao;
    double BMI;
    double fixChieucao;
    String textBMI;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            btnCalculate = findViewById(R.id.btnCalculate);
            editText1 = findViewById(R.id.editTextNumber);
            editText2 = findViewById(R.id.editTextNumber1);
            result = findViewById(R.id.tvResult);

            Cannang = Double.parseDouble(String.valueOf(editText1.getText()));
            Chieucao = Double.parseDouble(String.valueOf(editText2.getText()));
            return insets;
        });
    }

    public void calculateBMI(View view) {
        TinhToan(Cannang,Chieucao);
    }

    public void TinhToan (double Cannang , double Chieucao){
        fixChieucao = Chieucao / 100;

        BMI = Cannang/ (fixChieucao * fixChieucao);

        textBMI = "BMI cua ban la : " + BMI;
        result.setText(textBMI);

    }
}