package cloud.kai.com.kaicloud.com.kaicloud.db.bean;

/**
 * Created by Administrator on 2015/10/20.
 */
public class LoginBean {
    private int id;
    private String username;
    private String password;
    private String token;
    private String systemid;
    private String createtime=String.valueOf(System.currentTimeMillis()/1000);
    private String alerttime=String.valueOf(System.currentTimeMillis()/1000);
    private boolean isautologin;//是否自动登录

    public boolean isautologin() {
        return isautologin;
    }

    public void setIsautologin(boolean isautologin) {
        this.isautologin = isautologin;
    }

    public String getAlerttime() {
        return alerttime;
    }

    public void setAlerttime(String alerttime) {
        this.alerttime = alerttime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
