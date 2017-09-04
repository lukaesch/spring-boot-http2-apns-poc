package lukas.tech.apns.push.service;

import lukas.tech.apns.push.configuration.GlobalProperties;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * Created by lukas on 31.08.17.
 */
@Service
public class NotificationServiceTest {

    private static final String SOME_DEVICE_TOKEN = "someDeviceToken";
    private static final String SOME_MESSAGE = "someMessage";
    private static final int SOME_ID = 123;
    private static final String SOME_CERT_PATH = "somePath";
    private static final String SOME_CERT_PASSWORD = "t0pS3cr3t";
    private static final String SOME_CERT_TOPIC = "someTopic";
    private static final boolean USE_PROD = true;

    private static final GlobalProperties SOME_CONFIG = new GlobalProperties(SOME_CERT_PATH, SOME_CERT_PASSWORD, SOME_CERT_TOPIC, USE_PROD);
    private NotificationService sut;

    @Before
    public void init(){
/*        this.mockApnsService = mock(ApnsService.class);
        this.mockApnsNotification = mock(ApnsNotification.class);
        this.sut = new NotificationService(SOME_CONFIG);*/
    }

    @Ignore
    @Test
    public void should_send_notification(){
/*        //given
        NotificationService spy = spy(sut);
        doReturn(mockApnsService).when(spy).getApnsService();
        when(mockApnsNotification.getIdentifier()).thenReturn(SOME_ID);
        when(mockApnsService.push(eq(SOME_DEVICE_TOKEN), anyString())).thenReturn(mockApnsNotification);
        //when
        String id = spy.sendNotification(SOME_DEVICE_TOKEN, SOME_MESSAGE);
        //then
        verify(mockApnsService).push(eq(SOME_DEVICE_TOKEN), anyString());
        assertEquals(id, String.valueOf(SOME_ID));*/
    }
}
