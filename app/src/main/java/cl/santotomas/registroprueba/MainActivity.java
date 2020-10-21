package cl.santotomas.registroprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.santotomas.registroprueba.modelo.Empleado;

public class MainActivity extends AppCompatActivity {

    Empleado e1 = new Empleado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registrar = (Button)findViewById(R.id.btn_registrar);

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText nombre = (EditText)findViewById(R.id.name_edit);
                EditText apellidos = (EditText)findViewById(R.id.last_name_edit);
                EditText edad = (EditText)findViewById(R.id.age_edit);

                e1.setNombre(nombre.getText().toString());
                e1.setApellidos(apellidos.getText().toString());
                e1.setEdad(edad.getText().toString());

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("el_nombre", e1.getNombre());
                detailIntent.putExtra("el_apellido", e1.getApellidos());
                detailIntent.putExtra("la_edad", e1.getEdad());

                startActivity(detailIntent);
            }
        });
    }
}