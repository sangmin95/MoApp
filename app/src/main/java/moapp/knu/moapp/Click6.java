package moapp.knu.moapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Click6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click6);
        SQLiteDatabase db;
        db = openOrCreateDatabase( "mypet.db",SQLiteDatabase.CREATE_IF_NECESSARY,null );
        Cursor c3 = db.rawQuery("SELECT * FROM mypet ;", null);
        c3.moveToFirst();
        String name;
        String tempage;
        String tempkg;
        String tsimsang;
        String tgisang;
        String tgoanggun;
        String tsex;
        name=c3.getString(c3.getColumnIndex("name"));
        tempage=c3.getString(c3.getColumnIndex("age"));
        tempkg=c3.getString(c3.getColumnIndex("kg"));
        tsimsang=c3.getString(c3.getColumnIndex("simsang"));
        tgisang=c3.getString(c3.getColumnIndex("gisang"));
        tgoanggun=c3.getString(c3.getColumnIndex("goanggun"));
        tsex=c3.getString(c3.getColumnIndex("sex"));

        double kg =Integer.parseInt(tempkg)*1000*0.05;
        int age = Integer.parseInt(tempage);
        int simsang = Integer.parseInt(tsimsang);
        int gisang = Integer.parseInt(tgisang);
        int goanggun = Integer.parseInt(tgoanggun);
        String text;
        if(age < 12) {
             text = name + "의 적절 사료량은 " + kg + "g 입니다.\n단 아직 어리기 때문에 꼭 물에 불려 주세요";
        }else
        {
             text = name + "의 적절 사료량은 " + kg + "g 입니다.";
        }
        TextView txtv1 = (TextView)findViewById(R.id.ttl);
        txtv1.setText(""+text);
        TextView txtv2 = (TextView)findViewById(R.id.ttl2);

         text = name+ " 의 다음 심장사상충 예방일 : "+simsang+"\n" +name+"의 다음 외부기생충 예방일 : "+gisang+"\n"
         +name+" 의 다음 광견병 접종일 : 내년 "+goanggun+"월 입니다";
        txtv2.setText(text);

        if(age < 24 && tsex=="n") {
            text = name + "의 중성화 적정 시기가 다가옵니다. 중성화 적정 시기는 6개월입니다.";
        }else if (age >24 && tsex == "n");
        {
            text = name + "의 중성화 적정 시기가 지나갔습니다. 빨리 중성화 수술을 해 주세요";
        }
        TextView txtv3 = (TextView)findViewById(R.id.ttl3);
        txtv3.setText(text);
        long nowTime = System.currentTimeMillis();
        Date date = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("MM");
        String nowTime2 = dataFormat.format(date);
        if(nowTime2.equals("11") || nowTime2.equals("12")  || nowTime2.equals("01"))
        {
            TextView txt33 = (TextView)findViewById(R.id.ttl4);
            txt33.setText("\n지금은 "+nowTime2+"월 입니다 인플루엔져  집중 예방기간입니다. 꼭 접종해주세요");

        }
    }
}
