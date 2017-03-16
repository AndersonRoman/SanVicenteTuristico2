package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.andersonroman.sanvicenteturistico.R.string.username;

public class MainActivity extends AppCompatActivity {

    String username, correo;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("correo");
        //Toast.makeText(this,"OnCreate",Toast.LENGTH_SHORT).show();//cuando aparesca un error
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
                intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent= new Intent(MainActivity.this,HotelesActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mBares:
                intent= new Intent(MainActivity.this,BaresActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mSitios:
                intent= new Intent(MainActivity.this,SitiosTuristicosActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                break;
            case R.id.mPerfil:
                intent= new Intent(MainActivity.this,PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"OnStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"OnPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"OnResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"OnRestart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"OnDestroy",Toast.LENGTH_SHORT).show();
    }*/
}
