package ar.edu.davinci.a251_am_lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
    }
}