package lukas.tech.apns.push.controller;

import lukas.tech.apns.push.request.NotificationRequest;
import lukas.tech.apns.push.responses.NotificationResponse;
import lukas.tech.apns.push.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by lukas on 31.08.17.
 */
@RestController
public class ApnsController {

    private final NotificationService service;

    @Autowired
    public ApnsController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notifications", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationResponse> post(@RequestBody @Valid NotificationRequest notificationRequest) {
        service.sendNotification(notificationRequest.getDeviceToken(), notificationRequest.getMessage());
        return new ResponseEntity<>(new NotificationResponse(), HttpStatus.CREATED);
    }
}
