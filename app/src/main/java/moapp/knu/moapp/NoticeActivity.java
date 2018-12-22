package moapp.knu.moapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NoticeActivity extends AppCompatActivity {
//강아지 정보 알림
    private  DBHelper dbHelper;
  /*
    static final String TAG_d = "sangmin alarm_info";
    Illnese Corona = new Illnese("코로나 바이러스",1);
    Illnese kennel = new Illnese("켄넬코프",1);
    Illnese Dirofilaria = new Illnese("심장사상충",0);
    Illnese rabies = new Illnese("광견병",1);
    Illnese influenza = new Illnese("인플루엔자",0);
    Illnese DHPPL = new Illnese("종합백신",1);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        getWindow().setWindowAnimations(0);



    }
    public void on_click1(View v)
    {
        Log.d("asdfasdf","adfklajfklajfklawjfklawjefklasjkfl");
        Log.d("asdfasdf","adfklajfklajfklawjfklawjefklasjkfl");
        Intent intent1 = new Intent(this, Click1.class);
        Log.d("asdfasdf","adfklajfklajfklawjfklawjefklasjkfl");
        Log.d("asdfasdf","adfklajfklajfklawjfklawjefklasjkfl");
        Log.d("asdfasdf","adfklajfklajfklawjfklawjefklasjkfl");
      //  startActivity(intent1);
        setContentView(R.layout.activity_click1);
    }



    public void on_click3(View v)
    {

        Intent intent1 = new Intent(this, Click3.class);
        startActivity(intent1);
    }


    public void careClick(View v){
        Intent intent1 = new Intent(this, CareActivity.class);
        startActivity(intent1);
    }
    public void hospitalClick(View v){
        Intent intent1 = new Intent(this, HospitalActivity.class);
        startActivity(intent1);
    }
    public void infoClick(View v){
        Intent intent1 = new Intent(this, InfoActivity.class);
        startActivity(intent1);
    }
    public void noticeClick(View v){
        Intent intent1 = new Intent(this, NoticeActivity.class);
        startActivity(intent1);
    }
    public void boardClick(View v){
        Intent intent1 = new Intent(this, BoardActivity.class);
        startActivity(intent1);
    }

    public void mainClick(View v){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
