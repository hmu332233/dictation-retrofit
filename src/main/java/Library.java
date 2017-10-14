import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.IOException;

import com.google.gson.*;

import models.retify.*;
import models.retify.Error;
import models.QuestionResult;
import models.Quiz;
import models.QuizHistory;
import models.QuizResult;
import models.School;
import models.Student;
import models.Teacher;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class Library {
    public static void main(String[] args) {

    	try {
    		ApiRequester apiRequester = new ApiRequester();
//    		
    	
    		
//    		apiRequester.endQuiz("59995196a3735c015c4fff38", "599950df63aa9d012f8f5dea" , quizResult);
			
//    		System.out.println(apiRequester.startQuiz("5999506d00ab0b00f493dc0d", 3));
//    		
//    		apiRequester.getTeachersQuizzes(new API);
    		

////    		
//    		apiRequester.getQuizHistory("599b4de9e5d3aa01a4ed336f",new ApiRequester.UserCallback<QuizHistory>() {
//				
//				@Override
//				public void onSuccess(QuizHistory result) {
//					// TODO Auto-generated method stub
//			
//						
//						List<QuizResult> qr = result.getQuizResults();
//						
//						System.out.println(qr.get(0).getQuestionResult().get(0).getRectify().get(0)[0]);
//						
//							
//							
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		apiRequester.getTeachersQuizzes(new ApiRequester.UserCallback<List<Quiz>>() {
//				
//				@Override
//				public void onSuccess(List<Quiz> result) {
//					// TODO Auto-generated method stub
//					for(Quiz q : result)
//						System.out.println(q.getQuestions().get(0).getSentence());
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
//    		Student student = new Student();
//    		student.setStudentId(1);
//    		student.setClass_("2");
//    		student.setGrade("1");
//    		student.setSchool("한국초등학교");
//    		student.setName("테스트");
//    		
//    		apiRequester.signUpStudent(student,new ApiRequester.UserCallback<Student>() {
//				
//				@Override
//				public void onSuccess(Student result) {
//					// TODO Auto-generated method stub
//					System.out.println(result.getName());
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
//    		Teacher teacher = new Teacher();
//    		teacher.setLoginId("test2@test.com");
//    		
//    		apiRequester.signUpTeacher(teacher, new ApiRequester.UserCallback<Teacher>() {
//
//				@Override
//				public void onSuccess(Teacher result) {
//					// TODO Auto-generated method stub
//					System.out.println(result.getLoginId());
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//    			
//    		});

//    		apiRequester.searchTeacherByLoginID("test@test.com", new ApiRequester.UserCallback<Teacher>() {
//				
//				@Override
//				public void onSuccess(Teacher result) {
//					// TODO Auto-generated method stub
//					if(result == null) System.out.println("없음");
//					else System.out.println("있음");
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
//    		apiRequester.loginTeacher("test@test.com", "123", new ApiRequester.UserCallback<Teacher>() {
//				
//				@Override
//				public void onSuccess(Teacher result) {
//					// TODO Auto-generated method stub
//					if(result == null) System.out.println("없음");
//					else System.out.println("있음");
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		
//    		apiRequester.checkDuplicateTeacher("test@test.com", new ApiRequester.UserCallback<Boolean>() {
//				
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					System.out.println(result);
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
    		String s[] = {"asdf","Asdf"};
    		
    		Help help = new Help();
    		help.setNCorrectMethod(0);
    		help.setText("asdf");
    		
    		CandWordList candWordList = new CandWordList();
    		candWordList.setCandWord(s);
    		candWordList.setM_nCount(2);
    		
    		
    		Error error = new Error();
    		error.setMsg("msg");
    		
    		PnuErrorWord pnuErrorWord = new PnuErrorWord();
    		pnuErrorWord.setCandWordList(candWordList);
    		pnuErrorWord.setHelp(help);
    		pnuErrorWord.setM_nEnd("54");
    		pnuErrorWord.setM_nStart("4");
    		pnuErrorWord.setNErrorIdx("45");
    		pnuErrorWord.setOrgStr("asdfasdf");
    		
 
    		
    		PnuErrorWord[] arrayList = {pnuErrorWord};
    		
    		
    		PnuErrorWordList pnuErrorWordList = new PnuErrorWordList();
    		pnuErrorWordList.setError(error);
    		pnuErrorWordList.setRepeat("nn");
    		pnuErrorWordList.setPnuErrorWord(arrayList);
    			
    		
  
    		PnuNlpSpeller pnuNlpSpeller = new PnuNlpSpeller();
    		
    		
 
    		
    		PnuErrorWordList[] errorWordLists = {pnuErrorWordList};
    		
    		pnuNlpSpeller.setPnuErrorWordList(errorWordLists);
 
    		Gson gson;
    		JsonParser parser;
    		
    		parser = new JsonParser();
    		gson = new Gson();
    		

    		System.out.println(parser.parse(gson.toJson(pnuNlpSpeller)));
    		
    		
    		QuizResult quizResult = new QuizResult();
    		quizResult.setQuizNumber(1);
    		quizResult.setScore(50);
    		quizResult.setStudentName("test");
    		
    		QuestionResult questionResult = new QuestionResult();
    		questionResult.setCorrect(true);
    		questionResult.setRectify(pnuNlpSpeller);
    		ArrayList list = new ArrayList<QuestionResult>();
    		list.add(questionResult);
    		quizResult.setQuestionResult(list);
    		
//    		apiRequester.endQuiz("59c7b6ecebd78b00b8c9147b", "599b4041cefd5d07c5be9594" , quizResult, new ApiRequester.UserCallback<QuizHistory>() {
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
//    		apiRequester.getQuizHistory("59c7b6ecebd78b00b8c9147b", new ApiRequester.UserCallback<QuizHistory>() {
//
//				@Override
//				public void onSuccess(QuizHistory result) {
//					// TODO Auto-generated method stub
//					for( QuizResult q : result.getQuizResults())
//						for( QuestionResult qr : q.getQuestionResult()){
//							System.out.println(qr.getRectify().getPnuErrorWordList()[0].getPnuErrorWord()[0].getOrgStr());
//						}
//				
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
////    		
//    		apiRequester.acceptMatching("test@test.com", "599c75f7836cc308789f5902", new ApiRequester.UserCallback<Boolean>() {
//    			
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
//    		apiRequester.applyMatching("test@test.com", "599c75f7836cc308789f5902", new ApiRequester.UserCallback<Boolean>() {
//    			
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		
//    		apiRequester.cancelMatching("test@test.com", "599c75f7836cc308789f5902", new ApiRequester.UserCallback<Boolean>() {
//    			
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					System.out.println(result);
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		apiRequester.getTeachersApplicants("test@test.com", new ApiRequester.UserCallback<List<Student>>(){
//
//				@Override
//				public void onSuccess(List<Student> result) {
//					// TODO Auto-generated method stub
//					for(Student s : result)
//						System.out.println(s.getName());
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//    			
//    		});
// 
//    		
//    		List<QuizHistory> quizHistories = apiRequester.getTeachersQuizHistories("5999506d00ab0b00f493dc0d");
//    		for(QuizHistory qh : quizHistories)
//    			System.out.println(qh.getQuizNumber());
    		
//    		apiRequester.getSchools(new ApiRequester.UserCallback<List<School>>() {
//				
//				@Override
//				public void onSuccess(List<School> result) {
//					// TODO Auto-generated method stub
//					for(School s : result){
//						System.out.println(s.getName());
//					}
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		
//    		apiRequester.searchSchools("서울특별시", "서초구", new ApiRequester.UserCallback<List<School>>() {
//
//				@Override
//				public void onSuccess(List<School> result) {
//					// TODO Auto-generated method stub
//					for(School s : result)
//						System.out.println(s.getName());
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
//    		apiRequester.getStudentsTeachers("599c75f7836cc308789f5902", new ApiRequester.UserCallback<List<Teacher>>(){
//
//				@Override
//				public void onSuccess(List<Teacher> result) {
//					// TODO Auto-generated method stub
//					for(Teacher t : result)
//						System.out.println(t.getId());
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//    			
//    		});
    		
//    		apiRequester.unConnectedMatching("599c75f7836cc308789f5902", "599b03151c6e6f0159a72815", new ApiRequester.UserCallback<Boolean>(){
//
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					System.out.println(result);
//				}
//
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//    			
//    		});
    		
//    		apiRequester.getTeachersQuizzes("599b03151c6e6f0159a72815", new ApiRequester.UserCallback<List<Quiz>>() {
//				
//				@Override
//				public void onSuccess(List<Quiz> result) {
//					// TODO Auto-generated method stub
//					for(Quiz q : result) {
//						System.out.println(q.getNumber());
//					}
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		
//    		Quiz quiz = new Quiz();
//    		quiz.setName("asdf");
//    		quiz.setNumber(10);
    	
    		
//    		apiRequester.addTeachersQuiz("599b03151c6e6f0159a72815", quiz, new ApiRequester.UserCallback<Boolean>() {
//				
//				@Override
//				public void onSuccess(Boolean result) {
//					// TODO Auto-generated method stub
//					System.out.println(result);
//				}
//				
//				@Override
//				public void onFail() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
    		
    		apiRequester.getStudent("599b4041cefd5d07c5be9594", new ApiRequester.UserCallback<Student>() {
				
				@Override
				public void onSuccess(Student result) {
					// TODO Auto-generated method stub
					System.out.println(result.getName());
					result.setName("ㅎㅎㅎ");
					
					apiRequester.updateStudent("599b4041cefd5d07c5be9594", result, new ApiRequester.UserCallback<Student>() {
						
						@Override
						public void onSuccess(Student result) {
							// TODO Auto-generated method stub
							System.out.println(result.getName());
						}
						
						@Override
						public void onFail() {
							// TODO Auto-generated method stub
							
						}
					});
				}
				
				@Override
				public void onFail() {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
