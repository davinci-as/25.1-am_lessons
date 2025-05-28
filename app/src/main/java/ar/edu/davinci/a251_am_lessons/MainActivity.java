package ar.edu.davinci.a251_am_lessons;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = this.mAuth.getCurrentUser();
        if(user != null) {
            String email = user.getEmail();
            Log.i("firebase-auth", "usuario logueado con el email: " + email);

            Intent intent = new Intent(this, ListViewerActivity.class);
            intent.putExtra("messageText", "Probando login");
            startActivity(intent);
        }
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

        this.mAuth.signInWithEmailAndPassword(
        "sergiod.medina@davinci.edu.ar",
        messageText
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.i("firebase-auth", "logueo correcto");
                        Intent intent = new Intent(getApplicationContext(), ListViewerActivity.class);
                        intent.putExtra("messageText", messageText);
                        startActivityForResult(intent, RESULT_OK);
                    } else {
                        Log.i("firebase-auth", "logueo incorrecto");
                    }
            }
        });


    }
}