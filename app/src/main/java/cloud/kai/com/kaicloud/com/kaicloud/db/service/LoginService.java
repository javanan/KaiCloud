package cloud.kai.com.kaicloud.com.kaicloud.db.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import cloud.kai.com.kaicloud.com.kaicloud.db.bean.LoginBean;
import cloud.kai.com.kaicloud.com.kaicloud.utils.L;

/**
 * Created by Administrator on 2015/10/20.
 */
public class LoginService extends BaseService<LoginBean> {

    public LoginService(Context context) {
        super(context);
    }


    /**
     * 登录插入一条登录账户信息
     *
     * @param loginBean
     * @return 失败返回-1
     */
    public long register(LoginBean loginBean) {
        ContentValues values = new ContentValues();
        values.put("username", loginBean.getUsername());
        values.put("password", loginBean.getPassword());
        values.put("token", loginBean.getToken());
        values.put("systemid", loginBean.getSystemid());
        values.put("createtime", loginBean.getCreatetime());
        values.put("alerttime", loginBean.getAlerttime());
        long ret=save("login", values);
        close();
        return ret;
    }

    /**
     * 登录，从数据库中获取上次登录的账户密码
     * @return
     */
    public LoginBean login() {
        Cursor cursor = select("login", new String[]{"username", "password", "token", "systemid"}, "isautologin=?", new String[]{"true"}, null, null, "alerttime DESC");
        LoginBean login = null;
        if (cursor.moveToFirst()) {
            login=new LoginBean();
            login.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            login.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            login.setToken(cursor.getString(cursor.getColumnIndex("token")));
            login.setSystemid(cursor.getString(cursor.getColumnIndex("systemid")));
            cursor.close();
            //更新登录时间
            L.i("更新登录时间");
            ContentValues updateValues=new ContentValues();
            updateValues.put("alerttime", String.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
            update("login", updateValues, "username=?", new String[]{login.getUsername()});

        }
        if(cursor!=null){
            cursor.close();
        }
        close();
        return login;
    }
}
