package mx.com.chino.holafirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String PATH_START="start";
    private static final String Path_MESSAGE="message";

    private TextView lblMensaje;
    private EditText txtMensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMensaje = findViewById(R.id.lblMensaje);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(PATH_START).child(Path_MESSAGE);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lblMensaje.setText(snapshot.getValue(String.class));
                txtMensaje.setText(snapshot.getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error al consultar en Firebase", Toast.LENGTH_LONG).show();

            }
        });

   btnEnviar.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           FirebaseDatabase database = FirebaseDatabase.getInstance();
           final DatabaseReference reference = database.getReference(PATH_START).child(Path_MESSAGE);

           reference.setValue(txtMensaje.getText().toString().trim());


       }
   });
    }
}