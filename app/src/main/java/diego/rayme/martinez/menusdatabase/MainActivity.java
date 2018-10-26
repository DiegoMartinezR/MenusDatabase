package diego.rayme.martinez.menusdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import diego.rayme.martinez.menusdatabase.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {
    EditText txt1;
    EditText txt2;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrar = findViewById(R.id.btn2);
        txt1 = (EditText)findViewById(R.id.txt1);
        txt2 = (EditText)findViewById(R.id.txt2);


    }

    public void onclick(View view) {
        Intent intent = new Intent(MainActivity.this,registro.class);
        startActivity(intent);
    }

    public void inicio(View view) {
        String n = txt1.getText().toString();
        String c = txt2.getText().toString();

        if (n.isEmpty() && c.isEmpty()){
            Toast.makeText(this,"Todos los datos son requeridos",Toast.LENGTH_SHORT).show();
        }

        if(UserRepository.inicio(n,c)){
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Los datos no coinciden",Toast.LENGTH_SHORT).show();
        }
        finish();
    }



    private void llamarAgregarNotas() {
        Intent intent1 = new Intent(this, Home.class);
        startActivity(intent1);
    }
}
