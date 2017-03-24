package com.agan.breakingnews.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elso on 17-3-24.
 * 新闻实体类
 */

public class News{

    private String newsTitle;
    private String newsTime;
    private String newsPic;


    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsPic() {
        return newsPic;
    }

    public void setNewsPic(String newsPic) {
        this.newsPic = newsPic;
    }

//    private News(Parcel in) {
//        newsTitle = in.readString();
//        newsTime = in.readString();
//        newsPic = in.readString();
//    }
//
//    public static final Creator<News> CREATOR = new Creator<News>() {
//        @Override
//        public News createFromParcel(Parcel in) {
//            return new News(in);
//        }
//
//        @Override
//        public News[] newArray(int size) {
//            return new News[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(newsTitle);
//        dest.writeString(newsTime);
//        dest.writeString(newsPic);
//    }

}
