package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditSongActivity extends AppCompatActivity {
    private EditText edtSongName, edtAuthorName, edtImageUrl;
    private Button btnSave;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        edtSongName = findViewById(R.id.edtSongName);
        edtAuthorName = findViewById(R.id.edtAuthorName);
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String imageUrl = intent.getStringExtra("imageUrl");

        edtSongName.setText(name);
        edtAuthorName.setText(author);
        edtImageUrl.setText(imageUrl);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("position", position);
                resultIntent.putExtra("name", edtSongName.getText().toString());
                resultIntent.putExtra("author", edtAuthorName.getText().toString());
                resultIntent.putExtra("imageUrl", edtImageUrl.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}

