package truong.vx.th_bai6_quizappfullcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BlankFragmentBody extends Fragment {

    private androidx.cardview.widget.CardView answerA, answerB, answerC, answerD, nextBtn;
    private boolean isAnswerCorrect = false; // Để lưu trữ câu trả lời đúng
    private int currentQuestionIndex = 0; // Lưu chỉ số câu hỏi hiện tại
    private Question currentQuestion; // Câu hỏi hiện tại

    // Khởi tạo ArrayList chứa các câu hỏi
    private ArrayList<Question> dsCauHoi = new ArrayList<>();

    public BlankFragmentBody() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Thêm câu hỏi vào ArrayList
        dsCauHoi.add(new Question("Câu hỏi: 2 + 2 = ?", "A: 4", "B: 5", "C: 6", "D: 7", "A"));
        dsCauHoi.add(new Question("Câu hỏi: 3 + 5 = ?", "A: 7", "B: 8", "C: 9", "D: 6", "B"));
        // Gán câu hỏi đầu tiên vào biến currentQuestion
        currentQuestion = dsCauHoi.get(currentQuestionIndex);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_body, container, false);

        // Lấy các reference của các view
        answerA = view.findViewById(R.id.answerA);
        answerB = view.findViewById(R.id.answerB);
        answerC = view.findViewById(R.id.answerC);
        answerD = view.findViewById(R.id.answerD);
        nextBtn = view.findViewById(R.id.nextBtn);

        // Gán câu hỏi vào TextView
        TextView questionTextView = view.findViewById(R.id.questionText);
        if (questionTextView != null) {
            questionTextView.setText(currentQuestion.getQuestionText());
        }

        // Gán đáp án vào các câu trả lời
        TextView answerAText = answerA.findViewById(R.id.answerText);
        TextView answerBText = answerB.findViewById(R.id.answerText);
        TextView answerCText = answerC.findViewById(R.id.answerText);
        TextView answerDText = answerD.findViewById(R.id.answerText);

        // Hiển thị các đáp án đúng trong các TextView tương ứng
        if (answerAText != null) answerAText.setText(currentQuestion.getAnswerA());  // Gán đáp án A
        if (answerBText != null) answerBText.setText(currentQuestion.getAnswerB());  // Gán đáp án B
        if (answerCText != null) answerCText.setText(currentQuestion.getAnswerC());  // Gán đáp án C
        if (answerDText != null) answerDText.setText(currentQuestion.getAnswerD());  // Gán đáp án D

        // Gán hiệu ứng click cho các câu trả lời
        setAnswerClickListener(answerA, "A");
        setAnswerClickListener(answerB, "B");
        setAnswerClickListener(answerC, "C");
        setAnswerClickListener(answerD, "D");

        // Gán sự kiện cho button Next
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnswerCorrect) {
                    // Nếu trả lời đúng, chuyển sang câu hỏi tiếp theo
                    currentQuestionIndex++;  // Tăng chỉ số câu hỏi
                    if (currentQuestionIndex < dsCauHoi.size()) {
                        currentQuestion = dsCauHoi.get(currentQuestionIndex);  // Cập nhật câu hỏi mới
                        updateUIForNextQuestion();  // Cập nhật giao diện với câu hỏi mới
                    } else {
                        // Nếu hết câu hỏi, chuyển đến màn hình kết quả
                        Intent intent = new Intent(getActivity(), MainActivityResult.class);
                        startActivity(intent);
                    }
                } else {
                    // Nếu sai, thông báo và reset lại các hover
                    Toast.makeText(getActivity(), "Câu trả lời sai!", Toast.LENGTH_SHORT).show();
                    resetAnswerHover();
                }
            }
        });

        return view;
    }

    private void updateUIForNextQuestion() {
        // Cập nhật câu hỏi và đáp án mới
        TextView questionTextView = getView().findViewById(R.id.questionText);
        if (questionTextView != null) {
            questionTextView.setText(currentQuestion.getQuestionText());
        }

        // Gán lại đáp án vào các TextView tương ứng
        TextView answerAText = answerA.findViewById(R.id.answerText);
        TextView answerBText = answerB.findViewById(R.id.answerText);
        TextView answerCText = answerC.findViewById(R.id.answerText);
        TextView answerDText = answerD.findViewById(R.id.answerText);

        if (answerAText != null) answerAText.setText(currentQuestion.getAnswerA());
        if (answerBText != null) answerBText.setText(currentQuestion.getAnswerB());
        if (answerCText != null) answerCText.setText(currentQuestion.getAnswerC());
        if (answerDText != null) answerDText.setText(currentQuestion.getAnswerD());

        // Reset lại các hover trước khi người dùng chọn đáp án mới
        resetAnswerHover();
    }

    // Hàm xử lý click vào câu trả lời
    private void setAnswerClickListener(CardView answer, String answerChoice) {
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem câu trả lời đúng hay sai
                if (answerChoice.equals(currentQuestion.getCorrectAnswer())) {
                    isAnswerCorrect = true;
                    answer.setBackgroundResource(R.drawable.background_correct); // Chuyển màu xanh lá
                } else {
                    isAnswerCorrect = false;
                    answer.setBackgroundResource(R.drawable.background_incorrect); // Chuyển màu đỏ
                }
            }
        });
    }

    // Hàm reset lại hover của các câu trả lời
    private void resetAnswerHover() {
        // Reset lại background cho tất cả các câu trả lời về mặc định (khi chưa được chọn)
        answerA.setBackgroundResource(R.drawable.background_selector);
        answerB.setBackgroundResource(R.drawable.background_selector);
        answerC.setBackgroundResource(R.drawable.background_selector);
        answerD.setBackgroundResource(R.drawable.background_selector);
    }
}
