package truong.vx.thigk;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent; // Thêm dòng này
import androidx.appcompat.app.AppCompatActivity;

public class Profile_Activity extends AppCompatActivity {
    Button calculateButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() { // Xử lý sự kiện nút trở về
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại và trở về Activity trước
            }
        });
        // Thiết lập tên trong TextView
        TextView nameTextView = findViewById(R.id.nameTextView);
        if (nameTextView != null) {
            nameTextView.setText("🎃 VÕ XUÂN TRƯỜNG 🎃");
            nameTextView.setTextColor(Color.parseColor("#FF9800")); // Màu cam đậm cho tên
        } else {
            Log.e("MainActivity", "TextView với id nameTextView không tìm thấy!");
        }

// Thiết lập và bo tròn ảnh đại diện trong ImageView
        ImageView profileImageView = findViewById(R.id.profileImageView);
        if (profileImageView != null && profileImageView.getDrawable() != null) {
            Bitmap bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
            profileImageView.setImageBitmap(createRoundedBitmap(bitmap));
        } else {
            Log.e("MainActivity", "ImageView với id profileImageView không tìm thấy!");
        }

// Thiết lập văn bản cho phần giới thiệu
        TextView aboutTextView = findViewById(R.id.profile_bio);
        if (aboutTextView != null) {
            SpannableStringBuilder introductionText = new SpannableStringBuilder();

            // Thêm tên và lớp với màu cam đậm
            introductionText.append("🎃 Tôi tên: VÕ XUÂN TRƯỜNG\n");
            introductionText.append("Lớp: 64-CNTT-CLC2\n");
            introductionText.append("Khoa: CÔNG NGHỆ THÔNG TIN\n\n");
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), 0, introductionText.length(), 0);

            // Thêm tiêu đề "Mục tiêu cuộc sống" với màu cam đậm
            int startGoal = introductionText.length();
            introductionText.append("Mục tiêu cuộc sống: ");
            int endGoal = introductionText.length();
            introductionText.setSpan(new StyleSpan(Typeface.BOLD), startGoal, endGoal, 0);
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), startGoal, endGoal, 0);

            // Thêm nội dung cho mục tiêu cuộc sống với màu cam nhạt
            introductionText.append("Trở thành một lập trình viên giỏi và đóng góp cho xã hội.\n");
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FFCC80")), endGoal, introductionText.length(), 0);

            // Thêm tiêu đề "Sở thích" với màu cam đậm
            int startHobby = introductionText.length();
            introductionText.append("Sở thích: ");
            int endHobby = introductionText.length();
            introductionText.setSpan(new StyleSpan(Typeface.BOLD), startHobby, endHobby, 0);
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), startHobby, endHobby, 0);

            // Thêm nội dung cho sở thích với màu cam nhạt
            introductionText.append("Đọc sách, du lịch và chơi game.");
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FFCC80")), endHobby, introductionText.length(), 0);

            // Thiết lập văn bản cho TextView
            aboutTextView.setText(introductionText);
        } else {
            Log.e("MainActivity", "TextView với id profile_bio không tìm thấy!");
        }


        // Các nút cho Facebook, YouTube, Gmail
        ImageView facebookButton = findViewById(R.id.icon_facebook);
        ImageView youtubeButton = findViewById(R.id.icon_youtube);
        ImageView gmailButton = findViewById(R.id.icon_gmail);

        if (facebookButton != null) {
            facebookButton.setOnClickListener(v -> openLink("https://www.facebook.com/NakrothQDDNss"));
        } else {
            Log.e("MainActivity", "Button với id button_facebook không tìm thấy!");
        }

        if (youtubeButton != null) {
            youtubeButton.setOnClickListener(v -> openLink("https://www.youtube.com/@37voxuantruong51"));
        } else {
            Log.e("MainActivity", "Button với id button_youtube không tìm thấy!");
        }

        if (gmailButton != null) {
            gmailButton.setOnClickListener(v -> sendEmail("truong.vx.64cntt@ntu.edu.vn"));
        } else {
            Log.e("MainActivity", "Button với id button_gmail không tìm thấy!");
        }
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void sendEmail(String email) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Hàm tạo ảnh bo tròn từ Bitmap
    private Bitmap createRoundedBitmap(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        float radius = size / 2f;
        canvas.drawCircle(radius, radius, radius, paint);

        return output;
    }
}
