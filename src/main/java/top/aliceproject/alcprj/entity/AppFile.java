package top.aliceproject.alcprj.entity;

public class AppFile {
    private String fileId;
    private String fileName;
    private String filePath;
    private String fileImg;
    private Boolean show;

    public String getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileImg() {
        return fileImg;
    }

    public Boolean getShow() {
        return show;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileImg(String fileImg) {
        this.fileImg = fileImg;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }


}
