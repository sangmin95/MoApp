package moapp.knu.moapp;


import android.graphics.drawable.Drawable;

public class RSSNewsItem {

    private String title;
    private String link;

    private Drawable mIcon;

    /**
     * Initialize with icon and data array
     */
    public RSSNewsItem() {
    }

    /**
     * Initialize with icon and strings
     */
    public RSSNewsItem(String title, String link) {
        this.title = title;
        this.link = link;
    }

    /**
     * Set icon
     *
     * @param icon
     */
    public void setIcon(Drawable icon) {
        mIcon = icon;
    }

    /**
     * Get icon
     *
     * @return
     */
    public Drawable getIcon() {
        return mIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    /**
     * Compare with the input object
     *
     * @param other
     * @return
     */
    public int compareTo(RSSNewsItem other) {
        if (title.equals(other.getTitle())) {
            return -1;
        } else if (link.equals(other.getLink())) {
            return -1;
        }
        return 0;
    }

}
