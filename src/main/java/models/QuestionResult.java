
package models;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.retify.*;

public class QuestionResult {

    @SerializedName("question_number")
    @Expose
    private Integer questionNumber;
    @SerializedName("correct")
    @Expose
    private Boolean correct;
    @SerializedName("rectify")
    @Expose
    private PnuNlpSpeller rectify;
    @SerializedName("submitted_answer")
    @Expose
    private String submittedAnswer;

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public PnuNlpSpeller getRectify() {
        return rectify;
    }

    public void setRectify(PnuNlpSpeller rectify) {
        this.rectify = rectify;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

}
