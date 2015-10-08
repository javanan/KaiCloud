package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import cloud.kai.com.kaicloud.R;

public class RegsterActivity extends Activity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regster);
        initView();
initData();

    }

    private void initData() {
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);

        }
    }

    private void initView() {
        actionBar = getActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return true;
    }
}
