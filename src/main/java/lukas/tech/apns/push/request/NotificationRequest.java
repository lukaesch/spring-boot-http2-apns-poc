package lukas.tech.apns.push.request;

/**
 * Created by lukas on 31.08.17.
 */
public class NotificationRequest {

    private String deviceToken;
    private String message;

    public NotificationRequest() { super(); }

    public NotificationRequest(String deviceToken, String message) {
        this.deviceToken = deviceToken;
        this.message = message;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
