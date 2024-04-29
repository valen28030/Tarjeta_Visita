# Tarjeta_Visita
  <p align="justify">App diseñada para crear una tarjeta de visita a partir de los datos del usuario.</p>
  <p> <strong>Android Studio.</strong></p>
  <p> <strong>Lenguajes: Java y XML.</strong></p>
        <p>&nbsp;</p>
        
 ## Descripción
  <p align="justify">La <strong>Tarjeta de Presentación App</strong> es una aplicación móvil diseñada para ayudarte a crear y personalizar tu propia tarjeta de presentación de forma rápida y sencilla. Con esta aplicación, podrás ingresar tus datos personales, incluyendo información de contacto y detalles profesionales, y generar una tarjeta personalizada que refleje tu estilo y personalidad.</p>
        <p>&nbsp;</p>
        
 ## Funcionalidades
  <p align="justify"><strong>1. Creación de Tarjeta Personalizada</strong></p>
        <p align="justify">La aplicación te permite ingresar tus datos personales, como nombre, ocupación, número de teléfono, dirección de correo electrónico, y otros detalles relevantes para tu tarjeta de presentación.</p>

```sh
// Creación de los campos de la tarjeta personalizada
EditText nombreEditText = findViewById(R.id.nombre_edit_text);
EditText ocupacionEditText = findViewById(R.id.ocupacion_edit_text);
EditText telefonoEditText = findViewById(R.id.telefono_edit_text);
EditText correoEditText = findViewById(R.id.correo_edit_text);
// Otros campos relevantes pueden ser agregados de manera similar
```
 <p>&nbsp;</p>
<p align="justify"><strong>2. Validación de Campos</strong></p>
<p align="justify">Todos los campos ingresados son validados para garantizar la precisión y coherencia de la información proporcionada.</p>

```sh
// Validación de Campos
String nombre = nombreEditText.getText().toString();
String ocupacion = ocupacionEditText.getText().toString();
String telefono = telefonoEditText.getText().toString();
String correo = correoEditText.getText().toString();
// Validación de cada campo para garantizar que no estén vacíos o sean nulos
```
 <p>&nbsp;</p>
<p align="justify"><strong>3. Personalización de Diseño</strong></p>
<p align="justify">La aplicación ofrece opciones de personalización de diseño, incluyendo la posibilidad de agregar una imagen personalizada, seleccionar colores y elegir el diseño de la tarjeta.</p>
        
```sh
// Opciones de personalización de diseño, como agregar una imagen personalizada
ImageView imagenPersonalizada = findViewById(R.id.imagen_personalizada);
// Código para cargar una imagen personalizada desde la galería u otro origen
```
<p>&nbsp;</p>
<p align="justify"><strong>4. Guardado Persistente de Datos</strong></p>
<p align="justify">Los datos ingresados se guardan de forma persistente en la aplicación para que puedas acceder a ellos en cualquier momento y editar tu tarjeta según sea necesario.</p>
        
```sh
// Los datos ingresados se guardan de forma persistente en la aplicación
SharedPreferences sharedPreferences = getSharedPreferences("datos_tarjeta", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("nombre", nombre);
editor.putString("ocupacion", ocupacion);
editor.putString("telefono", telefono);
editor.putString("correo", correo);
editor.apply();
```
 <p>&nbsp;</p>
<p align="justify"><strong>5. Compartir Información</strong></p>      
<p align="justify">Una vez creada tu tarjeta de presentación, tienes la opción de compartirla fácilmente a través de diversas plataformas de redes sociales, correo electrónico o mensajería instantánea.</p>

```sh
// Compartir los datos de la tarjeta a través de diversas plataformas
Intent compartirIntent = new Intent(Intent.ACTION_SEND);
compartirIntent.setType("text/plain");
String mensaje = "Hola, aquí tienes mi tarjeta de presentación:\n" +
        "Nombre: " + nombre + "\n" +
        "Ocupación: " + ocupacion + "\n" +
        "Teléfono: " + telefono + "\n" +
        "Correo: " + correo + "\n";
compartirIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
startActivity(Intent.createChooser(compartirIntent, "Compartir Tarjeta"));
```
 <p>&nbsp;</p>
<p align="justify"><strong>6. Soporte para Pantallas en Posición Horizontal</strong></p>
<p align="justify">La aplicación está optimizada para funcionar en pantallas tanto en posición vertical como horizontal, brindando una experiencia de usuario fluida y adaptable.</p>
        
 <p>&nbsp;</p>
