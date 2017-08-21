## dictation-retrofit
- `우리학교받아쓰기`의 client 중 retrofit을 이용하여 서버와 통신하는 파일

### 주요 파일
- DictationServerApi
  - retrofit을 이용한 api 정의
- ApiRequester
  - `DictationServerApi`을 사용하여 model 객체 생성
- models
  - model 모아놓은 폴더
### 사용법
- `apiRequester.method(callback)`
- 해당 메소드의 인자를 넣어주고 callback으로 `ApiRequester.UserCallback`을 넣어준다.
```java
apiRequester.getTeachersQuizzes(new ApiRequester.UserCallback<List<Quiz>>() {

				@Override
				public void onSuccess(List<Quiz> result) {
					// TODO Auto-generated method stub
				}

				@Override
				public void onFail() {
					// TODO Auto-generated method stub
				}
			});
```
### 사용 라이브러리
- **gradle**
```bash
compile 'com.squareup.retrofit2:converter-gson:2.3.0'
compile 'com.squareup.retrofit2:retrofit:2.3.0'
compile 'com.google.code.gson:gson:2.3.1'
```
### 메모
- [jsonschema2pojo](http://www.jsonschema2pojo.org/)를 이용하여 json 스키마를 java 파일로 만들어 사용하였다.

### 연관 프로젝트
- [dictation-server](https://github.com/hmu332233/dictation-server)
