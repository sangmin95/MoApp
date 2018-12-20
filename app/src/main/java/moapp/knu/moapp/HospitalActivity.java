package moapp.knu.moapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class HospitalActivity extends AppCompatActivity {


    SQLiteDatabase db;
    String[] v1;
    String[] v2;
    String[] v3;
    Cursor c;
    Cursor c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        getWindow().setWindowAnimations(0);
        deleteDatabase("hospital.db");

        db = openOrCreateDatabase( "hospital.db",SQLiteDatabase.CREATE_IF_NECESSARY,null );

        String table = "hospital2";
        db.execSQL("create table if not exists " +table+ "("
                + "_id integer primary key AUTOINCREMENT,"
                + "name text,"
                + "phone text,"
                + "address text,"
                + "allnight text);");

        makeDB();


        setlist();

    }
    public void makeDB(){


        Workbook workbook = null;
        Sheet sheet;

        try {

            InputStream inputStream = getBaseContext().getResources().getAssets().open("hospital.xls");
            workbook = Workbook.getWorkbook(inputStream);

            sheet = workbook.getSheet(0);

            int MaxColumn = 2, RowStart = 0, RowEnd = sheet.getColumn(MaxColumn - 1).length -1, ColumnStart = 0, ColumnEnd = sheet.getRow(2).length - 1;
            for(int row = RowStart;row <= RowEnd;row++) {
                //String excelload = sheet.getCell(ColumnStart, row).getContents();
                String s1 = sheet.getCell(ColumnStart,row).getContents();
                String s2 = sheet.getCell(ColumnStart+1,row).getContents();
                String s3 = sheet.getCell(ColumnStart+2,row).getContents();
                String s4 = sheet.getCell(ColumnStart+3,row).getContents();
                Log.d("s1",s1);
                Log.d("s2",s2);
                Log.d("s3",s3);
                Log.d("s4",s4);

                String sql = "insert into hospital2 (name, phone, address, allnight) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"');";
                db.execSQL(sql);
                //String sql = "INSERT INTO people (name, age) VALUES (‘jeongkook', 22);";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {

            workbook.close();
        }
        if(db != null){
            // db.close();
        }


    }

    public void setlist()
    {


        c = db.rawQuery("SELECT * FROM HOSPITAL2 ;", null);

        c.moveToFirst();

        ListView listView = (ListView)findViewById(android.R.id.list);

        if(c!=null) {
            Log.d("here","adapter");
            final SimpleCursorAdapter adapter = new SimpleCursorAdapter(listView.getContext(),
                    R.layout.listlayout,
                    c,
                    new String[]{"name","phone","address"},
                    new int[]{R.id.txt1,R.id.txt2,R.id.txt3});
            Log.d("here","adapter");
            listView.setAdapter(adapter);
            Log.d("here","adapter");

        }


    }
    public void on_hour(View v)
    {
        Cursor c3 = db.rawQuery("SELECT * FROM HOSPITAL2 WHERE allnight='t' ;", null);
        c3.moveToFirst();
        ListView listView = (ListView)findViewById(android.R.id.list);
        if(c3!=null) {
            Log.d("here","adapter");
            final SimpleCursorAdapter adapter = new SimpleCursorAdapter(listView.getContext(),
                    R.layout.listlayout,
                    c3,
                    new String[]{"name","phone","address"},
                    new int[]{R.id.txt1,R.id.txt2,R.id.txt3});
            Log.d("here","adapter");
            listView.setAdapter(adapter);
            Log.d("here","adapter");

        }


    }
    public void on_search(View v)
    {
        c.close();
        EditText edt = (EditText)findViewById(R.id.edt1);
        String temp =  edt.getText().toString();

        Log.d("abc","abcd");


        // c2 = db.rawQuery("SELECT * FROM HOSPITAL2 WHERE phone like '%북구%' ;", null);
        c2 = db.rawQuery("SELECT * FROM HOSPITAL2 WHERE phone like '%"+temp+"%' ;", null);


        // c2 = db.rawQuery("SELECT * FROM HOSPITAL2 WHERE allnight='t' ;", null);
        Log.d("abc","abcd");
        c2.moveToFirst();

        Log.d("abc","abcd");
        ListView listView = (ListView)findViewById(android.R.id.list);

        Log.d("abc","abcd");
        if(c2!=null) {
            Log.d("here","adapter");
            final SimpleCursorAdapter adapter = new SimpleCursorAdapter(listView.getContext(),
                    R.layout.listlayout,
                    c2,
                    new String[]{"name","phone","address"},
                    new int[]{R.id.txt1,R.id.txt2,R.id.txt3});
            Log.d("here","adapter");
            listView.setAdapter(adapter);
            Log.d("here","adapter");

        }



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