<p align="justify"><strong>7. Visualización del Anverso y Reverso de la Tarjeta</strong></p>
<p align="justify">Además de la parte frontal de la tarjeta, la aplicación te permite visualizar y editar el reverso de la misma, donde puedes agregar información adicional o personalizar el diseño.</p>
        
```sh
// La aplicación permite visualizar y editar el reverso de la tarjeta
Button reversoButton = findViewById(R.id.reverso_button);
reversoButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Código para mostrar la vista del reverso de la tarjeta
    }
});
```
 <p>&nbsp;</p>
<p align="justify"><strong>8. Generación de Código QR</strong></p>
<p align="justify">La aplicación genera automáticamente un código QR asociado a tu tarjeta de presentación, que puede escanearse para acceder rápidamente a tus datos de contacto.</p>
        
```sh
// La aplicación genera automáticamente un código QR asociado a la tarjeta de presentación
String datosContacto = "Nombre: " + nombre + "\n" +
                        "Ocupación: " + ocupacion + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Correo: " + correo + "\n";
Bitmap qrCodeBitmap = generateQRCode(datosContacto);
// Código para mostrar el código QR generado en la interfaz de usuario
``` 
<p>&nbsp;</p>
        
 ## Contenido de las Pantallas
  <p align="justify"><strong>Pantalla de Inicio</strong></p>
        <img src="https://github.com/valen28030/Tarjeta_Visita/assets/167770750/aed3a25a-56ef-4689-b07c-48a83e4cf99c" alt="Tarjeta de Presentación" width="300">
        <ul>
            <li>Formulario para ingresar datos personales</li>
            <li>Campos para nombre, apellido, ocupación, teléfono, correo electrónico y dirección.</li>
            <li>Validación de número de teléfono y de correo electrónico</li>
            <li>Botón de crear tarjeta (Si no se han rellenado los datos correctamente no genera la tarjeta y avisa en los campos donde hay un error)</li>
        </ul>
        <p>&nbsp;</p>
 <p align="justify"><strong>Pantalla de Personalización de Diseño</strong></p>
  
  <img src="https://github.com/valen28030/Tarjeta_Visita/assets/167770750/37b3f9e6-8edf-4817-b801-839fa1ce4d35" alt="Tarjeta de Presentación" width="300">
        <ul>
            <li>Opciones para personalizar el diseño de la tarjeta</li>
            <li>Selección de colores, fuentes y diseños predefinidos</li>
            <li>Botón con acceso a cámara del dispositivo para agregar una imagen personalizada</li>
            <li>Botón con acceso a QR generado automáticamente</li>
            <li>Vista previa de la tarjeta de presentación personalizada</li>
            <li>Ver el anverso y reverso de la tarjeta</li>
            <li>Botón con opciones para compartir la tarjeta a través de redes sociales, correo electrónico, etc.</li>
            <li>Botón de volver a la edición</li>
        </ul>
        <p>&nbsp;</p>
  <p align="justify"><strong>Pantalla de QR Personalizado</strong></p>
  
<img src="https://github.com/valen28030/Tarjeta_Visita/assets/167770750/a9bcabc3-592f-4edb-9ba2-60679ba9c425" alt="Tarjeta de Presentación" width="300">  
        <ul>
            <li>Imagen del QR</li>
            <li>Botón de volver a la vista de la tarjeta</li>
        </ul>
        <p>&nbsp;</p>
        
 ## Requisitos
  <ul>
            <li>Dispositivo móvil con sistema operativo iOS/Android</li>
            <li>Conexión a internet para compartir la tarjeta de presentación</li>
        </ul>
        <p>&nbsp;</p>
        
 ## Créditos
  <ul>
            <li><strong>Desarrollador:</strong> Carlos Valencia Sánchez</li>
            <li><strong>Diseñador de App:</strong> Carlos Valencia Sánchez</li>
            <li><strong>Artista Gráfico:</strong> Carlos Valencia Sánchez</li>
        </ul>
        <p>&nbsp;</p>
        
 ## Contacto
  <p align="justify">Para obtener soporte técnico, reportar errores o proporcionar comentarios, no dudes en contactar.</p>
        <p>&nbsp;</p>
<p align="justify">¡Esperamos que disfrutes utilizando la Tarjeta de Presentación App para crear tus propias tarjetas de presentación únicas y profesionales!</p>
        <hr>
        <p align="justify">Esta es una descripción general de la funcionalidad y contenido de la aplicación. Para obtener instrucciones detalladas sobre cómo utilizar cada característica, consulta la documentación incluida en la aplicación o comunícate con el desarrollador.</p>
</div>

