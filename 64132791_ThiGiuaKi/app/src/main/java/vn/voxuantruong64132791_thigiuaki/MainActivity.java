package vn.voxuantruong64132791_thigiuaki;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculator, buttonProfile, buttonList, buttonRecycleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculator = findViewById(R.id.buttonCalculator);
        buttonProfile = findViewById(R.id.buttonProfile);
        buttonList = findViewById(R.id.buttonList);
        buttonRecycleList = findViewById(R.id.buttonRecycleList);

        // Điều hướng đúng activity
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activityCau1.class)); // Máy tính
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activityCau2.class)); // List
            }
        });

        buttonRecycleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activityCau3.class)); // Recycler List
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activityCau4.class)); // Hồ sơ cá nhân
            }
        });
    }
}
