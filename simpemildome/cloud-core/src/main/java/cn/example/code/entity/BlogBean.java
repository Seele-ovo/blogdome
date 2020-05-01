package cn.example.code.entity;

public class BlogBean implements Comparable<BlogBean>{
    private int id;//id
    private String title;//标题
    private String date;//发布时间
    private int read;//阅读量
    private String content;//具体内容
    private String smple;//简介

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSmple() {
        return smple;
    }

    public void setSmple(String smple) {
        this.smple = smple;
    }

    @Override
    public String toString() {
        return "BlogBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", smple='" + smple + '\'' +
                '}';
    }

    @Override
    public int compareTo(BlogBean o) {
        return this.id - o.getId();
    }
}
