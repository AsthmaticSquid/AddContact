package com.calamarasmtic.addcontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Set;
import java.util.StringTokenizer;

public class ContactForm extends AppCompatActivity {
    String day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = ((EditText) findViewById(R.id.etContactName)).getText().toString();
                String fecha = String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getDayOfMonth()) + "/" +
                        String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getMonth() + 1) + "/" +
                        String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getYear());
                String tel = ((EditText) findViewById(R.id.etTelefono)).getText().toString();
                String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
                String desc = ((EditText) findViewById(R.id.etDescripcion)).getText().toString();
                Intent i = new Intent(ContactForm.this, ContactDetail.class);
                i.putExtra("cnombre", nombre);
                i.putExtra("cfecha", fecha);
                i.putExtra("ctel", tel);
                i.putExtra("cmail", email);
                i.putExtra("cdesc", desc);
                startActivity(i);
            }
        });
        } else {
           // Bundle extras = getIntent().getExtras();
            View refreshed = findViewById(R.id.activity_contact_form);
            ViewGroup parent = (ViewGroup) refreshed.getParent();
            int index = parent.indexOfChild(refreshed);
            parent.removeView(refreshed);
            String nombre = extras.getString("cnombre");
            int pos = 0, cont = 0;
            String fecha = extras.getString("cfecha");
            char[] cfech = fecha.toCharArray();


            for (int i = 0; i < extras.getString("cfecha").length(); i++) {
                if (cfech[i] == '/' && cont == 0) {
                    day = extras.getString("cfecha").substring(0, i - 1);
                    cont++;
                    pos = i;
                } else if (cfech[i] == '/' && cont == 1) {
                    month = extras.getString("cfecha").substring(pos + 1, i - 1);
                    cont++;
                    pos = i;
                } else {
                    year = extras.getString("cfecha").substring(pos + 1, fecha.length());
                }
            }

            String telefono = extras.getString("ctel");
            String email = extras.getString("cmail");
            String descripcion = extras.getString("cdesc");


            EditText tvnombre = (EditText) findViewById(R.id.etContactName);
            DatePicker tvfecha = (DatePicker) findViewById(R.id.dpFecha);
            EditText tvtelefono = (EditText) findViewById(R.id.etTelefono);
            EditText tvemail = (EditText) findViewById(R.id.etEmail);
            EditText tvdescripcion = (EditText) findViewById(R.id.etDescripcion);

            Log.i("bebe", nombre);
            tvnombre.setText(nombre);
            tvfecha.updateDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
            tvtelefono.setText(telefono);
            tvemail.setText(email);
            tvdescripcion.setText(descripcion);

            Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
            btnSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String nombre = ((EditText) findViewById(R.id.etContactName)).getText().toString();
                    String fecha = String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getDayOfMonth()) + "/" +
                            String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getMonth() + 1) + "/" +
                            String.valueOf(((DatePicker) findViewById(R.id.dpFecha)).getYear());
                    String tel = ((EditText) findViewById(R.id.etTelefono)).getText().toString();
                    String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
                    String desc = ((EditText) findViewById(R.id.etDescripcion)).getText().toString();
                    Intent i = new Intent(ContactForm.this, ContactDetail.class);
                    i.putExtra("cnombre", nombre);
                    i.putExtra("cfecha", fecha);
                    i.putExtra("ctel", tel);
                    i.putExtra("cmail", email);
                    i.putExtra("cdesc", desc);
                    startActivity(i);
                }
            });
        }
    }
}



