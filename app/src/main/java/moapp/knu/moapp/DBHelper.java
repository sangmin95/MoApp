package moapp.knu.moapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    public static String TAG_d = "sangmin DBHelper";
    public final String TABLE_ILL = "CREATE TABLE IF NOT EXISTS illnese(ill_name TEXT PRIMARY KEY,mandatory INTERGER UNIQUE,vaccin INTEGER DEFAULT 0,vaccin_date TEXT,next_date TEXT default '9999-12-31');";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        dbCreate(db,TABLE_ILL);
    }

    public void dbCreate(SQLiteDatabase db, String create_sql){
        db.execSQL(create_sql);
        Toast.makeText(context,create_sql,Toast.LENGTH_LONG).show();
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "버전이 올라갔습니다.", Toast.LENGTH_SHORT).show();
    }

    public void testDB(){
        SQLiteDatabase db = getReadableDatabase();
    }

    public void addIllnese(Illnese illnese){
        Log.d(TAG_d,"addIllnese"+illnese.getName());
        SQLiteDatabase db = getWritableDatabase();

        String sql = new String();
        sql = "INSERT OR REPLACE INTO illnese (ill_name, mandatory) VALUES (" + "'"+illnese.getName()+"'"+","+illnese.getMandatory()+");";
        Toast.makeText(context,sql,Toast.LENGTH_LONG).show();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.close();
        db.execSQL(sql);
        //Toast.makeText(context,illnese.getName()+" Insert 완료",Toast.LENGTH_SHORT).show();
    }

    public void deleteIllnese(String ill_name){
        Log.d(TAG_d,"deleteIllnese"+ill_name);
        SQLiteDatabase db = getWritableDatabase();

        String sql = new String();
        sql = "DELETE FROM illnese where ill_name = "+ ill_name;
        Toast.makeText(context,sql,Toast.LENGTH_LONG).show();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.close();
        db.execSQL(sql);
    }
}
