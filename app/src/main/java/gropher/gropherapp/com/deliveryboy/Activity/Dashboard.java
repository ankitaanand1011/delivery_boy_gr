package gropher.gropherapp.com.deliveryboy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import gropher.gropherapp.com.deliveryboy.Fragment.Accepted;
import gropher.gropherapp.com.deliveryboy.Fragment.All;
import gropher.gropherapp.com.deliveryboy.Fragment.Viewed;
import gropher.gropherapp.com.deliveryboy.R;


/**
 * Created by developer on 27/6/18.
 */

public class Dashboard extends Fragment{
ImageView profileImg;
    DrawerLayout drawer;
    TextView menu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        //drawer = findViewById(R.id.drawer_layout);

      // menu=findViewById(R.id.menu);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);


        viewPager.setAdapter(new SectionPagerAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        //profileImg=findViewById(R.id.profile_img);




     return view;
    }



    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new All();
                case 1:
                    return new Viewed();
                case 2:
                    return new Accepted();


                default:
                    return new All();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "All";
                case 1:
                    return "Viewed";
                case 2:
                    return "Accepted";
                default:
                    return "All";
            }
        }
    }

}