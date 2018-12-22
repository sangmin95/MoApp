package moapp.knu.moapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//여기서부터

public class CareActivity extends AppCompatActivity {
    //강아지 케어 서비스
    static final String TAG_d = "sangmin main";
    Button ButtonVoice, ButtonFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        getWindow().setWindowAnimations(0);


    }

    public void foodClick(View v){
        String command = "food";
        MyClientTask myClientTask = new MyClientTask("218.157.242.96",1234,command);
        Log.d(TAG_d,"food action");
        myClientTask.execute();
    }

    public void voiceClick(View v){
        String command = "voice";
        MyClientTask myClientTask = new MyClientTask("218.157.242.96",1234,command);
        Log.d(TAG_d,"voice action");
        myClientTask.execute();
    }

    public class MyClientTask extends AsyncTask<Void, Void, Void>{
        String dstAddress;
        int dstPort;
        String response = "";
        String myMessage = "";

        MyClientTask(String addr, int port, String message){
            dstAddress = addr;
            dstPort = port;
            myMessage = message;
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.d(TAG_d,"food doInBackground");

            Socket socket = null;
            myMessage = myMessage.toString();
            System.out.println(myMessage);
            try {
                socket = new Socket(dstAddress, dstPort);
                //송신
                OutputStream out = socket.getOutputStream();
                out.write(myMessage.getBytes());

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            }finally{
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;

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

    public void streamingClick(View v){
        Intent intent1 = new Intent(this, StreamingActivity.class);
        startActivity(intent1);
    }
}