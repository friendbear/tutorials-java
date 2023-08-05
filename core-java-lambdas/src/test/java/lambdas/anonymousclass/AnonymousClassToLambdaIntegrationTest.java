package lambdas.anonymousclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnonymousClassToLambdaIntegrationTest {

    @Test
    public void whenPassingAnonymousClass_thenSuccess() {
        final SenderService emailSenderService = new EmailSenderService();

        final String emailNotification = emailSenderService.callSender(new Sender() {
            @Override
            public String send(String message) {
                return message;
            }
        });

        assertEquals(emailNotification, "Email Notification");
    }

    @Test
    public void whenPassingLambdaExpression_thenSuccess() {
        final SenderService smsSenderService = new SmsSenderService();

        final String smsNotification = smsSenderService.callSender(message -> {
            return message + " Pushed.";
        });

        assertEquals(smsNotification, "SMS Notification Pushed.");
    }
}
