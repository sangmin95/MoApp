package moapp.knu.moapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Click5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click5);
        getWindow().setWindowAnimations(0);
    }

    public void on_register(View v)
    {
        deleteDatabase("mypet.db");
        SQLiteDatabase db;
        db = openOrCreateDatabase( "mypet.db",SQLiteDatabase.CREATE_IF_NECESSARY,null );
        String table = "mypet";
        db.execSQL("create table if not exists " +table+ "("
                + "_id integer primary key AUTOINCREMENT,"
                + "name text,"
                + "age text,"
                + "kg text,"
                + "simsang text,"
                + " gisang text,"
                + " goanggun text,"
                + "sex text);");
        EditText edt = (EditText)findViewById(R.id.edt2);
        EditText edt1= (EditText)findViewById(R.id.edt4);
        EditText edt2= (EditText)findViewById(R.id.edt5);
        EditText edt3= (EditText)findViewById(R.id.edt6);
        EditText edt4= (EditText)findViewById(R.id.edt7);
        EditText edt5= (EditText)findViewById(R.id.edt8);
        EditText edt6= (EditText)findViewById(R.id.edt9);
        String s1 = edt.getText().toString();
        String s2 = edt1.getText().toString();
        String s3 = edt2.getText().toString();
        String s4 = edt3.getText().toString();
        String s5 = edt4.getText().toString();
        String s6 = edt5.getText().toString();
        String s7 = edt6.getText().toString();
        Log.d("asdfasdfsd","asdfsadf");
        String sql = "insert into mypet (name, age, kg, simsang, gisang, goanggun, sex) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"');";

        db.execSQL(sql);
        Toast.makeText(this,"강아지 등록이 완료되었습니다",Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(this,NoticeActivity.class);
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
