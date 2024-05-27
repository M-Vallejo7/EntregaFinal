package com.vallejo.entregafinal.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.vallejo.entregafinal.models.User;

import android.os.Bundle;

import com.vallejo.entregafinal.R;
import com.vallejo.entregafinal.databinding.ActivityChatBinding;
import com.vallejo.entregafinal.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        loadReceiverDetails();
    }

    private void loadReceiverDetails(){
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(receiverUser.name);
    }

    private void setListeners(){
        // onBackPressed (OBSOLETO) finish()
        binding.imageBack.setOnClickListener(v -> finish());
    }
}