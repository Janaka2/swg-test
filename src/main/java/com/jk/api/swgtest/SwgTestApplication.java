package com.jk.api.swgtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class SwgTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwgTestApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jk.api.swgtest"))
                .build();
    }

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable("name") String name) {

        return "Hello " + name;
    }

    @PostMapping("hello")
    public String savePerson(@RequestBody Contact contact) {

        return "Hello " + contact.name;
    }

    record Contact(String name, String number) {
    }

}
