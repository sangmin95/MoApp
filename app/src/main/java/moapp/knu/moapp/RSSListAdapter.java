package moapp.knu.moapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class RSSListAdapter extends BaseAdapter {

    private Context mContext;

    private List<RSSNewsItem> mItems = new ArrayList<RSSNewsItem>();

    public RSSListAdapter(Context context) {
        mContext = context;
    }

    public void addItem(RSSNewsItem it) {
        mItems.add(it);
    }

    public void setListItems(List<RSSNewsItem> lit) {
        mItems = lit;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        return true;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RSSNewsItemView itemView;
        if (convertView == null) {
            itemView = new RSSNewsItemView(mContext, mItems.get(position));
        } else {
            itemView = (RSSNewsItemView) convertView;

            itemView.setText(0, mItems.get(position).getTitle());
        }

        return itemView;
    }

}
