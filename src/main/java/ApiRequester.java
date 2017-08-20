import java.io.IOException;
import java.util.List;

import com.google.gson.*;

import models.EndedQuiz;
import models.Quiz;
import models.QuizHistory;
import models.QuizResult;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApiRequester {
	
	DictationServerApi dictationServerApi;
	Gson gson;
	JsonParser parser;
	
	public ApiRequester() {
		parser = new JsonParser();
		gson = new Gson();
		dictationServerApi = DictationServerApi.retrofit.create(DictationServerApi.class);
	}
	
	//quiz list를 리턴한다
	public List<Quiz> getTeachersQuizzes() throws IOException{
		Call<List<Quiz>> call = dictationServerApi.getTeachersQuizzes();
		return call.execute().body();
	}
	
	//quiz history를 리턴한다
	public QuizHistory getQuizHistory(String id) throws IOException{
    	Call<QuizHistory> call = dictationServerApi.getQuizHistory(id);
    	return call.execute().body();
	}
	
	//선생님의 quiz history를 리턴한다
	public List<QuizHistory> getTeachersQuizHistories(String id) throws IOException{
		Call<List<QuizHistory>> call = dictationServerApi.getTeachersQuizHistories(id);
    	return call.execute().body();
	}
	
	//시험을 시작하고 quiz history id를 리턴한다
	public String startQuiz(String teacherId, int quizNumber) throws JsonSyntaxException, IOException{
		Call<ResponseBody> call = dictationServerApi.startQuiz(teacherId, quizNumber);
		JsonObject object = new JsonParser().parse(call.execute().body().string()).getAsJsonObject();
		return object.get("quiz_history_id").getAsString();
	}
	
	//시험을 끝내고 quiz result를 전송한다
	public void endQuiz(String quizHistoryId, String studentId, QuizResult quizResult) throws JsonSyntaxException, IOException{
		
		EndedQuiz endedQuiz = new EndedQuiz();
		endedQuiz.setQuizHistoryId(quizHistoryId);
		endedQuiz.setQuizResult(quizResult);
		endedQuiz.setStudentId(studentId);
		
		System.out.println(gson.toJson(endedQuiz).toString());
		
		Call<ResponseBody> call = dictationServerApi.endQuiz(parser.parse(gson.toJson(endedQuiz)).getAsJsonObject());
		JsonObject object = new JsonParser().parse(call.execute().body().string()).getAsJsonObject();
		System.out.println(object.get("quiz_number").getAsString());
	}
}
