package com.calamarasmtic.addcontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class ContactDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);



        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("cnombre");
        String fecha = extras.getString("cfecha");
        String telefono = extras.getString("ctel");
        String email = extras.getString("cmail");
        String descripcion = extras.getString("cdesc");

        Log.i("hola", nombre);

        TextView tvnombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvfecha = (TextView) findViewById(R.id.tvFechaNac);
        TextView tvtelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvemail = (TextView) findViewById(R.id.tvEmail);
        TextView tvdescripcion = (TextView) findViewById(R.id.tvDescriopcion);

        tvnombre.setText(nombre);
        tvfecha.setText(fecha);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);

        Button btnEditData = (Button) findViewById(R.id.btnEditData);
        btnEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = ((TextView)findViewById(R.id.tvNombre)).getText().toString();
                String fecha =  ((TextView)findViewById(R.id.tvFechaNac)).getText().toString();
                String tel = ((TextView) findViewById(R.id.tvTelefono)).getText().toString();
                String email = ((TextView) findViewById(R.id.tvEmail)).getText().toString();
                String desc = ((TextView) findViewById(R.id.tvDescriopcion)).getText().toString();
                Log.i("ret4dsfew",fecha);
                Intent i = new Intent(ContactDetail.this, ContactForm.class);
                i.putExtra("cnombre", nombre);
                i.putExtra("cfecha", fecha);
                i.putExtra("ctel", tel);
                i.putExtra("cmail", email);
                i.putExtra("cdesc", desc);
                startActivity(i);

                //Intent i = new Intent(ContactDetail.this, ContactForm.class);
                //startActivity(i);
            }
        });


    }
}
