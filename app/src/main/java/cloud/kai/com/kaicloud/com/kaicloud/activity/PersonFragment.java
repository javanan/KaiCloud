package cloud.kai.com.kaicloud.com.kaicloud.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cloud.kai.com.kaicloud.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class PersonFragment extends Fragment {

    public PersonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.person_fragment, container, false);
    }
}
