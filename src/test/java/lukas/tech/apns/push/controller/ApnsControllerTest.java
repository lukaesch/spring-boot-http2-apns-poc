package lukas.tech.apns.push.controller;

import lukas.tech.apns.push.request.NotificationRequest;
import lukas.tech.apns.push.responses.NotificationResponse;
import lukas.tech.apns.push.service.NotificationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lukas on 31.08.17.
 */
@RestController
public class ApnsControllerTest {

    private static final String OK = "OK";
    private static final String SOME_TOKEN = "device123";
    private static final String SOME_MESSAGE = "Testmessage";
    private static final NotificationRequest TEST_REQUEST = new NotificationRequest(SOME_TOKEN, SOME_MESSAGE);
    private NotificationService mockService;
    private ApnsController sut;

    @Before
    public void init(){
        this.mockService = mock(NotificationService.class);
        this.sut = new ApnsController(mockService);
    }

    @Test
    public void should_send_push_notification(){
        //given
        //when
        final ResponseEntity<NotificationResponse> entity = this.sut.post(TEST_REQUEST);
        //then
        verify(this.mockService).sendNotification(SOME_TOKEN, SOME_MESSAGE);
    }
}
