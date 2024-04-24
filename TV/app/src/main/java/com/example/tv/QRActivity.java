package com.example.tv;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRActivity extends AppCompatActivity {

    ImageView imgQR;
    Button btnAtras2;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        imgQR = findViewById(R.id.imgQR);
        btnAtras2 = findViewById(R.id.btnAtras2);

        QR();

        btnAtras2.setOnClickListener(view -> finish());
    }

    /*
     * Crea un QR con los datos del String traido de TarjetaVisitaActivity y lo asigna a una imagen vacia
     */
    void QR(){
        try {
            String QR = getIntent().getStringExtra("QR");
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(QR, BarcodeFormat.QR_CODE, 90, 90);
            imgQR.setImageBitmap(bitmap);
        } catch (Exception E){E.printStackTrace();}

    }
}
