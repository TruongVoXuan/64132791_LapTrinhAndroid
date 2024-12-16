package truong.vx.th_bai7_quizappgui2assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_body);

        // Ánh xạ các Button
        Button answerA = findViewById(R.id.btnAnswerA);
        Button answerB = findViewById(R.id.btnAnswerB);
        Button answerC = findViewById(R.id.btnAnswerC);
        Button answerD = findViewById(R.id.btnAnswerD);

        // Câu trả lời đúng
        String correctAnswer = "Option B";

        // Tạo Listener chung cho các Button
        View.OnClickListener listener = view -> {
            Button selectedButton = (Button) view;

            // Kiểm tra đáp án
            if (selectedButton.getText().toString().equals(correctAnswer)) {
                selectedButton.setBackgroundColor(Color.GREEN); // Đúng thì màu xanh
            } else {
                selectedButton.setBackgroundColor(Color.RED); // Sai thì màu đỏ

                // Đổi màu đáp án đúng
                if (answerA.getText().toString().equals(correctAnswer)) {
                    answerA.setBackgroundColor(Color.GREEN);
                } else if (answerB.getText().toString().equals(correctAnswer)) {
                    answerB.setBackgroundColor(Color.GREEN);
                } else if (answerC.getText().toString().equals(correctAnswer)) {
                    answerC.setBackgroundColor(Color.GREEN);
                } else if (answerD.getText().toString().equals(correctAnswer)) {
                    answerD.setBackgroundColor(Color.GREEN);
                }
            }

            // Vô hiệu hóa các Button sau khi chọn
            answerA.setEnabled(false);
            answerB.setEnabled(false);
            answerC.setEnabled(false);
            answerD.setEnabled(false);
        };

        // Gắn sự kiện click cho các Button
        answerA.setOnClickListener(listener);
        answerB.setOnClickListener(listener);
        answerC.setOnClickListener(listener);
        answerD.setOnClickListener(listener);
    }
}
