package egen.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MainClass {
    public static void main(String []args){
        SpringApplication app= new SpringApplication(MainClass.class);
        app.run();

    }
}
