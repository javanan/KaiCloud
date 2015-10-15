package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import cloud.kai.com.kaicloud.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class PaiFragment extends Fragment {

    public PaiFragment() {
    }

    private EditText shuoshuo;
    private TextView pai_add_pic;
    private Context context;
    private Drawable giftIcon = null;
    private Drawable addpic = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pai_fragment, container, false);
        context = inflater.getContext();
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            giftIcon = getResources().getDrawable(R.mipmap.ic_label_gift, context.getTheme());
            addpic=getResources().getDrawable(R.mipmap.bill_arrow_up, context.getTheme());
        } else {
            giftIcon = getResources().getDrawable(R.mipmap.ic_label_gift);
            addpic=getResources().getDrawable(R.mipmap.bill_arrow_up);
        }
        giftIcon.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        addpic.setBounds(0,0,40,40);
        shuoshuo.setCompoundDrawables(giftIcon, null, null, null);//只放左边
        pai_add_pic.setCompoundDrawables(addpic, null, null, null);//只放左边
    }

    private void initView(View view) {
        shuoshuo = (EditText) view.findViewById(R.id.pai_shuoshuo_edt);
        pai_add_pic=(TextView)view.findViewById(R.id.pai_add_pic);
    }
}
