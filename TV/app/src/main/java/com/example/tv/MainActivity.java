package com.example.tv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Establezco las variables
    EditText editTextNombre, editTextApellido, editTextPuesto, editTextTelefono, editTextCorreo, editTextDireccion;
    Button btnGenerarTarjeta;
    SharedPreferences preferencias;
    TarjetaVisita tarjeta;
    String nombre, apellido, puesto, telefono, correo, direccion, newnombre, newapellido, newpuesto, newtelefono, newcorreo, newdireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Relaciono las variables con los id en el proyecto
        preferencias=getSharedPreferences("TV", Context.MODE_PRIVATE);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextPuesto = findViewById(R.id.editTextPuesto);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        btnGenerarTarjeta = findViewById(R.id.btnGenerarTarjeta);
        cargar();

        /*
         * Creo una función para el boton btnGenerarTarjeta
         */
        btnGenerarTarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = editTextNombre.getText().toString(); // Coge el nombre que de el usuario
                apellido = editTextApellido.getText().toString();
                puesto = editTextPuesto.getText().toString();
                telefono = editTextTelefono.getText().toString();
                correo = editTextCorreo.getText().toString();
                direccion = editTextDireccion.getText().toString();
                telefono(); // Llama a la función telefono
                correo();
                // Crear objeto TarjetaVisita
                tarjeta = new TarjetaVisita(nombre, apellido, puesto, telefono, correo, direccion);
                guardar();
                abrir();
            }
        });
    }

    /*
     * Valida el número de teléfono
     * Establece un maximo de 9 numeros obligatorio
     */
    void telefono(){
        if (telefono.length() != 9 || !telefono.matches("[0-9]+")) {
            editTextTelefono.setError("El número de teléfono debe contener 9 números");
        }
    }

    /*
     * Valida el correo electrónico
     */
    void correo(){
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            editTextCorreo.setError("Correo electrónico inválido");
        }
    }

    /*
     * Abrir la nueva actividad y enviar el objeto TarjetaVisita a través de Intent
     */
    void abrir(){
        Intent intent = new Intent(MainActivity.this, TarjetaVisitaActivity.class);
        intent.putExtra("tarjeta", tarjeta);
        startActivity(intent);
    }

    /*
     * Guarda las preferencias
     */
    void guardar(){
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("newnombre", nombre);
        editor.putString("newapellido", apellido);
        editor.putString("newpuesto", puesto);
        editor.putString("newtelefono", telefono);
        editor.putString("newcorreo", correo);
        editor.putString("newdireccion", direccion);
        editor.commit();
    }

    /*
     * Carga las preferencias
     */
    void cargar(){
        nombre = preferencias.getString("newnombre", "");
        apellido = preferencias.getString("newapellido", "");
        puesto = preferencias.getString("newpuesto", "");
        telefono = preferencias.getString("newtelefono", "");
        correo = preferencias.getString("newcorreo", "");
        direccion = preferencias.getString("newdireccion", "");

        editTextNombre.setText(nombre);
        editTextApellido.setText(apellido);
        editTextPuesto.setText(puesto);
        editTextTelefono.setText(telefono);
        editTextCorreo.setText(correo);
        editTextDireccion.setText(direccion);

    }
}