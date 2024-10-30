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

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int EDIT_SONG_REQUEST = 1;
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;
    private EditText edtSongName, edtAuthorName, edtImageUrl;
    private Button btnAdd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        edtSongName = findViewById(R.id.edtSongName);
        edtAuthorName = findViewById(R.id.edtAuthorName);
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnAdd = findViewById(R.id.btnAdd);

        songList = new ArrayList<>();
        songAdapter = new SongAdapter(this, songList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songAdapter);

        songAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Song song = songList.get(position);
                Intent intent = new Intent(MainActivity.this, EditSongActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("name", song.getName());
                intent.putExtra("author", song.getAuthor());
                intent.putExtra("imageUrl", song.getImageUrl());
                startActivityForResult(intent, EDIT_SONG_REQUEST);
            }

            @Override
            public void onDeleteClick(int position) {
                // Show confirmation dialog before deleting
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
                String imageUrl = edtImageUrl.getText().toString().trim();

                // Validate input
                if (name.isEmpty() || author.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add new song
                songList.add(new Song(name, author, imageUrl));
                songAdapter.notifyDataSetChanged();

                // Clear input fields
                edtSongName.setText("");
                edtAuthorName.setText("");
                edtImageUrl.setText("");

                Toast.makeText(MainActivity.this, "Song added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_SONG_REQUEST && resultCode == RESULT_OK && data != null) {
            int position = data.getIntExtra("position", -1);
            if (position != -1) {
                String name = data.getStringExtra("name");
                String author = data.getStringExtra("author");
                String imageUrl = data.getStringExtra("imageUrl");

                Song song = songList.get(position);
                song.setName(name);
                song.setAuthor(author);
                song.setImageUrl(imageUrl);
                songAdapter.notifyItemChanged(position);
                Toast.makeText(this, "Song updated successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
