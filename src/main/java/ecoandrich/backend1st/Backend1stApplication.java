package ecoandrich.backend1st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Backend1stApplication {

    public static void main(String[] args) {
        SpringApplication.run(Backend1stApplication.class, args);
    }

}
