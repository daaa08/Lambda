package com.example.da08.studio3begin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;
    private Button stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        LambdaFunction arg = p -> p * p;    // 3 실행
        calc(arg);

//        LambdaFunction arg = new LambdaFunction() {   // 위의 코드를 풀어쓴 것
//            @Override
//            public int squareParameter(int p) {
//                return p *p;
//            }
//        };

        // 람다식 OnClickListener
//        button.setOnClickListener((view) -> {textView.setText("Yoyo");});
//        button.setOnClickListener((view) -> { System.out.print(view);});

        String objectArray[] = {"A", "B", "C", "DDDD1", "E", "F", "G", "H", "I", "J", "K"};
        button.setOnClickListener((view) -> {
            printOneWord(objectArray);
        });

        Stream<String> data = Arrays.stream(objectArray);

        stream.setOnClickListener(view -> printStream(data));

        // 기존 코드 방식 OnClickListener
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Yoyo");
//            }
//        });
    }

    private void initView() {  // findBiewByMe로 한번에 세팅 됨
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        stream = (Button) findViewById(R.id.stream);
    }

    public void calc(LambdaFunction param) {    // 2 함수 구현
        int result = param.squareParameter(7);
        System.out.println(result);
    }

    @FunctionalInterface
            // 1 인터페이스 선언
    interface LambdaFunction {
        public abstract int squareParameter(int number);
    }

    private void printOneWord(String arr[]) {  // 데이터의 처음부터 끝까지가 다 들어가있음 '{~~}'
        for (String item : arr) {
            if (item.length() == 1) {
                System.out.println(item);
            }
        }
    }

    private void printStream(Stream<String> data){   // 데이터의 가장 앞부분만 가르키고있는 상태 '{'
        data
            .filter(item -> item.length() ==1)
            .forEach(item -> System.out.println(item));  // 데이터에서 하나씩 가져옴
    }
}
