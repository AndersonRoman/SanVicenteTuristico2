package com.andersonroman.sanvicenteturistico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Lista_Entrada[] datos= new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.fresa,"Fresas","Producto de exportación","6000$"),
            new Lista_Entrada(R.drawable.fique,"El fique","Artesanias en fique","Desde 20000$"),
            new Lista_Entrada(R.drawable.uchuva,"La uchuva","Excelentes prop. nutricinistas","3500$"),
            new Lista_Entrada(R.drawable.mora,"La mora","Rico producto para postres","2200$")

    };

    ListView list;

    String username, correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Productos agrícolas");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        list=(ListView) findViewById(R.id.list);


        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, parques);

        ListaDrawerActivity.Adapter adapter= new ListaDrawerActivity.Adapter(this,datos);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data=((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Toast.makeText(getApplicationContext(), String.valueOf(position),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListaDrawerActivity.this,ProductosDrawerActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
            }
        });

/*
        TextView tnombre,tcorreo;
        View perfil= navigationView.getHeaderView(0);
        tnombre=(TextView) perfil.findViewById(R.id.navNombre);
        tcorreo=(TextView) perfil.findViewById(R.id.navCorreo);
        tnombre.setText(username);
        tcorreo.setText(correo);*/
    }

    class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context,R.layout.list_item, datos);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item= inflater.inflate(R.layout.list_item, null);

            TextView nombre= (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip=(TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc = (TextView) item.findViewById(R.id.tDirec);
            direc.setText(datos[position].getDirec());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
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
            intent= new Intent(ListaDrawerActivity.this,MainDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_bares) {
            intent= new Intent(ListaDrawerActivity.this,BaresDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_sitios) {
            intent= new Intent(ListaDrawerActivity.this,SitiosDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_perfil) {
            intent= new Intent(ListaDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_hotel) {
            intent= new Intent(ListaDrawerActivity.this,HotelesDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);

        }else if (id == R.id.nav_cerrar) {
            intent=new Intent(ListaDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
