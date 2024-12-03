package truong.vx.th_bai1_basicgui_simplemathassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText numA, numB;
    private TextView resultTextView;
    private RadioGroup operationGroup;

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

        numA = findViewById(R.id.numA);
        numB = findViewById(R.id.numB);
        operationGroup = findViewById(R.id.operationGroup);
        Button buttonCalculate = findViewById(R.id.calculateBtn);
        resultTextView = findViewById(R.id.resultTextView);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aStr = numA.getText().toString();
                String bStr = numB.getText().toString();
                Double a = aStr.isEmpty() ? null : Double.parseDouble(aStr);
                Double b = bStr.isEmpty() ? null : Double.parseDouble(bStr);

                if (a != null && b != null) {
                    int selectedId = operationGroup.getCheckedRadioButtonId();
                    String result;

                    if (selectedId == R.id.addRadio) {
                        result = String.valueOf(a + b);
                    } else if (selectedId == R.id.subtractRadio) {
                        result = String.valueOf(a - b);
                    } else if (selectedId == R.id.multiplyRadio) {
                        result = String.valueOf(a * b);
                    } else if (selectedId == R.id.divideRadio) {
                        if (b != 0) {
                            result = String.valueOf(a / b);
                        } else {
                            result = "Không thể chia cho 0";
                        }
                    } else {
                        result = "Phép toán không hợp lệ";
                    }
                    resultTextView.setText(result);
                } else {
                    resultTextView.setText("Vui lòng nhập số hợp lệ");
                }
            }
        });
    }
}