package com.example.el3afreet.green;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.el3afreet.green.NewFragment.AmbientLightFragment;
import com.example.el3afreet.green.NewFragment.FishFeedingFragment;
import com.example.el3afreet.green.NewFragment.FixturesTabs;
import com.example.el3afreet.green.NewFragment.HomeFragment;
import com.example.el3afreet.green.NewFragment.PHLevelFragment;
import com.example.el3afreet.green.NewFragment.PlantHightFragment;
import com.example.el3afreet.green.NewFragment.Temperature;
import com.example.el3afreet.green.NewFragment.TemperatureFragment;
import com.example.el3afreet.green.NewFragment.WaterFlowRate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("home");
        loadFragment(new HomeFragment());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this ,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        View headerView = navigationView.getHeaderView(0);
        textView = (TextView) headerView.findViewById(R.id.user);
        textView.setText(user.getEmail());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_temperature:
                    toolbar.setTitle("Temperature");
                    fragment = new Temperature();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_water:
                    toolbar.setTitle("WaterFlow");
                    fragment = new WaterFlowRate();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_light:
                    toolbar.setTitle("AmbientLight");
                    fragment = new FixturesTabs();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_plant:
                    toolbar.setTitle("Plant Hight");
                    fragment = new PlantHightFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_fish:
                    toolbar.setTitle("Fish Feeding");
                    fragment = new FishFeedingFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_phlevel:
                    toolbar.setTitle("PHlevel");
                    fragment = new PHLevelFragment();
                    loadFragment(fragment);
                    return true;

            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(android.view.MenuItem item) {
        Fragment fragment;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_temperature) {
            toolbar.setTitle("Temperature");
            fragment = new Temperature();
            loadFragment(fragment);
        } else if (id == R.id.nav_water) {
            toolbar.setTitle("WaterFlow");
            fragment = new WaterFlowRate();
            loadFragment(fragment);

        } else if (id == R.id.nav_Ambient) {
            toolbar.setTitle("AmbientLight");
            fragment = new FixturesTabs();
            loadFragment(fragment);

        } else if (id == R.id.nav_Plant) {
            toolbar.setTitle("Plant Hight");
            fragment = new PlantHightFragment();
            loadFragment(fragment);

        } else if (id == R.id.nav_Fish) {
            toolbar.setTitle("Fish Feeding");
            fragment = new FishFeedingFragment();
            loadFragment(fragment);

        } else if (id == R.id.nav_PH) {
            toolbar.setTitle("PHlevel");
            fragment = new PHLevelFragment();
            loadFragment(fragment);
        }
        else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(Dashboard.this,LoginActivity.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
