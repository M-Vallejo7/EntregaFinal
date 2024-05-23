package com.vallejo.entregafinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.airbnb.lottie.LottieAnimationView;
import android.widget.TextView;

public class AnimationStart extends AppCompatActivity{

    private static final long DELAY_MILLIS = 5000; // 4 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_start);

        LottieAnimationView animationView = findViewById(R.id.animationView);
        TextView textView = findViewById(R.id.headerTextView);

        // Inicia la animación
        animationView.setAnimation(R.raw.animation_4);
        animationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Pasar al Main
                Intent intent = new Intent(AnimationStart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);
    }
}
