package tw.noah.demo;

import java.util.HashMap;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MainApp {

    @EventListener
    public void run(ContextRefreshedEvent event){
        String queueName = "https://sqs.ap-northeast-1.amazonaws.com/XXXXXXXX/MyQueue";

        var map = new HashMap();
        map.put("name", "Tom");
        map.put("address", "Taiwan...");
        SendSQSUtils.send(queueName, map);
    }

}
