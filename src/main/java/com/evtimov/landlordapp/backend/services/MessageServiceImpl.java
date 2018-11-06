package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    private Message messageToSend;
    private static String SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
    private static String FCM_ENDPOINT =
            "https://fcm.googleapis.com/v1/projects/yourfirebaseproject/messages:send";

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message createMessage(Message message) {
        repository.createMessage(message);
        messageToSend = message;
        return message;
    }

    @Override
    public void sendMessage(String token) {
        String title = "New Message";
        String body = messageToSend.getText();
        sendMessageToFCM(getFCMNotification(title,body,token));
    }

    private String getFCMNotification(String receiverToken, String title, String body) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("token",receiverToken);

        JsonObject notification = new JsonObject();
        notification.addProperty("title",title);
        notification.addProperty("body",body);

        jsonObject.add("notification",notification);

        JsonObject message = new JsonObject();
        message.add("message",jsonObject);
        return message.toString();
    }

    private void sendMessageToFCM(String text) {
        MediaType mediaType = MediaType.parse("application/json");
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url(FCM_ENDPOINT)
                    .addHeader("Content-Type","application/json;UTF-8")
                    .addHeader("Authorization","Bearer " +getAccessToken())
                    .post(RequestBody.create(mediaType,text))
                    .build();
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getAccessToken() throws IOException {
        GoogleCredential googleCredential = GoogleCredential
                .fromStream(new FileInputStream("firebase-priv-key.json"))
                .createScoped(Arrays.asList(SCOPE));
        googleCredential.refreshToken();
        return googleCredential.getAccessToken();
    }


    /*@Override
    public List<Message> getAllDeliveredMessagesByTenantId(int tenantId) {
        return repository.getAllDeliveredMessagesByTenantId(tenantId);
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByTenantId(int tenantId) {
        return repository.getAllUndeliveredMessagesByTenantId(tenantId);
    }

    @Override
    public List<Message> getAllDeliveredMessagesByLandlordId(int landlordId) {
        return repository.getAllDeliveredMessagesByLandlordId(landlordId);
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByLandlordId(int landlordId) {
        return repository.getAllUndeliveredMessagesByLandlordId(landlordId);
    }*/
}
