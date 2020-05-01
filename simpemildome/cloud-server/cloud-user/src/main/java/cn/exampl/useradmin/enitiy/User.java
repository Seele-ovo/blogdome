package cn.exampl.useradmin.enitiy;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String userEmail;
    private String poho;
    private String rigData;
    private String userCol;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPoho() {
        return poho;
    }

    public void setPoho(String poho) {
        this.poho = poho;
    }

    public String getRigData() {
        return rigData;
    }

    public void setRigData(String rigData) {
        this.rigData = rigData;
    }

    public String getUserCol() {
        return userCol;
    }

    public void setUserCol(String userCol) {
        this.userCol = userCol;
    }

    public User() {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }
}
