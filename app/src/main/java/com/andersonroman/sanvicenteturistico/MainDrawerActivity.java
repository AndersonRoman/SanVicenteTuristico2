package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username="Anderson", correo="ander-353@hotmail.com";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("San Vicente Turistico");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras=getIntent().getExtras();
        //username=extras.getString("username");
        //correo=extras.getString("correo");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*TextView tnombre,tcorreo;
        View perfil= navigationView.getHeaderView(0);
        tnombre=(TextView) perfil.findViewById(R.id.navNombre);
        tcorreo=(TextView) perfil.findViewById(R.id.navCorreo);
        tnombre.setText(username);
        tcorreo.setText(correo);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id){
            case R.id.mCerrar:
                intent=new Intent(MainDrawerActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent= new Intent(MainDrawerActivity.this,HotelesDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent= new Intent(MainDrawerActivity.this,BaresDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mSitios:
                intent= new Intent(MainDrawerActivity.this,SitiosDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mProductos:
                intent= new Intent(MainDrawerActivity.this,ListaDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPerfil:
                intent= new Intent(MainDrawerActivity.this,PerfilDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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

        if (id == R.id.nav_sitios) {
            intent= new Intent(MainDrawerActivity.this,SitiosDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_hotel) {
            intent= new Intent(MainDrawerActivity.this,HotelesDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_bares) {
            intent= new Intent(MainDrawerActivity.this,BaresDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_perfil) {
            intent= new Intent(MainDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_productos) {
            intent= new Intent(MainDrawerActivity.this,ListaDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);

        }else if (id == R.id.nav_cerrar) {
            intent=new Intent(MainDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
