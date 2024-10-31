package truong.vx.thigk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent; // Thêm dòng này

public class BMI_Activity extends AppCompatActivity {

    EditText heightEditText, weightEditText;
    TextView resultTextView;
    Button calculateButton, backButton; // Thêm biến cho nút trở về

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi); // Chỉ cần setContentView một lần

        heightEditText = findViewById(R.id.editTextHeight);
        weightEditText = findViewById(R.id.editTextWeight);
        resultTextView = findViewById(R.id.textViewResult);
        calculateButton = findViewById(R.id.buttonCalculate);
        backButton = findViewById(R.id.backButton); // Khởi tạo nút trở về

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() { // Xử lý sự kiện nút trở về
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại và trở về Activity trước
            }
        });
    }

    private void calculateBMI() {
        double height, weight, bmi;

        try {
            height = Double.parseDouble(heightEditText.getText().toString()) / 100; // Convert to meters
            weight = Double.parseDouble(weightEditText.getText().toString());
            bmi = weight / (height * height);

            // Phân loại BMI và cập nhật màu sắc, văn bản
            String bmiCategory;
            int color;
            if (bmi < 18.5) {
                bmiCategory = "Gầy";
                color = Color.BLUE;
            } else if (bmi >= 18.5 && bmi < 24.9) {
                bmiCategory = "Bình thường";
                color = Color.GREEN;
            } else if (bmi >= 25 && bmi < 29.9) {
                bmiCategory = "Thừa cân";
                color = Color.YELLOW;
            } else {
                bmiCategory = "Béo phì";
                color = Color.RED;
            }

            resultTextView.setText(String.format("BMI của bạn: %.2f - %s", bmi, bmiCategory));
            resultTextView.setTextColor(color); // Đổi màu dựa trên phân loại BMI

        } catch (NumberFormatException e) {
            resultTextView.setText("Nhập số hợp lệ cho chiều cao và cân nặng.");
            resultTextView.setTextColor(Color.GRAY); // Màu xám cho lỗi nhập liệu
        }
    }
}
