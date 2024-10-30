package com.example.recycleview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int EDIT_SONG_REQUEST = 1;
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;
    private EditText edtSongName, edtAuthorName;
    private Button btnAdd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        edtSongName = findViewById(R.id.edtSongName);
        edtAuthorName = findViewById(R.id.edtAuthorName);
        btnAdd = findViewById(R.id.btnAdd);

        // Khởi tạo danh sách bài hát mẫu
        songList = new ArrayList<>();
        songList.add(new Song("Song 1", "Author 1", R.drawable.image1));
        songList.add(new Song("Song 2", "Author 2", R.drawable.image2));
        songList.add(new Song("Song 3", "Author 3", R.drawable.image3));

        songAdapter = new SongAdapter(this, songList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songAdapter);

        // Phần còn lại của code trong onCreate không đổi
        songAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Xử lý khi click vào bài hát
                Song song = songList.get(position);
                Intent intent = new Intent(MainActivity.this, EditSongActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("name", song.getName());
                intent.putExtra("author", song.getAuthor());
                intent.putExtra("imageResId", song.getImageResId());
                startActivityForResult(intent, EDIT_SONG_REQUEST);
            }

            @Override
            public void onDeleteClick(int position) {
                // Xử lý khi click nút xóa
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete Song");
                builder.setMessage("Are you sure you want to delete this song?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    songAdapter.removeItem(position);
                    Toast.makeText(MainActivity.this, "Song deleted", Toast.LENGTH_SHORT).show();
                });
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                String name = edtSongName.getText().toString().trim();
                String author = edtAuthorName.getText().toString().trim();

                // Validate input
                if (name.isEmpty() || author.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add new song with a default image from resources
                int defaultImageResId = R.drawable.default_image; // Use a drawable resource as default image
                songList.add(new Song(name, author, defaultImageResId));
                songAdapter.notifyDataSetChanged();

                // Clear input fields
                edtSongName.setText("");
                edtAuthorName.setText("");

                Toast.makeText(MainActivity.this, "Song added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Phần còn lại của MainActivity không đổi
}
