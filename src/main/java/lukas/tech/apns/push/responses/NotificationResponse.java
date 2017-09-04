package lukas.tech.apns.push.responses;

/**
 * Created by lukas on 31.08.17.
 */
public class NotificationResponse {

    private String id;

    public NotificationResponse(String id) { this.id = id; }

    public NotificationResponse() { super(); }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
