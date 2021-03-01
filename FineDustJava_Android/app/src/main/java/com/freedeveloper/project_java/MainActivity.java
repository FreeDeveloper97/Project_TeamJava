package com.freedeveloper.project_java;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Context context = this;
    //시간 설정 id
    TextView TextView_time;
    TextView TextView_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //현재시간 1초마다 갱신
        startTime();
        ShowTimeMethod();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.menuicon); //뒤로가기 버튼 이미지 지정
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.menu_1){
                    Toast.makeText(context, title + ": 메인화면 입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_2){
                    Toast.makeText(context, title + ": 검색화면 입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_3){
                    Toast.makeText(context, title + ": 즐겨찾기화면 입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_4){
//                    Toast.makeText(context, title + ": 실시간화면 입니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SelectDeviceActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(id == R.id.menu_5){
                    Intent intent = new Intent(MainActivity.this, TempActivity.class);
                    startActivity(intent);
                    finish();
                }

                return true;
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private long time= 0;
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-time>=2000){
            time=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"뒤로 버튼을 한번 더 누르면 종료합니다.",Toast.LENGTH_SHORT).show();
        }else if(System.currentTimeMillis()-time<2000){
            finish();
        }
    }

    //시간 갱신코드
    public void ShowTimeMethod() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //시간 설정 기능
                startTime();
            }
        };

        Runnable task = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    handler.sendEmptyMessage(1);
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void startTime() {
        TextView_day = findViewById(R.id.TextView_day);
        TextView_time = findViewById(R.id.TextView_time);
        //시간 설정 기능
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat format_Day = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat format_Time = new SimpleDateFormat("aa hh:mm:ss");
        String day = format_Day.format(date);
        String time = format_Time.format(date);
        TextView_day.setText(day);
        TextView_time.setText(time);
    }
}