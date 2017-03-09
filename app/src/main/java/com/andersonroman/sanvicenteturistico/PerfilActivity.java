package com.andersonroman.sanvicenteturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView tUsername,tCorreo;
    String username,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername=(TextView) findViewById(R.id.tUsername);
        tCorreo=(TextView) findViewById(R.id.tCorreo);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("correo");

        tUsername.setText(username);
        tCorreo.setText(correo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuperfil, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id){
            case R.id.mCerrar:
                Intent intent=new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mMain:
                Intent intent1= new Intent(PerfilActivity.this,MainActivity.class);
                intent1.putExtra("username", username);
                intent1.putExtra("correo", correo);
                startActivity(intent1);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
