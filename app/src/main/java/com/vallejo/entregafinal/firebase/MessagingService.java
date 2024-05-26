package com.vallejo.entregafinal.firebase;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        // Para hacer las pruebas con los mensajes remotos en firebase (Logcat)
        // Aqui se ve que el servicio si funcione en la consola de Logcat
        // Log.d("FCM", "Token: " + token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // Aqui se visualiza en Logcat un mensaje remoto entrante desde firebase
        //Log.d("FCM", "Message: " + remoteMessage.getNotification().getBody());
    }
}
