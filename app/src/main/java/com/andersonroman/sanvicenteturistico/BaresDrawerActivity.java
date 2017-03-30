package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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

public class BaresDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //////////////////////////////////////////////////////////
    private BaresDrawerActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    String username, correo;
    Intent intent;
    ///////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Bares");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("correo");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new BaresDrawerActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

/*
        TextView tnombre,tcorreo;
        View perfil= navigationView.getHeaderView(0);
        tnombre=(TextView) perfil.findViewById(R.id.navNombre);
        tcorreo=(TextView) perfil.findViewById(R.id.navCorreo);
        tnombre.setText(username);
        tcorreo.setText(correo);
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bares, menu);
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
                intent=new Intent(BaresDrawerActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent= new Intent(BaresDrawerActivity.this,HotelesDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                intent= new Intent(BaresDrawerActivity.this,MainDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mSitios:
                intent= new Intent(BaresDrawerActivity.this,SitiosDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mProductos:
                intent= new Intent(BaresDrawerActivity.this,ListaDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPerfil:
                intent= new Intent(BaresDrawerActivity.this,PerfilDrawerActivity.class);
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
                case 0:BaresUnoFragment tab1=new BaresUnoFragment();
                    return tab1;
                case 1: BaresDosFragment tab2 = new BaresDosFragment();
                    return tab2;
                case 2:BaresTresFragment tab3=new BaresTresFragment();
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
                    return "Cafe-Bar Ibiza";
                case 1:
                    return "Terranova disk";
                case 2:
                    return "Scorpion Discotec";
            }
            return null;
        }
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            intent= new Intent(BaresDrawerActivity.this,MainDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_hotel) {
            intent= new Intent(BaresDrawerActivity.this,HotelesDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_sitios) {
            intent= new Intent(BaresDrawerActivity.this,SitiosDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_perfil) {
            intent= new Intent(BaresDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_productos) {
            intent= new Intent(BaresDrawerActivity.this,ListaDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);

        }else if (id == R.id.nav_cerrar) {
            intent=new Intent(BaresDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
