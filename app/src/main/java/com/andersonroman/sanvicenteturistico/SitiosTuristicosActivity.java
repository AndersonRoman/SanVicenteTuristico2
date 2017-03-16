package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class SitiosTuristicosActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    String username, correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_turisticos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sitios_turisticos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.mCerrar:
                intent=new Intent(SitiosTuristicosActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent= new Intent(SitiosTuristicosActivity.this,HotelesActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mBares:
                intent= new Intent(SitiosTuristicosActivity.this,BaresActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPrincipal:
                intent= new Intent(SitiosTuristicosActivity.this,MainActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPerfil:
                intent= new Intent(SitiosTuristicosActivity.this,PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:SitiosUnoFragment tab1=new SitiosUnoFragment();
                    return tab1;
                case 1: SitiosDosFragment tab2 = new SitiosDosFragment();
                    return tab2;
                case 2:SitiosTresFragment tab3=new SitiosTresFragment();
                    return tab3;
                default:return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.sitio1);
                case 1:
                    return "Emblase";
                case 2:
                    return getResources().getString(R.string.sitio3);
            }
            return null;
        }
    }
}
