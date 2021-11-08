package top.aliceproject.alcprj.entity;

import java.io.Serializable;

public class AppUrl implements Serializable {
    private String urlId;
    private String urlName;
    private String urlPath;
    private String urlImg;
    private Boolean show;

    public String getUrlId() {
        return urlId;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public Boolean getShow() {
        return show;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
