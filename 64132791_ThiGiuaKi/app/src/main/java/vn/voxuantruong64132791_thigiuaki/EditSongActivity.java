package vn.voxuantruong64132791_thigiuaki;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditSongActivity extends AppCompatActivity {
    private EditText edtSongName, edtAuthorName, edtImageUrl;
    private Button btnSave;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        // Initialize views
        edtSongName = findViewById(R.id.edtSongName);
        edtAuthorName = findViewById(R.id.edtAuthorName);
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnSave = findViewById(R.id.btnSave);

        // Get data from intent
        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        String imageUrl = intent.getStringExtra("imageUrl");

        // Set data to views
        edtSongName.setText(name);
        edtAuthorName.setText(author);
        edtImageUrl.setText(imageUrl);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edtSongName.getText().toString().trim();
                String newAuthor = edtAuthorName.getText().toString().trim();
                String newImageUrl = edtImageUrl.getText().toString().trim();

                if (newName.isEmpty() || newAuthor.isEmpty()) {
                    Toast.makeText(EditSongActivity.this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create intent to send back the results
                Intent resultIntent = new Intent();
                resultIntent.putExtra("position", position);
                resultIntent.putExtra("name", newName);
                resultIntent.putExtra("author", newAuthor);
                resultIntent.putExtra("imageUrl", newImageUrl);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}