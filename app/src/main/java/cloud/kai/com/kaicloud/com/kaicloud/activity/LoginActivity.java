package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cloud.kai.com.kaicloud.R;
import cloud.kai.com.kaicloud.com.kaicloud.utils.L;
import cloud.kai.com.kaicloud.com.kaicloud.utils.PasswordUtils;
import cloud.kai.com.kaicloud.com.kaicloud.utils.T;
import cloud.kai.com.kaicloud.com.kaicloud.utils.TelUtils;

/**
 * login
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private ActionBar actionBar;
    private TextView RegisterTextView;
    private ImageView eyeimg;
    private boolean eyeoff = true;
    private EditText password;
    private TextView loginButton;
    private EditText username;
    private String usernameStr;
    private String passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();

    }

    private void initView() {
        RegisterTextView = (TextView) findViewById(R.id.register_tv);
        eyeimg = (ImageView) findViewById(R.id.password_logoid2);
        username = (EditText) findViewById(R.id.telphone);
        password = (EditText) findViewById(R.id.password);
        loginButton = (TextView) findViewById(R.id.login_button);
    }

    private void initData() {
        actionBar = getActionBar();
        if (actionBar != null) {
            //  actionBar.setDisplayShowHomeEnabled(false);
        }
        //dashedLine.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        RegisterTextView.setOnClickListener(this);
        eyeimg.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击注册
            case R.id.register_tv:
                Intent intent = new Intent(LoginActivity.this, RegsterActivity.class);
                startActivity(intent);
                break;
            //密码可见切换
            case R.id.password_logoid2:
                if (eyeoff) {
                    eyeimg.setImageResource(R.mipmap.but_eye_on);
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                    eyeoff = false;
                } else {
                    eyeimg.setImageResource(R.mipmap.but_eye_off);
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eyeoff = true;
                }
                break;
                //点击登录
            case R.id.login_button:
                usernameStr = username.getText().toString().trim();
                passwordStr = password.getText().toString().trim();
                //检测用户名和密码的有效性
               if(checkEffective()){
                   //提交到服务器校验
                   L.i("提交账户密码到服务器校验登录");
                   postService();
               }
                break;

        }
    }

    /**
     * 提交到服务器校验
     */
    private void postService() {

    }

    /**
     * //检测用户名和密码的有效性
     */
    private boolean checkEffective() {
        if (usernameStr == null ||  usernameStr.length()==0){
            T.showShort(getApplicationContext(), R.string.username_null);
            return false;
        }if( !TelUtils.isMobileNO(usernameStr)){
            T.showShort(getApplicationContext(), R.string.username_err);
            return false;
        }
        if(passwordStr==null ||  passwordStr.length()==0 || passwordStr.length()<8 || passwordStr.length()>16){
            T.showShort(getApplicationContext(), R.string.password_length_err);
            return false;
        }
        if(!PasswordUtils.isEffectivePassword(passwordStr)){
            T.showShort(getApplicationContext(), R.string.password_err);
            return false;
        }
        return  true;
    }
}
