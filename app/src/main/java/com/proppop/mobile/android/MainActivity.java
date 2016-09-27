package com.proppop.mobile.android;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.proppop.mobile.android.fragments.PayRentFragment;
import com.proppop.mobile.android.fragments.RentalUnitsFragment;


//////////////loging for testing ]/
/////////////  -u n@n.com
// //////////  -p 12345678
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = setupToolBar();
        setupFloatingActionButton();
        setupDrawerLayout(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        createFragmentAdapterForSections();

        mAuth = FirebaseAuth.getInstance();
        possibleForceUserToLogin();
    }

    private Toolbar setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        return toolbar;
    }

    private void setupDrawerLayout(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            showLongToast("Logged out");
            mAuth.signOut();
            forceUserToLogin();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_signin) {
            forceUserToLogin();
        } else if (id == R.id.nav_repairs) {
            showLongToast("Repairs not implemented yet");
        } else if (id == R.id.nav_lease_documents) {
            updateDisplay(new RentalUnitsFragment());
        } else if (id == R.id.nav_pay_rent) {
            updateDisplay(new PayRentFragment());
        } else if (id == R.id.nav_logout) {
            showLongToast("Logout not implemented yet");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createFragmentAdapterForSections() {
//        mPagerAdapter = new TabbedFragmentPagerAdapter(getSupportFragmentManager());
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mPagerAdapter);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);
    }

    private void updateDisplay(Fragment fragment) {
        System.out.println("-------------------------------------------------------pay rent 1");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment).commit();
    }


    private void possibleForceUserToLogin() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null)
            forceUserToLogin();
    }

    private void forceUserToLogin() {
        Intent signinIntent = new Intent(this, EmailPasswordActivity.class);
        startActivity(signinIntent);
    }

    private void showLongToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

//    private class TabbedFragmentPagerAdapter extends FragmentPagerAdapter {
//        private final AbstractBaseFragment[] mFragments;
//
//        public TabbedFragmentPagerAdapter(FragmentManager fragmentManager) {
//            super(fragmentManager);
//
//            mFragments = new AbstractBaseFragment[] {new RentalUnitsFragment(), new TenantsFragment(), };
//        }
//
//        @Override
//        public AbstractBaseFragment getItem(int position) {
//            return  mFragments[position];
//        }
//
//        @Override
//        public int getCount() {
//            return mFragments.length;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            System.out.println("-------------------------" + mFragments[position].isAdded());
//            return getString(mFragments[position].getFragmentTitleResourceId());
//        }
//    }
}
