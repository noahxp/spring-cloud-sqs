package tw.noah.demo;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SendSQSUtils {
    private static SqsTemplate sqsTemplate;

    public SendSQSUtils(SqsTemplate sqsTemplate){
        SendSQSUtils.sqsTemplate = sqsTemplate;
    }

    /**
     * send to aws sqs
     * @param queueName example: https://sqs.ap-northeast-1.amazonaws.com/XXXXXXXXXXX/MyQueue
     * @param data any type, it's will be converted to json string.
     * @return
     */
    public static boolean send(String queueName, Object data){
        try {
            sqsTemplate.send(queueName, data);
        } catch (Exception ex){
            log.error("send queue error:" + ex.getMessage(), ex);
            return false;
        }
        return true;
    }

}
