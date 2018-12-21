package moapp.knu.moapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BoardActivity extends AppCompatActivity {
    //게시판 보기
    private static String rssUrl = "http://feed43.com/2224587846006737.xml";
    static final String TAG = "sangmin_board";
    ProgressDialog progressDialog;
    Handler handler = new Handler();
    RSSListView list;
    RSSListAdapter adapter;
    ArrayList<RSSNewsItem> newsItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        getWindow().setWindowAnimations(0);

        // create a ListView instance
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        list = new RSSListView(this);
        adapter = new RSSListAdapter(this);
        list.setAdapter(adapter);
        Log.d(TAG,"setAdapter");
        list.setOnDataSelectionListener(new OnDataSelectionListener() {
            public void onDataSelected(AdapterView parent, View v, int position, long id) {
                Log.d(TAG,"onDataSelected"+position+" id= "+id);
                RSSNewsItem curItem = (RSSNewsItem) adapter.getItem(position);
                String curTitle = curItem.getTitle();

                Toast.makeText(getApplicationContext(), "Selected : " + curTitle, Toast.LENGTH_LONG).show();
            }
        });
        Log.d(TAG,"setOnDataSelectionListener finish");
        newsItemList = new ArrayList<RSSNewsItem>();

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        mainLayout.addView(list, params);
        showRSS(rssUrl);


    }

    private void showRSS(String urlStr) {
        try {
            progressDialog = ProgressDialog.show(this, "RSS Refresh", "RSS 정보 업데이트 중...", true, true);

            RefreshThread thread = new RefreshThread(urlStr);
            thread.start();

        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }
    }

    class RefreshThread extends Thread {
        String urlStr;

        public RefreshThread(String str) {
            Log.d(TAG,"thread refresh");
            urlStr = str;
        }

        public void run() {

            try {
                Log.d(TAG,"thread run");

                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Log.d(TAG,"here1");
                URL urlForHttp = new URL(urlStr);
                Log.d(TAG,"here2");
                InputStream instream = getInputStreamUsingHTTP(urlForHttp);
                Log.d(TAG,"thread getInputStreamUsingHTTP");
                Document document = builder.parse(instream);
                Log.d(TAG,"thread builder.parse");
                int countItem = processDocument(document);
                Log.d(TAG, countItem + " news item processed.");

                // post for the display of fetched RSS info.
                handler.post(updateRSSRunnable);
                Log.d(TAG, "hander.post.");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public InputStream getInputStreamUsingHTTP(URL url)
            throws Exception {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        int resCode = conn.getResponseCode();
        Log.d(TAG, "Response Code : " + resCode);

        InputStream instream = conn.getInputStream();

        return instream;
    }

    /**
     * process DOM document for RSS
     *
     * @param doc
     */
    private int processDocument(Document doc) {
        newsItemList.clear();

        Element docEle = doc.getDocumentElement();
        NodeList nodelist = docEle.getElementsByTagName("item");
        int count = 0;
        if ((nodelist != null) && (nodelist.getLength() > 0)) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                RSSNewsItem newsItem = dissectNode(nodelist, i);
                if (newsItem != null) {
                    newsItemList.add(newsItem);
                    count++;
                }
            }
        }

        return count;
    }

    private RSSNewsItem dissectNode(NodeList nodelist, int index) {
        RSSNewsItem newsItem = null;
        Log.d(TAG,"dissectNode");
        try {
            Element entry = (Element) nodelist.item(index);
            Log.d(TAG,"index");
            Element title = (Element) entry.getElementsByTagName("title").item(0);
            Log.d(TAG,"title");
            Element link = (Element) entry.getElementsByTagName("link").item(0);
            Log.d(TAG,"link");


            String titleValue = null;
            if (title != null) {
                Node firstChild = title.getFirstChild();
                if (firstChild != null) {
                    titleValue = firstChild.getNodeValue();
                }
            }
            String linkValue = null;
            if (link != null) {
                Node firstChild = link.getFirstChild();
                if (firstChild != null) {
                    linkValue = firstChild.getNodeValue();
                }
            }





            Log.d(TAG, "item node : " + titleValue + ", " + linkValue);

            newsItem = new RSSNewsItem(titleValue, linkValue);

        } catch (DOMException e) {
            e.printStackTrace();
        }

        return newsItem;
    }


    Runnable updateRSSRunnable = new Runnable() {
        public void run() {

            try {

                Resources res = getResources();
                Drawable rssIcon = res.getDrawable(R.drawable.board);
                for (int i = 0; i < newsItemList.size(); i++) {
                    RSSNewsItem newsItem = (RSSNewsItem) newsItemList.get(i);
                    newsItem.setIcon(rssIcon);
                    adapter.addItem(newsItem);
                }

                adapter.notifyDataSetChanged();

                progressDialog.dismiss();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    };



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



