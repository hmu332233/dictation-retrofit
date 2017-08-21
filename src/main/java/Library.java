import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.google.gson.*;

import models.QuestionResult;
import models.Quiz;
import models.QuizHistory;
import models.QuizResult;
import models.Teacher;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class Library {
    public static void main(String[] args) {

    	try {
    		ApiRequester apiRequester = new ApiRequester();
//    		
    		QuizResult quizResult = new QuizResult();
    		quizResult.setQuizNumber(1);
    		quizResult.setScore(50);
    		quizResult.setStudentName("test");
    		
    		QuestionResult questionResult = new QuestionResult();
    		questionResult.setCorrect(true);
    		ArrayList list = new ArrayList<QuestionResult>();
    		list.add(questionResult);
    		quizResult.setQuestionResult(list);
//    		apiRequester.endQuiz("59995196a3735c015c4fff38", "599950df63aa9d012f8f5dea" , quizResult);
			
//    		System.out.println(apiRequester.startQuiz("5999506d00ab0b00f493dc0d", 3));
//    		
//    		apiRequester.getTeachersQuizzes(new API);
    		
//    		apiRequester.endQuiz("599b258d4cbd500343a014ff", "599950df63aa9d012f8f5dea" , quizResult, new ApiRequester.UserCallback<QuizHistory>() {
//
//				@Override
//				public void onSuccess(QuizHistory result) {
//					// TODO Auto-generated method stub
//					System.out.println("성공");
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					System.out.println("실패");
//				}
//			});
//    		
    		apiRequester.getQuizHistory("599b4de9e5d3aa01a4ed336f",new ApiRequester.UserCallback<QuizHistory>() {
				
				@Override
				public void onSuccess(QuizHistory result) {
					// TODO Auto-generated method stub
			
						
						List<QuizResult> qr = result.getQuizResults();
						
						System.out.println(qr.get(0).getQuestionResult().get(0).getRectify().get(0)[0]);
						
							
							
				}
				
				@Override
				public void onFail() {
					// TODO Auto-generated method stub
					
				}
			});
    		
    		
//    		
//    		List<QuizHistory> quizHistories = apiRequester.getTeachersQuizHistories("5999506d00ab0b00f493dc0d");
//    		for(QuizHistory qh : quizHistories)
//    			System.out.println(qh.getQuizNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
