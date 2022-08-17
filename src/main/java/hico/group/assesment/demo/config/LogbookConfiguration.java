package hico.group.assesment.demo.config;

import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;

@Configuration
public class LogbookConfiguration {
    public Logbook logbook() {
        return Logbook.create();
    }

}
