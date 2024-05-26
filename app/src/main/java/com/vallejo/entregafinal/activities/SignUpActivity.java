package com.vallejo.entregafinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vallejo.entregafinal.R;
import com.vallejo.entregafinal.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners(){
        // onBackPressed() "deprecated" (obsoleto)
        binding.textSignIn.setOnClickListener(v -> getOnBackPressedDispatcher());
    }
}