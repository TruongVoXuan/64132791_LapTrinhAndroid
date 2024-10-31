package truong.vx.thigk;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonBMIApp, buttonProfile, buttonList, buttonRecycleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBMIApp = findViewById(R.id.buttonBMIApp);
        buttonProfile = findViewById(R.id.buttonProfile);
        buttonList = findViewById(R.id.buttonList);
        buttonRecycleList = findViewById(R.id.buttonRecycleList);

        buttonBMIApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Activity BMIApp
                startActivity(new Intent(MainActivity.this, BMI_Activity.class));
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Activity Profile
                startActivity(new Intent(MainActivity.this, Profile_Activity.class));
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Activity List
                startActivity(new Intent(MainActivity.this, List_Activity.class));
            }
        });
        buttonRecycleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Activity RecycleList
                startActivity(new Intent(MainActivity.this, RecycleList_Activity.class));
            }
        });
    }

    }

