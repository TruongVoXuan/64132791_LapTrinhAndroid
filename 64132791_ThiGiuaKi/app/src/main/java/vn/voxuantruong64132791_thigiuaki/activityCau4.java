package vn.voxuantruong64132791_thigiuaki;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activityCau4 extends AppCompatActivity {
    Button calculateButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Name TextView setup
        TextView nameTextView = findViewById(R.id.nameTextView);
        if (nameTextView != null) {
            nameTextView.setText("🎃 VÕ XUÂN TRƯỜNG 🎃");
            nameTextView.setTextColor(Color.parseColor("#FF9800"));
        } else {
            Log.e("ActivityCau4", "TextView with ID nameTextView not found!");
        }

        // Profile image setup
        ImageView profileImageView = findViewById(R.id.profileImageView);
        if (profileImageView != null && profileImageView.getDrawable() != null) {
            Bitmap bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
            profileImageView.setImageBitmap(createRoundedBitmap(bitmap));
        } else {
            Log.e("ActivityCau4", "ImageView with ID profileImageView not found!");
        }

        // Profile bio setup
        TextView aboutTextView = findViewById(R.id.profile_bio);
        if (aboutTextView != null) {
            SpannableStringBuilder introductionText = new SpannableStringBuilder();
            introductionText.append("🎃 Tôi tên: VÕ XUÂN TRƯỜNG\nLớp: 64-CNTT-CLC2\nKhoa: CÔNG NGHỆ THÔNG TIN\n\n")
                    .setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), 0, introductionText.length(), 0);

            int startGoal = introductionText.length();
            introductionText.append("Mục tiêu cuộc sống: ");
            int endGoal = introductionText.length();
            introductionText.setSpan(new StyleSpan(Typeface.BOLD), startGoal, endGoal, 0);
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), startGoal, endGoal, 0);

            introductionText.append("Trở thành một lập trình viên giỏi và đóng góp cho xã hội.\n")
                    .setSpan(new ForegroundColorSpan(Color.parseColor("#FFCC80")), endGoal, introductionText.length(), 0);

            int startHobby = introductionText.length();
            introductionText.append("Sở thích: ");
            int endHobby = introductionText.length();
            introductionText.setSpan(new StyleSpan(Typeface.BOLD), startHobby, endHobby, 0);
            introductionText.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), startHobby, endHobby, 0);

            introductionText.append("Đọc sách, du lịch và chơi game.")
                    .setSpan(new ForegroundColorSpan(Color.parseColor("#FFCC80")), endHobby, introductionText.length(), 0);

            aboutTextView.setText(introductionText);
        } else {
            Log.e("ActivityCau4", "TextView with ID profile_bio not found!");
        }

        // Set up social media buttons
        configureSocialMediaButton(R.id.icon_facebook, "https://www.facebook.com/NakrothQDDNss");
        configureSocialMediaButton(R.id.icon_youtube, "https://www.youtube.com/@37voxuantruong51");
        configureSocialMediaButton(R.id.icon_gmail, "mailto:truong.vx.64cntt@ntu.edu.vn");
    }

    private void configureSocialMediaButton(int buttonId, String url) {
        ImageView button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v -> openLink(url));
        } else {
            Log.e("ActivityCau4", "Button with ID " + buttonId + " not found!");
        }
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

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
