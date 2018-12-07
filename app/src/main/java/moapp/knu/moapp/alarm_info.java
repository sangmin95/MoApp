package moapp.knu.moapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class alarm_info extends AppCompatActivity {

    private  DBHelper dbHelper;
    static final String TAG_d = "sangmin alarm_info";
    Illnese Corona = new Illnese("코로나 바이러스",1);
    Illnese kennel = new Illnese("켄넬코프",1);
    Illnese Dirofilaria = new Illnese("심장사상충",0);
    Illnese rabies = new Illnese("광견병",1);
    Illnese influenza = new Illnese("인플루엔자",0);
    Illnese DHPPL = new Illnese("종합백신",1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG_d,"onCreate");
        setContentView(R.layout.activity_alarm_info);
        //illdb 생성
        dbHelper = new DBHelper(alarm_info.this,"illdb",null,1);
        //dbHelper.addIllnese(Corona);
        dbHelper.addIllnese(kennel);
        dbHelper.addIllnese(Dirofilaria);
        dbHelper.addIllnese(rabies);
        dbHelper.addIllnese(influenza);
        dbHelper.addIllnese(DHPPL);
        dbHelper.testDB();
    }
}
