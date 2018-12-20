package moapp.knu.moapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getWindow().setWindowAnimations(0);
    }

    public void careClick(View v) {
        Intent intent1 = new Intent(this, CareActivity.class);
        startActivity(intent1);
    }

    public void hospitalClick(View v) {
        Intent intent1 = new Intent(this, HospitalActivity.class);
        startActivity(intent1);
    }

    public void infoClick(View v) {
        Intent intent1 = new Intent(this, InfoActivity.class);
        startActivity(intent1);
    }

    public void noticeClick(View v) {
        Intent intent1 = new Intent(this, NoticeActivity.class);
        startActivity(intent1);
    }

    public void boardClick(View v) {
        Intent intent1 = new Intent(this, BoardActivity.class);
        startActivity(intent1);
    }

    public void mainClick(View v) {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void yebang(View v)
    {
        setContentView(R.layout.activity_yebang);
    }
}