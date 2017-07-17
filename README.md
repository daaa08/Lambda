## Lambda
- 객체 안에 함수가 하나일때 사용 가능
- 식별자 없이 실행이 가능한 익명 함수
- 코드의 간결화, 함수형 언어의 대두로 인해 사용을 함
- 콜백패턴, 스트림에서 많이 쓰이게 됨
- 람다라는것을 알려주기위해 ->(화살표)를 씀
- (parameter) -> {code}

> 기존 코드 방식 OnClickListener
```java
button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               textView.setText("Yoyo");
           }
       });
```
> 람다식 OnClickListener
```java
button.setOnClickListener((view) -> {textView.setText("Yoyo");});
```

- 하나의 파라미터만 있다면 괄호와, 중괄호 생략 가능
```java
a -> System.out.println(a);
```
- 파라미터가 없다면 반드시 중괄호를 써줘야 함
```java
() -> System.out.println(a);
```
> Stream에서 기존 코드
```java
String objectArray[] = {"A", "B", "C", "DDDD1", "E", "F", "G", "H", "I", "J", "K"};

Arrays.stream(objectArray).forEach(a->System.out.println(a));
```

> 람다식
```java
String objectArray[] = {"A", "B", "C", "DDDD1", "E", "F", "G", "H", "I", "J", "K"};

Arrays.stream(objectArray).forEach( System.out::println );  // :: 은 reference 하겠다는 의미
```

---
#### findViewByMe
- layout에 등록한 위젯을 액티비티에 자동 세팅해줌(id가 부여된것만)
- jar 파일 추가해야 됨

> 사용법
1. jar파일 다운받기
2. Android Studio에서 setting -> plugin -> install plugin~~ 파일 찾아서 선택 -> restart
3. layout에 id를 부여한 위젯 추가
4. 액티비티에서 ex) activity_main 우클릭-> generate -> findViewByMe

