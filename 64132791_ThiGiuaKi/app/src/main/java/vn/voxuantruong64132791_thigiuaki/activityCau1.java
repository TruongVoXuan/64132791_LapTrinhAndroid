package vn.voxuantruong64132791_thigiuaki;



import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activityCau1 extends AppCompatActivity {

    EditText firstNumberEditText, secondNumberEditText;
    TextView resultTextView;
    Button calculateButton, backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1); // Set layout for basic calculator

        firstNumberEditText = findViewById(R.id.editTextFirstNumber);
        secondNumberEditText = findViewById(R.id.editTextSecondNumber);
        resultTextView = findViewById(R.id.textViewResult);
        calculateButton = findViewById(R.id.buttonCalculate);
        backButton = findViewById(R.id.backButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateSum() {
        double firstNumber, secondNumber, sum;

        try {
            firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
            secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
            sum = firstNumber + secondNumber;

            resultTextView.setText(String.format("Sum: %.2f", sum));
            resultTextView.setTextColor(Color.GREEN); // Display result in green for clarity

        } catch (NumberFormatException e) {
            resultTextView.setText("Enter valid numbers.");
            resultTextView.setTextColor(Color.RED); // Error message in red
        }
    }
}
