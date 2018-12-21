package moapp.knu.moapp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;


public class RSSListView extends ListView {

    /**
     * DataAdapter for this instance
     */
    private RSSListAdapter adapter;

    /**
     * Listener for data selection
     */
    private OnDataSelectionListener selectionListener;

    public RSSListView(Context context) {
        super(context);

        init();
    }

    public RSSListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    /**
     * set initial properties
     */
    private void init() {
        // set OnItemClickListener for processing OnDataSelectionListener
        Log.d("click","init");
        setOnItemClickListener(new OnItemClickAdapter());
    }

    /**
     * set DataAdapter
     *
     * @param adapter
     */
    public void setAdapter(BaseAdapter adapter) {
        Log.d("click","setAdapter");
        super.setAdapter(adapter);

    }

    /**
     * get DataAdapter
     *
     * @return
     */
    public BaseAdapter getAdapter() {
        Log.d("click","getAdapter");
        return (BaseAdapter)super.getAdapter();
    }

    /**
     * set OnDataSelectionListener
     *
     * @param listener
     */
    public void setOnDataSelectionListener(OnDataSelectionListener listener) {
        Log.d("click","setOnDataSelectionListener");
        this.selectionListener = listener;
    }

    /**
     * get OnDataSelectionListener
     *
     * @return
     */
    public OnDataSelectionListener getOnDataSelectionListener() {
        Log.d("click","OnDataSelectionListener");
        return selectionListener;
    }

    class OnItemClickAdapter implements OnItemClickListener {

        public OnItemClickAdapter() {

        }

        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Log.d("click","onItemClick");

            if (selectionListener == null) {
                Log.d("click","selectionListener == null");
                return;
            }

            // get row and column
            int rowIndex = -1;
            int columnIndex = -1;

            // call the OnDataSelectionListener method
            selectionListener.onDataSelected(parent, v, position, id);

        }

    }

}