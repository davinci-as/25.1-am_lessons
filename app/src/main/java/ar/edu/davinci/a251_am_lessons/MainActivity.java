package ar.edu.davinci.a251_am_lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateMessage(View view) {
        //Log.i("test-message", "Actualizando campo de texto");
        //R.id.welcome_message
        TextView welcome_message = findViewById(R.id.welcome_message);
        welcome_message.setText(R.string.new_message);
        Toast messageToast = Toast.makeText(this, "Primer botón clickeado", Toast.LENGTH_LONG);
        messageToast.show();

    }

    public void openActivity(View view) {
        EditText message = findViewById(R.id.message);
        String messageText = String.valueOf(message.getText());
        Intent intent = new Intent(this, ListViewerActivity.class);
        intent.putExtra("messageText", messageText);
        startActivityForResult(intent, RESULT_OK);
    }
}