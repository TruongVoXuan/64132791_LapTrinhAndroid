package truong.vx.thigk;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class List_Activity extends AppCompatActivity {
    ArrayList<String> list;
    ArrayAdapter<String> myAdapter;
    ListView lv;
    Button btnThem;
    Button backButton; // Declare backButton here
    EditText edtThem;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = new ArrayList<>();
        list.add("Hỏi Thăm Nhau");
        list.add("Lá Xa Lìa Cành");
        list.add("Trách Ai Vô Tình");
        list.add("Hỏi Vợ Ngoại Thành");
        list.add("Nắng Ấm Xa Dần");
        list.add("Lạc Trôi");

        lv = findViewById(R.id.lv);
        btnThem = findViewById(R.id.btnThem);
        backButton = findViewById(R.id.backButton); // Initialize backButton
        edtThem = findViewById(R.id.edtThem);
        myAdapter = new ArrayAdapter<>(List_Activity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(myAdapter);
        backButton.setOnClickListener(new View.OnClickListener() { // Xử lý sự kiện nút trở về
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại và trở về Activity trước
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBaiHat = edtThem.getText().toString();
                if (!tenBaiHat.isEmpty()) { // Check if input is not empty
                    list.add(tenBaiHat);
                    myAdapter.notifyDataSetChanged();
                    edtThem.setText(""); // Clear the input field after adding
                } else {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập tên bài hát", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
