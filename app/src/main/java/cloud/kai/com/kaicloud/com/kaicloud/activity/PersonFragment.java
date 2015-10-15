package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cloud.kai.com.kaicloud.R;
import cloud.kai.com.kaicloud.com.kaicloud.utils.CircularImage;


/**
 * A placeholder fragment containing a simple view.
 */
public class PersonFragment extends Fragment {

    public PersonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.person_fragment, container, false);

        CircularImage cover_user_photo = (CircularImage)view.findViewById(R.id.head_image);
        cover_user_photo.setImageResource(R.mipmap.login_logo);
        return view;
    }
}
