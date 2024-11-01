package vn.voxuantruong64132791_thigiuaki;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activityCau2 extends AppCompatActivity {
    ArrayList<String> list;
    ArrayAdapter<String> myAdapter;
    ListView lv;
    Button btnThem;
    Button backButton;
    EditText edtThem;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);

        // Khởi tạo danh sách
        list = new ArrayList<>();
        list.add("Hỏi Thăm Nhau");
        list.add("Lá Xa Lìa Cành");
        list.add("Trách Ai Vô Tình");

        // Lấy các view từ layout
        lv = findViewById(R.id.lv);
        btnThem = findViewById(R.id.btnThem);
        backButton = findViewById(R.id.backButton);
        edtThem = findViewById(R.id.edtThem);

        // Adapter tùy chỉnh để thay đổi màu chữ
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setTextColor(Color.parseColor("#FFA500")); // Màu cam
                return item;
            }
        };

        // Thiết lập adapter cho ListView
        lv.setAdapter(myAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBaiHat = edtThem.getText().toString();
                if (!tenBaiHat.isEmpty()) {
                    list.add(tenBaiHat);
                    myAdapter.notifyDataSetChanged();
                    edtThem.setText(""); // Xóa nội dung EditText
                } else {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập tên bài hát", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSong = list.get(i);
                Log.d("SelectedSong", selectedSong); // Thêm log để kiểm tra
                openItemActivity(selectedSong);
            }
        });

    }

    private void openItemActivity(String content) {
        Intent intent = new Intent(this, ItemActivityList.class);
        intent.putExtra("content", content);
        startActivity(intent);
    }
}
