package com.agan.breakingnews.Bean;

/**
 * Created by elso on 17-3-24.
 * 新闻实体类
 */

public class News{

    private int id;
    private String newsTitle;
    private String newsTime;
    private String newsPic;
    private String newsDetail;
    private int newsKindId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public int getNewsKindId() {
        return newsKindId;
    }

    public void setNewsKindId(int newsKindId) {
        this.newsKindId = newsKindId;
    }
}
