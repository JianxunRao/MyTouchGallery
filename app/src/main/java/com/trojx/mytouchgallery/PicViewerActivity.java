package com.trojx.mytouchgallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**Simple TouchGallery demo based on ViewPager and Photoview.
 * Created by Trojx on 2016/1/3.
 */
public class PicViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_indicator;
    private ArrayList<String> urlList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_viewer);

        String [] urls={"http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_0.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_1.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_2.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_3.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_4.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_5.jpg",
                "http://www.zhagame.com/wp-content/uploads/2016/01/JarvanIV_6.jpg",};

        urlList = new ArrayList<>();
        Collections.addAll(urlList, urls);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_indicator = (TextView) findViewById(R.id.tv_indicator);

        viewPager.setAdapter(new PictureSlidePagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_indicator.setText(String.valueOf(position+1)+"/"+urlList.size());
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private  class PictureSlidePagerAdapter extends FragmentStatePagerAdapter{

        public PictureSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PictureSlideFragment.newInstance(urlList.get(position));
        }

        @Override
        public int getCount() {
            return urlList.size();
        }
    }
}
