package moapp.knu.moapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    Button btnMoveillness;
    static final String TAG_d = "sangmin main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_d,"onCreate");
        btnMoveillness  = (Button)findViewById(R.id.button_illnese);

        btnMoveillness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        getApplicationContext(),
                        alarm_info.class);
                startActivity(intent);
            }
        });
    }
}
