package com.example.what_the_ffle0505;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity implements View.OnClickListener {

    //menuChoice 클래스에서 선택된 숫자만큼 각 메뉴 변수에 저장
    public int menu1_Amount = menuchoice.menu1_count;
    public int menu2_Amount = menuchoice.menu2_count;
    public int menu3_Amount = menuchoice.menu3_count;
    public int menu4_Amount = menuchoice.menu4_count;

    //order 메뉴에서 눌린 수치 확인을 위한 textView 선언
    public TextView menu1_textAmount;
    public TextView menu2_textAmount;
    public TextView menu3_textAmount;
    public TextView menu4_textAmount;

    //각 메뉴들이 담겨있는 레이아웃 선언
    public RelativeLayout menu1_layout;
    public RelativeLayout menu2_layout;
    public RelativeLayout menu3_layout;
    public RelativeLayout menu4_layout;

    //블루투스 통신을 위한 변수 선언
    public int bluetoothCount = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order);

        // TextView와 RelativeLayout을 id와 일치시키기
        menu1_textAmount = findViewById(R.id.menu1_textAmount);
        menu2_textAmount = findViewById(R.id.menu2_textAmount);
        menu3_textAmount = findViewById(R.id.menu3_textAmount);
        menu4_textAmount = findViewById(R.id.menu4_textAmount);

        menu1_layout = findViewById(R.id.waffle_order_hidden);
        menu2_layout = findViewById(R.id.jjondeugi_order_hidden);
        menu3_layout = findViewById(R.id.jangiji_order_hidden);
        menu4_layout = findViewById(R.id.jeolpyeon_order_hidden);

        //버튼들 이벤트 리스너 달기
        findViewById(R.id.orderComplete).setOnClickListener(this);

        findViewById(R.id.waffle_order_hidden_minus).setOnClickListener(this);
        findViewById(R.id.waffle_order_hidden_plus).setOnClickListener(this);

        findViewById(R.id.jjondeugi_order_hidden_minus).setOnClickListener(this);
        findViewById(R.id.jjondeugi_order_hidden_plus).setOnClickListener(this);

        findViewById(R.id.jangiji_order_hidden_minus).setOnClickListener(this);
        findViewById(R.id.jangiji_order_hidden_plus).setOnClickListener(this);

        findViewById(R.id.jeolpyeon_order_hidden_plus).setOnClickListener(this);
        findViewById(R.id.jeolpyeon_order_hidden_minus).setOnClickListener(this);

        if (menu1_Amount >= 1){
            //메뉴 1번이 한개라도 선택이 되어 있다면 레이아웃 활성화
            menu1_layout.setVisibility(View.VISIBLE);
            menu1_textAmount.setText(Integer.toString(menu1_Amount));
        }

        if (menu2_Amount >= 1){
            //메뉴 2번이 한개라도 선택이 되어 있다면 레이아웃 활성화
            menu2_layout.setVisibility(View.VISIBLE);
            menu2_textAmount.setText(Integer.toString(menu2_Amount));
        }

        if (menu3_Amount >= 1){
            //메뉴 3번이 한개라도 선택이 되어 있다면 레이아웃 활성화
            menu3_layout.setVisibility(View.VISIBLE);
            menu3_textAmount.setText(Integer.toString(menu3_Amount));
        }

        if (menu4_Amount >= 1){
            //메뉴 4번이 한개라도 선택이 되어 있다면 레이아웃 활성화
            menu4_layout.setVisibility(View.VISIBLE);
            menu4_textAmount.setText(Integer.toString(menu4_Amount));
        }
    }

    @Override
    public void onClick(View v) {                      //리스너를 달은 버튼들 이벤트 달기
        switch (v.getId()) {

            case R.id.waffle_order_hidden_minus:       //1번 메뉴 수량 감소 버튼이 눌렸을 때
                if (menu1_Amount == 1) {
                    //1(최소수량)일때 토스트 메세지만 띄우기
                    Toast.makeText(this, "최소 수량은 1개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    //나머지 경우 정상 작동
                    menuchoice.menu1_count = --menu1_Amount;

                    //Back Button이 눌렸을 경우 menuchoice 하단의 "주문완료()" 정보와 현재 정보를 일치시키기 위함
                    menuchoice.finalOrder();
                    menu1_textAmount.setText(Integer.toString(menu1_Amount));
                }
                break;

            case R.id.waffle_order_hidden_plus:       //1번 메뉴 수량 증가 버튼이 눌렸을 때
                if (menu1_Amount == 3) {
                    //9(최대수량)일때 토스트 메세지만 띄우기
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    //나머지 경우 정상 작동
                    menuchoice.menu1_count = ++menu1_Amount;

                    //Back Button이 눌렸을 경우 menuchoice 하단의 "주문완료()" 정보와 현재 정보를 일치시키기 위함
                    menuchoice.finalOrder();
                    menu1_textAmount.setText(Integer.toString(menu1_Amount));
                }
                break;

            case R.id.jjondeugi_order_hidden_minus:       //2번 메뉴 수량 감소 버튼이 눌렸을 때
                if (menu2_Amount == 1) {
                    Toast.makeText(this, "최소 수량은 1개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu2_count = --menu2_Amount;
                    menuchoice.finalOrder();
                    menu2_textAmount.setText(Integer.toString(menu2_Amount));
                }
                break;

            case R.id.jjondeugi_order_hidden_plus:       //2번 메뉴 수량 증가 버튼이 눌렸을 때
                if (menu2_Amount == 3) {
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu2_count = ++menu2_Amount;
                    menuchoice.finalOrder();
                    menu2_textAmount.setText(Integer.toString(menu2_Amount));
                }
                break;

            case R.id.jangiji_order_hidden_minus:          //3번 메뉴 수량 감소 버튼이 눌렸을 때
                if (menu3_Amount == 1) {
                    Toast.makeText(this, "최소 수량은 1개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu3_count = --menu3_Amount;
                    menuchoice.finalOrder();
                    menu3_textAmount.setText(Integer.toString(menu3_Amount));
                }
                break;

            case R.id.jangiji_order_hidden_plus:           //3번 메뉴 수량 증가 버튼이 눌렸을 때
                if (menu3_Amount == 3) {
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu3_count = ++menu3_Amount;
                    menuchoice.finalOrder();
                    menu3_textAmount.setText(Integer.toString(menu3_Amount));
                }
                break;

            case R.id.jeolpyeon_order_hidden_minus:          //4번 메뉴 수량 감소 버튼이 눌렸을 때
                if (menu4_Amount == 1) {
                    Toast.makeText(this, "최소 수량은 1개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu4_count = --menu4_Amount;
                    menuchoice.finalOrder();
                    menu4_textAmount.setText(Integer.toString(menu4_Amount));
                }
                break;

            case R.id.jeolpyeon_order_hidden_plus:          //4번 메뉴 수량 증가 버튼이 눌렸을 때
                if (menu4_Amount == 3) {
                    Toast.makeText(this, "최대 수량은 3개입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    menuchoice.menu4_count = ++menu4_Amount;
                    menuchoice.finalOrder();
                    menu4_textAmount.setText(Integer.toString(menu4_Amount));
                }
                break;

            case R.id.orderComplete:
                //ex) 1번메뉴 1개, 2번메뉴 3개, 3번메뉴 0개, 4번메뉴 2개일때 1302를 변수 안에 대입
                bluetoothCount = (menu1_Amount * 1000) + (menu2_Amount * 100) + (menu3_Amount * 10) + (menu4_Amount);
                Toast.makeText(this, "와플을 조리중입니다", Toast.LENGTH_LONG).show();           //Toast 메세지 전송
                MainActivity.bt.send(Integer.toString(bluetoothCount),true);                        //블루투스로 bluetoothCount 변수 전송

                //menuchoice 클래스의 숫자들 초기화
                menuchoice.menu1_count = 0;
                menuchoice.menu2_count = 0;
                menuchoice.menu3_count = 0;
                menuchoice.menu4_count = 0;
                menuchoice.finalOrder();
                finish();
        }
    }
}
