package com.example.what_the_ffle0505;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class menuchoice extends AppCompatActivity implements View.OnClickListener {

    // order 클래스에서도 이 버튼의 동작을 활용하기 위해 static 변수로 지정
    public static Button btnOrderCount;

    //order 클래스에서 이 변수들을 활용하기 위해 static 변수로 지정
    public static int menu1_count = 0;
    public static int menu2_count = 0;
    public static int menu3_count = 0;
    public static int menu4_count = 0;
    public static int orderCount = 0;

    //햄버거 버튼 눌린 횟수를 저장하기 위한 변수
    int hamburger_btn1 = 0;
    int hamburger_btn2 = 0;
    int hamburger_btn3 = 0;
    int hamburger_btn4 = 0;

    //햄버거 버튼이 눌리면 튀어나오는 숨겨진 레이아웃
    private LinearLayout waffle_hidden;
    private LinearLayout jjondeugi_hidden;
    private LinearLayout jangiji_hidden;
    private LinearLayout jeolpyeon_hidden;

    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuchoice);

        //버튼과 레이아웃을 id와 일치시키기
        btnOrderCount = findViewById(R.id.choice_btn);

        waffle_hidden = findViewById(R.id.waffle_hidden);
        jjondeugi_hidden = findViewById(R.id.jjondeugi_hidden);
        jangiji_hidden = findViewById(R.id.jangiji_hidden);
        jeolpyeon_hidden = findViewById(R.id.jeolpyeon_hidden);

        scroll = findViewById(R.id.scroll);

        //버튼들 이벤트 리스너 달기
        findViewById(R.id.waffle_mainbtn).setOnClickListener(this);
        findViewById(R.id.jjondeugi_mainbtn).setOnClickListener(this);
        findViewById(R.id.jangiji_mainbtn).setOnClickListener(this);
        findViewById(R.id.jeolpyeon_mainbtn).setOnClickListener(this);

        findViewById(R.id.waffle_btn).setOnClickListener(this);
        findViewById(R.id.jjondeugi_btn).setOnClickListener(this);
        findViewById(R.id.jangiji_btn).setOnClickListener(this);
        findViewById(R.id.jeolpyeon_btn).setOnClickListener(this);

        btnOrderCount.setOnClickListener(this);
    }

    public static void finalOrder() {                             //맨 아래 주문완료 버튼에 들어가는 텍스트를 지정해주는 메소드
        orderCount = menu1_count + menu2_count + menu3_count + menu4_count;
        btnOrderCount.setText("주문 완료 (" + orderCount + ")");
    }

    @Override
    public void onClick(View view) {                              //리스너들을 달았던 버튼들 이벤트 지정
        switch (view.getId()){                                    //눌린 버튼의 id 가져오기

            case R.id.waffle_mainbtn:                             //1번 메뉴(꿀호떡)가 눌렸을 때

                if (menu1_count == 3){                            //최대 수량일 경우 토스트 메시지
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                }
                else{                                             // 정상 작동
                    menu1_count++;
                    finalOrder();
                }
                break;

            case R.id.jjondeugi_mainbtn:                          //2번 메뉴(쫀드기)가 눌렸을 때

                if (menu2_count == 3){                            //위와 동일
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    menu2_count++;
                    finalOrder();
                }
                break;

            case R.id.jangiji_mainbtn:                            //3번 메뉴(잔기지떡)가 눌렸을 때

                if (menu3_count == 3){                            //위와 동일
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    menu3_count++;
                    finalOrder();
                }
                break;

            case R.id.jeolpyeon_mainbtn:                          //4번 메뉴(절편)가 눌렸을 때

                if (menu4_count == 3){
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    menu4_count++;
                    finalOrder();
                }
                break;

            case R.id.waffle_btn:                                       //1번 메뉴의 햄버거 버튼이 눌렸을 때

                hamburger_btn1++;
                if (hamburger_btn1 % 2 == 1){                           //햄버거 버튼의 눌린 횟수가 홀수일 때
                    waffle_hidden.setVisibility(View.VISIBLE);          //숨겨진 레이아웃 1번 활성화
                }
                else {
                    waffle_hidden.setVisibility(View.GONE);             //짝수일 경우 비활성화
                }
                break;

            case R.id.jjondeugi_btn:                                    //2번 메뉴의 햄버거 버튼이 눌렸을 때

                hamburger_btn2++;
                if (hamburger_btn2 % 2 == 1){                           //햄버거 버튼의 눌린 횟수가 홀수일 때
                    jjondeugi_hidden.setVisibility(View.VISIBLE);       //숨겨진 레이아웃 2번 활성화
                }
                else{
                    jjondeugi_hidden.setVisibility(View.GONE);          //짝수일 경우 비활성화
                }
                break;

            case R.id.jangiji_btn:                                      //3번 메뉴의 햄버거 버튼이 눌렸을 때

                hamburger_btn3++;
                if (hamburger_btn3 % 2 == 1){                           //햄버거 버튼의 눌린 횟수가 홀수일 때
                    jangiji_hidden.setVisibility(View.VISIBLE);         //숨겨진 레이아웃 3번 활성화
                }
                else{
                    jangiji_hidden.setVisibility(View.GONE);            //짝수일 경우 비활성화
                }
                break;

            case R.id.jeolpyeon_btn:                                    //4번 메뉴의 햄버거 버튼이 눌렸을 때

                hamburger_btn4++;
                if (hamburger_btn4 % 2 == 1){                           //햄버거 버튼의 눌린 횟수가 홀수일 때
                    jeolpyeon_hidden.setVisibility(View.VISIBLE);       //숨겨진 레이아웃 4번 활성화
                    scroll.post(new Runnable() {
                        @Override
                        public void run() {
                            scroll.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                }
                else{
                    jeolpyeon_hidden.setVisibility(View.GONE);          //짝수일 경우 비활성화
                }
                break;

            case R.id.choice_btn:                                       //주문 완료 버튼이 눌렸을 때
                if (orderCount == 0) {
                    //선택된 메뉴가 없다면 토스트 메세지 출력
                    Toast.makeText(getApplicationContext(),"메뉴를 선택해주세요!", Toast.LENGTH_SHORT).show();

                }
                else {
                    //정상 작동
                    Intent intent = new Intent(menuchoice.this,order.class);
                    startActivity(intent);
                }
        }

    }


}



