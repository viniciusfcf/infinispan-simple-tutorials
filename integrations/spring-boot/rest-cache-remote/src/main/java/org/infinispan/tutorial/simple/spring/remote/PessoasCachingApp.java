package org.infinispan.tutorial.simple.spring.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching // se quiser utilizar @Cacheable
public class PessoasCachingApp {

   public static void main(String... args) {
      SpringApplication.run(PessoasCachingApp.class);
   }
}
