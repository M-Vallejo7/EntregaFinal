package com.vallejo.entregafinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.vallejo.entregafinal.R;
import com.vallejo.entregafinal.databinding.ActivitySignInBinding;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
        // Para el funcionamiento del registro con la base de datos a través del botón
        // binding.buttonSignIn.setOnClickListener(v -> addDataToFirestore());
    }

    //Prueba para el registro de usuarios en la base de datos
    //private void addDataToFirestore(){
        //FirebaseFirestore database = FirebaseFirestore.getInstance();
        //HashMap<String, Object> data = new HashMap<>();
        //data.put("first_name", "Miguel Angel");
        //data.put("last_name", "Vallejo Giraldo");
        //database.collection("users")
          //      .add(data)
            //    .addOnSuccessListener(documentReference -> {
              //      Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                //})
                //.addOnFailureListener(exception -> {
                  //  Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                //});
    //}
}