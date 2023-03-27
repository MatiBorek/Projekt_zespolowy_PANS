package joindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 @SpringBootApplication
public class Application implements CommandLineRunner {

     public static void main(String[] args) {

         SpringApplication.run(Application.class, args);
     }

     @Autowired
     private ClientRepository clientRepository;

     @Autowired
     private OrderRepository orderRepository;

     @Autowired
     private ProductRepository productRepository;

     @Override
     public void run(String... args) {



     }
 }
