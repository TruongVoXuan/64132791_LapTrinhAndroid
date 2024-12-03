package truong.vx.th_bai2_basicgui_bmiassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText heightEditText, weightEditText;
    TextView resultTextView;
    Button calculateButton;
    RadioGroup radioGroupStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.editTextHeight);
        weightEditText = findViewById(R.id.editTextWeight);
        resultTextView = findViewById(R.id.textViewResult);
        calculateButton = findViewById(R.id.buttonCalculate);
        radioGroupStandard = findViewById(R.id.radioGroupStandard);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        double height, weight, bmi;

        try {
            height = Double.parseDouble(heightEditText.getText().toString()) / 100;
            weight = Double.parseDouble(weightEditText.getText().toString());
            bmi = weight / (height * height);


            String bmiCategory;



            int selectedID = radioGroupStandard.getCheckedRadioButtonId();

            if(selectedID == R.id.radioWHO)
            {
                if (bmi < 18.5) {
                    bmiCategory = "Gầy";

                } else if (bmi >= 18.5 && bmi < 24.9) {
                    bmiCategory = "Bình thường";

                } else if (bmi >= 25 && bmi < 29.9) {
                    bmiCategory = "Thừa cân";

                } else {
                    bmiCategory = "Béo phì";

                }
            }
            else if (selectedID == R.id.radioASIA)
            {
                if (bmi < 17.5) {
                    bmiCategory = "Gầy";

                } else if (bmi >= 17.5 && bmi < 22.9) {
                    bmiCategory = "Bình thường";

                } else if (bmi >= 23 && bmi < 27.9) {
                    bmiCategory = "Thừa cân";

                } else {
                    bmiCategory = "Béo phì";

                }
            }
            else {
                bmiCategory = "hãy chọn tiêu chuẩn";
            }




            resultTextView.setText(String.format("BMI của bạn: %.2f - %s", bmi, bmiCategory));


        } catch (NumberFormatException e) {
            resultTextView.setText("Nhập số hợp lệ cho chiều cao và cân nặng.");
            resultTextView.setTextColor(Color.GRAY); // Màu xám cho lỗi nhập liệu
        }
    }
}