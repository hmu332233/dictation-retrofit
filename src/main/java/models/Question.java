
package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

	@SerializedName("number")
	@Expose
	private Integer number;
	@SerializedName("sentence")
	@Expose
	private String sentence;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

}
