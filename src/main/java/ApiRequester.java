import java.io.IOException;
import java.util.List;

import com.google.gson.*;

import models.EndedQuiz;
import models.Quiz;
import models.QuizHistory;
import models.QuizResult;
import models.Student;
import models.Teacher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequester {
	
	DictationServerApi dictationServerApi;
	Gson gson;
	JsonParser parser;
	
	Callback callback;
	
	public interface UserCallback<T>{
		void onSuccess(T result);
		void onFail();
	}
	
	private class ObjectCallback<T> implements Callback<T>{

		UserCallback callback;
		
		public ObjectCallback(UserCallback<T> _callback){
			callback = _callback;
		}
		
		@Override
		public void onResponse(Call<T> call, Response<T> response) {
			// TODO Auto-generated method stub
			if (response.isSuccessful()) {
				// tasks available
				callback.onSuccess(response.body());
			} else {
				int status = response.code();
				if( status == 404){
					System.out.println("Not Found");
					callback.onSuccess(null);
				}
				else {
					System.out.println("서버 실패");
					callback.onFail();
				}
				
			}
		}
		@Override
		public void onFailure(Call<T> call, Throwable t) {
			// TODO Auto-generated method stub
			
			System.out.println(t.getMessage());
			callback.onFail();
		}
	}
	
	private class ResultCallback implements Callback<okhttp3.ResponseBody>{

		UserCallback callback;
		
		public ResultCallback(UserCallback _callback){
			callback = _callback;
		}
		
		@Override
		public void onResponse(Call<okhttp3.ResponseBody> call, Response<okhttp3.ResponseBody> response) {
			// TODO Auto-generated method stub
			if (response.isSuccessful()) {
				// tasks available
				JsonObject object;
				try {
					object = new JsonParser().parse(response.body().string()).getAsJsonObject();
					callback.onSuccess(object.get("result").getAsBoolean());
				} catch (JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				// error response, no access to resource?
				System.out.println("서버 실패");
				callback.onFail();
			}
		}
		@Override
		public void onFailure(Call<okhttp3.ResponseBody> call, Throwable t) {
			// TODO Auto-generated method stub
			System.out.println(t.getMessage());
			callback.onFail();
		}
	}
	
	
	public ApiRequester() {
		parser = new JsonParser();
		gson = new Gson();
		dictationServerApi = DictationServerApi.retrofit.create(DictationServerApi.class);
	}
	
	//quiz list를 리턴한다
	public void getTeachersQuizzes(UserCallback<List<Quiz>> userCallback) throws IOException{
		Call<List<Quiz>> call = dictationServerApi.getTeachersQuizzes();
		call.enqueue(new ObjectCallback<List<Quiz>>(userCallback));
	}
	
	//quiz history를 리턴한다
	public void getQuizHistory(String quizHistoryId, UserCallback<QuizHistory> userCallback) throws IOException{
    	Call<QuizHistory> call = dictationServerApi.getQuizHistory(quizHistoryId);
    	call.enqueue(new ObjectCallback<QuizHistory>(userCallback));
	}
	
	//선생님의 quiz history를 리턴한다
	public void getTeachersQuizHistories(String teacherId, UserCallback<List<QuizHistory>> userCallback) throws IOException{
		Call<List<QuizHistory>> call = dictationServerApi.getTeachersQuizHistories(teacherId);
		call.enqueue(new ObjectCallback<List<QuizHistory>>(userCallback));
	}
	
	//시험을 시작하고 quiz history id를 리턴한다
	public String startQuiz(String teacherId, int quizNumber) throws JsonSyntaxException, IOException{
		Call<okhttp3.ResponseBody> call = dictationServerApi.startQuiz(teacherId, quizNumber);
		JsonObject object = new JsonParser().parse(call.execute().body().string()).getAsJsonObject();
		return object.get("quiz_history_id").getAsString();
	}
	
	//시험을 끝내고 quiz result를 전송한다
	public void endQuiz(String quizHistoryId, String studentId, QuizResult quizResult, UserCallback<QuizHistory> userCallback) throws JsonSyntaxException, IOException{
		
		EndedQuiz endedQuiz = new EndedQuiz();
		endedQuiz.setQuizHistoryId(quizHistoryId);
		endedQuiz.setQuizResult(quizResult);
		endedQuiz.setStudentId(studentId);
		
		System.out.println(gson.toJson(endedQuiz).toString());
		
		Call<QuizHistory> call = dictationServerApi.endQuiz(parser.parse(gson.toJson(endedQuiz)).getAsJsonObject());
		call.enqueue(new ObjectCallback<QuizHistory>(userCallback));
	}
	
	//login_id로 선생님의 가입여부를 판단한다
	public void checkDuplicateTeacher(String loginId, UserCallback<Boolean> userCallback){
		Call<okhttp3.ResponseBody> call = dictationServerApi.checkDuplicateTeacher(loginId);
		call.enqueue(new ResultCallback(userCallback));
	}
	//학교,반,번호,이름으로 학생의 가입여부를 판단한다
	public void checkDuplicateStudent(Student student, UserCallback<Boolean> userCallback){
		Call<okhttp3.ResponseBody> call = dictationServerApi.checkDuplicateStudent(	student.getSchool(),
																					student.getGrade(),
																					student.getClass_(),
																					student.getStudentId());
		call.enqueue(new ResultCallback(userCallback));
	}
	
	//학생 회원 가입
	public void signUpStudent(Student student, UserCallback<Student> userCallback){
		Call<Student> call = dictationServerApi.signUpStudent(parser.parse(gson.toJson(student)).getAsJsonObject());
		call.enqueue(new ObjectCallback<Student>(userCallback));
	}
	
	//선생님 회원 가입
	public void signUpTeacher(Teacher teacher, UserCallback<Teacher> userCallback){
		Call<Teacher> call = dictationServerApi.signUpTeacher(parser.parse(gson.toJson(teacher)).getAsJsonObject());
		call.enqueue(new ObjectCallback<Teacher>(userCallback));
	}
	
	//선생님 로그인 아이디로 검색
	public void searchTeacherByLoginID(String loginID, UserCallback<Teacher> userCallback){
		Call<Teacher> call = dictationServerApi.searchTeacherByLoginID(loginID);
		call.enqueue(new ObjectCallback<Teacher>(userCallback));
	}
}
