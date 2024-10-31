package truong.vx.thigk;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class RecycleList_Activity extends AppCompatActivity {
    private static final int EDIT_SONG_REQUEST = 1; // Mã yêu cầu để chỉnh sửa bài hát
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<Song> songList;
    private EditText edtSongName, edtAuthorName;
    private Button btnAdd, backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainrecycle);

        // Khởi tạo các view
        recyclerView = findViewById(R.id.recyclerView);
        edtSongName = findViewById(R.id.edtSongName);
        edtAuthorName = findViewById(R.id.edtAuthorName);
        btnAdd = findViewById(R.id.btnAdd);
        backButton = findViewById(R.id.backButton); // Khởi tạo nút trở về

        // Khởi tạo danh sách bài hát mẫu
        songList = new ArrayList<>();
        songList.add(new Song("Song 1", "Author 1", R.drawable.image1));
        songList.add(new Song("Song 2", "Author 2", R.drawable.image2));
        songList.add(new Song("Song 3", "Author 3", R.drawable.image3));

        // Thiết lập Adapter và LayoutManager cho RecyclerView
        songAdapter = new SongAdapter(this, songList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songAdapter);

        // Xử lý sự kiện cho nút trở về
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại và trở về Activity trước
            }
        });

        // Xử lý sự kiện khi nhấn vào một bài hát trong danh sách
        songAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Xử lý khi click vào bài hát
                Song song = songList.get(position);
                Intent intent = new Intent(RecycleList_Activity.this, EditSongActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("name", song.getName());
                intent.putExtra("author", song.getAuthor());
                intent.putExtra("imageResId", song.getImageResId());
                startActivityForResult(intent, EDIT_SONG_REQUEST);
            }

            @Override
            public void onDeleteClick(int position) {
                // Xử lý khi click nút xóa
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(RecycleList_Activity.this);
                builder.setTitle("Delete Song");
                builder.setMessage("Are you sure you want to delete this song?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    songAdapter.removeItem(position);
                    Toast.makeText(RecycleList_Activity.this, "Song deleted", Toast.LENGTH_SHORT).show();
                });
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        });

        // Xử lý sự kiện cho nút thêm bài hát
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtSongName.getText().toString().trim();
                String author = edtAuthorName.getText().toString().trim();

                // Kiểm tra đầu vào
                if (name.isEmpty() || author.isEmpty()) {
                    Toast.makeText(RecycleList_Activity.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Thêm bài hát mới với một hình ảnh mặc định từ tài nguyên
                int defaultImageResId = R.drawable.default_image; // Sử dụng tài nguyên drawable làm hình ảnh mặc định
                songList.add(new Song(name, author, defaultImageResId));
                songAdapter.notifyDataSetChanged(); // Cập nhật RecyclerView

                // Xóa nội dung của các EditText
                edtSongName.setText("");
                edtAuthorName.setText("");

                Toast.makeText(RecycleList_Activity.this, "Song added successfully", Toast.LENGTH_SHORT).show();
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
                int imageResId = data.getIntExtra("imageResId", -1);

                // Cập nhật thông tin bài hát
                Song updatedSong = new Song(name, author, imageResId);
                songList.set(position, updatedSong);
                songAdapter.notifyItemChanged(position);
                Toast.makeText(this, "Song updated successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
