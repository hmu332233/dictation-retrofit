
import java.util.List;

import com.google.gson.JsonObject;

import models.Quiz;
import models.QuizHistory;
import models.QuizResult;
import models.Student;
import models.Teacher;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 2017-08-14.
 */

public interface DictationServerApi {

  
	//학생 중복 검사
	@GET("/students/check_duplicate")
	Call<ResponseBody> checkDuplicateStudent(	@Query("school") String school,
												@Query("grade") String grade,
												@Query("class") String _class,
												@Query("student_id") int studentId);
	//선생님 중복 검사
	@GET("/teachers/check_duplicate")
	Call<ResponseBody> checkDuplicateTeacher( @Query("login_id") String loginId);
	//학생 가입
	@POST("/students")
	Call<Student> signUpStudent(@Body JsonObject student);
	//선생님 가입
	@POST("/teachers")
	Call<Teacher> signUpTeacher(@Body JsonObject teacher);
    //학생 수정
    @GET("/quizzes")
    Call<List<Quiz>> getTeachersQuizzes();
    //선생님 로그인 아이디로 검색
    @GET("/teachers/login_id/{login_id}")
    Call<Teacher> searchTeacherByLoginID(@Path("login_id") String loginID);
    
    @GET("/teachers/{id}/quiz_histories")
    Call<List<QuizHistory>> getTeachersQuizHistories(@Path("id") String id);
    
    @GET("/quiz_histories/{id}")
    Call<QuizHistory> getQuizHistory(@Path("id") String id);
    
    @FormUrlEncoded
    @POST("/quiz/start")
    Call<ResponseBody> startQuiz(@Field("teacher_id") String teacherId, @Field("quiz_number") int quizNumber);
    
    @Headers("Content-Type: application/json")
    @POST("/quiz/end")
    Call<QuizHistory> endQuiz(@Body JsonObject endedQuiz);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://dictation.run.goorm.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
