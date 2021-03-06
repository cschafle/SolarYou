package com.example.user.solaryou;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.solaryou.Planets.Earth;
import com.example.user.solaryou.Planets.Home_Fragment;
import com.example.user.solaryou.Planets.Jupiter;
import com.example.user.solaryou.Planets.Mars;
import com.example.user.solaryou.Planets.Mercury;
import com.example.user.solaryou.Planets.Neptune;
import com.example.user.solaryou.Planets.Saturn;
import com.example.user.solaryou.Planets.Uranus;
import com.example.user.solaryou.Planets.Venus;

import java.util.ArrayList;


public class MyActivity extends Activity {

    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    //Array adapter for sliding menu
    private ArrayList<NavigationDrawerIcon> navDrawerItems;
    private NavigationDrawerListAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);

        mTitle = mDrawerTitle = getTitle();
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_menu);
        navDrawerItems = new ArrayList<NavigationDrawerIcon>();

        // Home
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Mercury
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Mars
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Earth
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        // Mars
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // Jupiter
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
        // Saturn
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));
        // Uranus
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[7], navMenuIcons.getResourceId(7, -1)));
        //Neptune
        navDrawerItems.add(new NavigationDrawerIcon(navMenuTitles[8], navMenuIcons.getResourceId(8, -1)));


        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavigationDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.solar_system,
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }

    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* *
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    private void displayView(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Home_Fragment();
                break;
            case 1:
                fragment = new Mercury();
                break;
            case 2:
                fragment = new Venus();
                break;
            case 3:
                fragment = new Earth();
                break;
            case 4:
                fragment = new Mars();
                break;
            case 5:
                fragment = new Jupiter();
                break;
            case 6:
                fragment = new Saturn();
                break;
            case 7:
                fragment = new Uranus();
                break;
            case 8:
                fragment = new Neptune();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



}
