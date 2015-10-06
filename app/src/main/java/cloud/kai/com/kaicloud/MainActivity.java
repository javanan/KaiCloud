package cloud.kai.com.kaicloud;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cloud.kai.com.kaicloud.com.kaicloud.activity.HomeFragment;
import cloud.kai.com.kaicloud.com.kaicloud.activity.PaiFragment;
import cloud.kai.com.kaicloud.com.kaicloud.activity.PersonFragment;
import cloud.kai.com.kaicloud.com.kaicloud.activity.ShequFragment;
import cloud.kai.com.kaicloud.com.kaicloud.activity.WuyeFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    /**
     *
     */
    private ViewPager viewPager;
    private List<Fragment> viewpage = new ArrayList<Fragment>();
    private FragmentPagerAdapter adapter;
    private List<ImageButton> ImageButtons = new ArrayList<ImageButton>();


    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

        initDate();

        viewPager.setAdapter(adapter);

        initEvent();
    }

    private void initEvent() {
        viewPager.setOnPageChangeListener(this);
    }

    private void initDate() {


        HomeFragment homefragment = new HomeFragment();

        viewpage.add(homefragment);

        WuyeFragment wuyefragment = new WuyeFragment();

        viewpage.add(wuyefragment);

        ShequFragment shequfragment = new ShequFragment();

        viewpage.add(shequfragment);

        PaiFragment paifragment = new PaiFragment();

        viewpage.add(paifragment);

        PersonFragment personfragment = new PersonFragment();

        viewpage.add(personfragment);


        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return viewpage.size();
            }

            @Override
            public Fragment getItem(int position) {
                return viewpage.get(position);
            }
        };

        if (null != actionBar) {
            actionBar.setTitle(R.string.bottom_home);

        }
    }

    private void initview() {
        actionBar = getActionBar();
        if(null!=actionBar){
            actionBar.setDisplayShowHomeEnabled(false);

        }



        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ImageButton bottomimgOne = (ImageButton) findViewById(R.id.imageButton1);
        ImageButtons.add(bottomimgOne);

        ImageButton bottomimgTwo = (ImageButton) findViewById(R.id.imageButton2);
        ImageButtons.add(bottomimgTwo);

        ImageButton bottomimgThree = (ImageButton) findViewById(R.id.imageButton3);
        ImageButtons.add(bottomimgThree);

        ImageButton bottomimg_Four = (ImageButton) findViewById(R.id.imageButton4);
        ImageButtons.add(bottomimg_Four);

        ImageButton bottomimg_Fife = (ImageButton) findViewById(R.id.imageButton5);
        ImageButtons.add(bottomimg_Fife);

        bottomimgOne.setOnClickListener(this);
        bottomimgTwo.setOnClickListener(this);
        bottomimgThree.setOnClickListener(this);
        bottomimg_Four.setOnClickListener(this);
        bottomimg_Fife.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    /*    if (positionOffset > 0) {
            ImageButton left = ImageButtons.get(position);
            ImageButton right = ImageButtons.get(position + 1);

        }*/
    }



    @Override
    public void onPageSelected(int arg0) {
        int currentItem = viewPager.getCurrentItem();
        switch (currentItem) {
            case 0:


                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_home);
                }

                break;
            case 1:


                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_wuye);
                }
                break;
            case 2:


                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_shequ);
                }
                break;
            case 3:


                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_paixilai);
                }
                break;
            case 4:


                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_persion);
                }
                break;
        }
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onClick(View v) {
        viewListClick(v);
    }


    private void viewListClick(View v) {

        switch (v.getId()) {

            case R.id.imageButton1:
                viewPager.setCurrentItem(0, false);

                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_home);
                }

                break;
            case R.id.imageButton2:

                viewPager.setCurrentItem(1, false);
                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_wuye);
                }
                break;
            case R.id.imageButton3:

                viewPager.setCurrentItem(2, false);
                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_shequ);
                }
                break;
            case R.id.imageButton4:

                viewPager.setCurrentItem(3, false);
                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_paixilai);
                }
                break;
            case R.id.imageButton5:

                viewPager.setCurrentItem(4, false);
                if (null != actionBar) {
                    actionBar.setTitle(R.string.bottom_persion);
                }
                break;
        }
    }
}
