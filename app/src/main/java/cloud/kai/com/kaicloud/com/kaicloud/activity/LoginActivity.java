package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cloud.kai.com.kaicloud.R;

/**
 * login
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private ActionBar actionBar;
    private TextView RegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();

    }

    private void initView() {
        RegisterTextView = (TextView) findViewById(R.id.register_tv);
    }

    private void initData() {
        actionBar = getActionBar();
        if (actionBar != null) {
            //  actionBar.setDisplayShowHomeEnabled(false);
        }
        //dashedLine.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        RegisterTextView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.register_tv:
                 Intent intent=new Intent(LoginActivity.this,RegsterActivity.class);
                 startActivity(intent);
                 break;

         }
    }
}
