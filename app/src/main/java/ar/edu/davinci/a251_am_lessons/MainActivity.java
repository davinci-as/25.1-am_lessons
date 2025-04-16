package ar.edu.davinci.a251_am_lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button new_button = findViewById(R.id.new_button);
        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView welcome_message = findViewById(R.id.welcome_message);
                welcome_message.setText("Otro mensaje");
                Button new_button = (Button) v;
                new_button.setText("Mensaje Actualizado");
                Toast messageToast = Toast.makeText(getApplicationContext(), "Segundo botón clickeado", Toast.LENGTH_LONG);
                messageToast.show();
            }
        });
    }

    public void updateMessage(View view) {
        //Log.i("test-message", "Actualizando campo de texto");
        //R.id.welcome_message
        TextView welcome_message = findViewById(R.id.welcome_message);
        welcome_message.setText(R.string.new_message);
        Toast messageToast = Toast.makeText(this, "Primer botón clickeado", Toast.LENGTH_LONG);
        messageToast.show();

    }
}