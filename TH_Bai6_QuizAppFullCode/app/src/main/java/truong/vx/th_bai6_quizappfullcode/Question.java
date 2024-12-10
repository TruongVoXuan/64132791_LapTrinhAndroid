package truong.vx.th_bai6_quizappfullcode;

public class Question {
    private String questionText; // Câu hỏi
    private String answerA, answerB, answerC, answerD; // Các đáp án
    private String correctAnswer; // Đáp án đúng

    public Question(String questionText, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.questionText = questionText;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
