package ar.edu.davinci.a251_am_lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra("messageText");

        Button new_button = new Button(this);
        new_button.setText(R.string.new_message);
        new_button.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        new_button.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout header_layout = (LinearLayout) findViewById(+R.id.header_layout);
        header_layout.addView(new_button);

        TextView welcome_message = new TextView(getApplicationContext());
        LinearLayout card = findViewById(R.id.viewer);
        welcome_message.setText(messageText);
        card.addView(welcome_message);

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView welcome_message = new TextView(getApplicationContext());
                LinearLayout card = findViewById(R.id.viewer);
                welcome_message.setText("Otro mensaje");
                card.addView(welcome_message);
                //TextView welcome_message = findViewById(R.id.welcome_message);
                Button new_button = (Button) v;
                new_button.setText("Mensaje Actualizado");
                Toast messageToast = Toast.makeText(getApplicationContext(), "Segundo botón clickeado", Toast.LENGTH_LONG);
                messageToast.show();
            }
        });

        //Descargar imagen para actualizar en la UI
        (new ImageDownloader()).execute("https://www.liderdelemprendimiento.com/wp-content/uploads/2023/06/Que-son-las-inversiones.png");

        (new ApiRequest()).execute("https://www.jsonblob.com/api/jsonBlob/1385039476312694784");
    }
}