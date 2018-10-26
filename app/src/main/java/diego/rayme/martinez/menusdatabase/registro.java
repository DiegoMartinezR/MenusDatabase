package diego.rayme.martinez.menusdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import diego.rayme.martinez.menusdatabase.repositories.UserRepository;

public class registro extends AppCompatActivity {

    private EditText nombrecompleto;
    private EditText usuario;
    private EditText correo;
    private EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = (EditText)findViewById(R.id.texto1);
        nombrecompleto = (EditText)findViewById(R.id.texto2);
        correo = (EditText)findViewById(R.id.texto3);
        contrasena = (EditText)findViewById(R.id.texto4);

    }

    public void callRegister(View view){
        String nombre = nombrecompleto.getText().toString();
        String email = correo.getText().toString();
        String password = contrasena.getText().toString();
        String usuarios = usuario.getText().toString();


        if(nombre.isEmpty() || email.isEmpty() || password.isEmpty() || usuarios.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;


    }
        UserRepository.create(usuarios,nombre, email, password);
        finish();
    }


}
