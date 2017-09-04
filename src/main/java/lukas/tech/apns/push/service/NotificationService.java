package lukas.tech.apns.push.service;

import com.turo.pushy.apns.ApnsClient;
import com.turo.pushy.apns.ApnsClientBuilder;
import com.turo.pushy.apns.PushNotificationResponse;
import com.turo.pushy.apns.util.ApnsPayloadBuilder;
import com.turo.pushy.apns.util.SimpleApnsPushNotification;
import io.netty.util.concurrent.Future;
import lukas.tech.apns.push.Application;
import lukas.tech.apns.push.configuration.GlobalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by lukas on 31.08.17.
 */
@Service
public class NotificationService {
    public static final String TEST_TITLE = "Test push";

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private ApnsClient client;
    private GlobalProperties config;

    @Autowired
    public NotificationService(GlobalProperties config) {
        this.config = config;
    }

    public void sendNotification(String deviceToken, String message) {
        Future<Void> connectFuture;
        try {
            connectFuture = getApnsCLient().connect(ApnsClient.DEVELOPMENT_APNS_HOST);
            connectFuture.await();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Construct finished");

        final ApnsPayloadBuilder apnsPayloadBuilder = new ApnsPayloadBuilder();
        apnsPayloadBuilder.setAlertTitle(TEST_TITLE);
        apnsPayloadBuilder.setAlertBody(message);
        String payloadRequest = apnsPayloadBuilder.buildWithDefaultMaximumLength();

        SimpleApnsPushNotification pushNotificationRequest = new SimpleApnsPushNotification(deviceToken, config.getTopic(), payloadRequest);

        Future<PushNotificationResponse<SimpleApnsPushNotification>> sendNotificationFuture = client.sendNotification(pushNotificationRequest);
        sendNotificationFuture.addListener(new NotificationListener());
    }

    protected ApnsClient getApnsCLient() throws IOException {
        if (client == null) {
            client = new ApnsClientBuilder()
                    .setClientCredentials(new File(config.getPath()), config.getPassword())
                    .build();
            LOGGER.info("APNS client initialized");
        }
        return client;
    }
}
