package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HotelesDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//////////////////////////////////7
    private HotelesDrawerActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    String username, correo;
    Intent intent;
    TextView tnombre,tcorreo;
    /////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Hoteles");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//lo traigo
        setSupportActionBar(toolbar);//lo pongo

        ///////////////////////////////////////
        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("correo");
        /////////////////////////////////////////

        //me permite correr la barra
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////////////////////////////
        mSectionsPagerAdapter = new HotelesDrawerActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        /////////////////////////////////////////////////
/*
        View perfil= navigationView.getHeaderView(0);
        tnombre=(TextView) perfil.findViewById(R.id.navNombre);
        tcorreo=(TextView) perfil.findViewById(R.id.navCorreo);
        tnombre.setText(username);
        tcorreo.setText(correo);*/
    }


    ///////////////////////////////////////////////////////////////////////////////

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hoteles, menu);
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
                intent=new Intent(HotelesDrawerActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                intent= new Intent(HotelesDrawerActivity.this,MainDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent= new Intent(HotelesDrawerActivity.this,BaresDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mSitios:
                intent= new Intent(HotelesDrawerActivity.this,SitiosDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mProductos:
                intent= new Intent(HotelesDrawerActivity.this,ListaDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPerfil:
                intent= new Intent(HotelesDrawerActivity.this,PerfilDrawerActivity.class);
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
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position){
                case 0:HotelUnoFragment tab1=new HotelUnoFragment();
                    return tab1;
                case 1: HotelDosFragment tab2 = new HotelDosFragment();
                    return tab2;
                default:return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.hotel1);
                case 1:
                    return "Hotel La Colina";
            }
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            intent= new Intent(HotelesDrawerActivity.this,MainDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_bares) {
            intent= new Intent(HotelesDrawerActivity.this,BaresDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_sitios) {
            intent= new Intent(HotelesDrawerActivity.this,SitiosDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_perfil) {
            intent= new Intent(HotelesDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_productos) {
            intent= new Intent(HotelesDrawerActivity.this,ListaDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);

        }else if (id == R.id.nav_cerrar) {
            intent=new Intent(HotelesDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}