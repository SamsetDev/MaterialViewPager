package com.samset.customviewpager;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.samset.customviewpager.adapter.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,AppBarLayout.OnOffsetChangedListener
{  private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 5;


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyTabsAdapter adapter;
    private FrameLayout frameLayout;
    private FloatingActionButton fab;
    private AppBarLayout appbarLayout;
    private DrawerLayout drawerLayout;
    private int mMaxScrollSize;
    private boolean mIsAvatarShown = true;
    private CollapsingToolbarLayout collapsingToolbarLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout= (FrameLayout) findViewById(R.id.main_framelayout_title);
        appbarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appbarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appbarLayout.getTotalScrollRange();

        setupNavigationView();
        setupToolbar();
        setupTablayout();
        setupCollapsingToolbarLayout();
        setupFab();

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationView(){

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void setupCollapsingToolbarLayout(){

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if(collapsingToolbarLayout != null){
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
            collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.blue));
            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.primary_color));
        }
    }

    private void setupTablayout(){

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        if(tabLayout == null)
            return;
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager= (ViewPager) findViewById(R.id.materialup_viewpager);
        adapter=new MyTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }





    private void setupFab(){
        fab = (FloatingActionButton) findViewById(R.id.fab);
        if(fab != null)
            fab.setOnClickListener(this);
    }


    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null)
            setSupportActionBar(toolbar);

        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.fab){

            Snackbar
                    .make(findViewById(R.id.coordinatorLayout), "This is Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", this)
                    .show(); // Don’t forget to show!
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(i)) * 100 / mMaxScrollSize;

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;
            frameLayout.animate().scaleY(0).scaleX(0).setDuration(600).start();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;

            frameLayout.animate()
                    .scaleY(1).scaleX(1)
                    .start();
        }
    }





}
