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

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase illdb){
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE IF NOT EXISTS illnese(");
        sb.append("ill_name TEXT PRIMARY KEY, ");
        sb.append("mandatory INTERGER UNIQUE, ");
        sb.append("vaccin INTEGER DEFAULT 0, ");
        sb.append("vaccin_date TEXT, ");
        sb.append("next_date TEXT default '9999-12-31')");
        illdb.execSQL(sb.toString());
        Toast.makeText(context,sb.toString(),Toast.LENGTH_LONG).show();

    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "버전이 올라갔습니다.", Toast.LENGTH_SHORT).show();
    }

    public void testDB(){
        SQLiteDatabase illdb = getReadableDatabase();
    }

    public void addIllnese(Illnese illnese){
        Log.d(TAG_d,"addIllnese"+illnese.getName());
        SQLiteDatabase illdb = getWritableDatabase();

        String sql = new String();
        sql = "INSERT OR REPLACE INTO illnese (ill_name, mandatory) VALUES (" + "'"+illnese.getName()+"'"+","+illnese.getMandatory()+");";
        Toast.makeText(context,sql,Toast.LENGTH_LONG).show();
        Cursor cursor = illdb.rawQuery(sql,null);
        cursor.close();
        illdb.execSQL(sql);
        //Toast.makeText(context,illnese.getName()+" Insert 완료",Toast.LENGTH_SHORT).show();
    }
}
