package shared_preferences.elvis.almacenamiento_shart;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    Button guardar;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.nombre);
        guardar = findViewById(R.id.guardar);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        nombre.setText(preferences.getString("usuarios",""));
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(v);
            }
        });
    }
    public void guardar(View view)
    {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("usuarios", nombre.getText().toString());
        obj_editor.commit();
        finish();
    }
}
