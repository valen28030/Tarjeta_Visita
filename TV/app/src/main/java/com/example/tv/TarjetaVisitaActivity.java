package com.example.tv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TarjetaVisitaActivity extends AppCompatActivity {
    TextView txtNombreApellido, txtPuesto, txtTelefono, txtCorreo, txtDireccion;
    Button btnCompartir, btnRed, btnGreen, btnBlue, btnYellow, btnqr, btnfoto, btnAtras;
    ImageView imgAnverso, imgReverso, imgfoto;
    String QR, Telefono;
    final int CODIGO_SOLICITUD_CAMARA = 1;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjetavisita);
        txtNombreApellido = findViewById(R.id.txtNombreApellido);
        txtPuesto = findViewById(R.id.txtPuesto);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnCompartir = findViewById(R.id.compartir);
        btnRed = findViewById(R.id.red);
        btnGreen = findViewById(R.id.green);
        btnBlue = findViewById(R.id.blue);
        btnYellow = findViewById(R.id.yellow);
        imgAnverso = findViewById(R.id.anverso);
        imgReverso = findViewById(R.id.reverso);
        imgfoto = findViewById(R.id.imgfoto);
        btnqr = findViewById(R.id.btnqr);
        btnfoto = findViewById(R.id.btnfoto);
        btnAtras = findViewById(R.id.btnAtras);

        DatosUsuario();

        btnRed.setOnClickListener(view -> Color(1));
        btnGreen.setOnClickListener(view -> Color(2));
        btnBlue.setOnClickListener(view -> Color(3));
        btnYellow.setOnClickListener(view -> Color(4));
        btnfoto.setOnClickListener(view -> Foto());
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AbrirQR();
            }
        });
        btnCompartir.setOnClickListener(view -> Compartir());
        btnAtras.setOnClickListener(view -> finish());
    }

    /*
     * Obtiene el objeto TarjetaVisita enviado desde MainActivity
     * Muestra los datos en la interfaz de usuario
     */
    @SuppressLint("SetTextI18n")
    void DatosUsuario()
    {
        TarjetaVisita tarjeta = (TarjetaVisita) getIntent().getSerializableExtra("tarjeta");
        if (tarjeta != null) {
            txtNombreApellido.setText(tarjeta.getNombre() + " " + tarjeta.getApellido());
            txtPuesto.setText(tarjeta.getPuesto());
            txtTelefono.setText(tarjeta.getTelefono());
            txtCorreo.setText(tarjeta.getCorreo());
            txtDireccion.setText(tarjeta.getDireccion());
        }
        Telefono = txtTelefono.getText().toString();
    }

    /*
     * Cambia las imagenes, accediendo al drawable donde estan alojadas, dependiendo de un int
     */
    void Color(int color_id)
    {
        if(color_id == 1){
            imgAnverso.setImageResource(R.drawable.anversor);
            imgReverso.setImageResource(R.drawable.reversor);
        } else if (color_id == 2) {
            imgAnverso.setImageResource(R.drawable.anversog);
            imgReverso.setImageResource(R.drawable.reversog);
        } else if (color_id == 3) {
            imgAnverso.setImageResource(R.drawable.anversob);
            imgReverso.setImageResource(R.drawable.reversob);
        } else if (color_id == 4) {
            imgAnverso.setImageResource(R.drawable.anversoy);
            imgReverso.setImageResource(R.drawable.reversoy);
        }
    }

    /*
     * Abrir la nueva actividad y enviar el string QR a través de Intent
     */
    void AbrirQR(){
        QR = txtNombreApellido.getText().toString() + " / " + txtTelefono.getText().toString() + " / " + txtCorreo.getText().toString();
        Intent intent = new Intent(TarjetaVisitaActivity.this, QRActivity.class);
        intent.putExtra("QR", QR);
        startActivity(intent);
    }

    /*
     * Comparte el número de telefono
     */
    void Compartir()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, Telefono);
                intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*
     * Abrir la Camara
     */
    void Foto()
    {
        Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camara, CODIGO_SOLICITUD_CAMARA);
    }

    /*
     * Obtener imagen de cámara
     */
    @Override
    protected void onActivityResult (int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO_SOLICITUD_CAMARA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap foto = (Bitmap) extras.get("data");
            imgfoto.setImageBitmap(foto);
        }

    }
}
