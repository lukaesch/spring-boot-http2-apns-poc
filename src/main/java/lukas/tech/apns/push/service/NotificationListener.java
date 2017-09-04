package lukas.tech.apns.push.service;

import com.turo.pushy.apns.PushNotificationResponse;
import com.turo.pushy.apns.util.SimpleApnsPushNotification;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lukas on 31.08.17.
 */
public class NotificationListener implements GenericFutureListener<Future<PushNotificationResponse<SimpleApnsPushNotification>>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);

    @Override
    public void operationComplete(Future<PushNotificationResponse<SimpleApnsPushNotification>> pushNotificationResponseFuture) throws Exception {
            final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse = pushNotificationResponseFuture.get();
            final SimpleApnsPushNotification pushNotification = pushNotificationResponse.getPushNotification();
            String payload = pushNotification.getPayload();

            if (pushNotificationResponse.isAccepted()) {
                LOGGER.info("Push notification accepted by APNs gateway. Payload: {}", payload );
            } else {
                LOGGER.info("Notification rejected by the APNs gateway: {} ", pushNotificationResponse.getRejectionReason());
                if (pushNotificationResponse.getTokenInvalidationTimestamp() != null) {
                    LOGGER.info("…and the token is invalid as of {}", pushNotificationResponse.getTokenInvalidationTimestamp());
                }
            }
    }
}
