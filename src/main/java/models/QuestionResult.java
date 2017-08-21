
package models;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionResult {

    @SerializedName("question_number")
    @Expose
    private Integer questionNumber;
    @SerializedName("correct")
    @Expose
    private String correct;
    @SerializedName("wrong_part")
    @Expose
    private ArrayList<String[]> wrongPart;
    @SerializedName("submitted_answer")
    @Expose
    private String submittedAnswer;

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public ArrayList<String[]> getWrongPart() {
        return wrongPart;
    }

    public void setWrongPart(ArrayList<String[]> wrongPart) {
        this.wrongPart = wrongPart;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

}
