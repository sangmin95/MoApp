package moapp.knu.moapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Click3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click3);
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

        Log.d("abc",name+tempage+tempkg+tsimsang+tgisang+tgoanggun+tsex);

        Log.d("abc",name+tempage+tempkg+tsimsang+tgisang+tgoanggun+tsex);
        Log.d("abc",name+tempage+tempkg+tsimsang+tgisang+tgoanggun+tsex);
    }
}
