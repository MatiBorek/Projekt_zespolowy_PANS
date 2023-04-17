package Database;


import Database.entity.*;
import Database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Database implements CommandLineRunner{

    public static void main(String[] args) {        SpringApplication.run(Database.class, args);    }



    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProducentRepository producentRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {



        System.out.println("Loaded data");
        System.out.println("=====================================");

        System.out.println("|||||||||||||||||||||||||||||||||||||");
        printCategories();
        System.out.println("Add new category");
        categoryRepository.save(new Category("Familijna"));
        printCategories();
        System.out.println("Remove category number 1");
        categoryRepository.deleteById((long)1);
        printCategories();
        categoryRepository.updateCategoryName("Strategiczna",(long)2);
        printCategories();
        System.out.println("|||||||||||||||||||||||||||||||||||||");
        printClients();
        System.out.println("Add new client");
        clientRepository.save(new Client("Karolina"));
        printClients();
        System.out.println("Remove client number 1");
        clientRepository.deleteById((long)1);
        printClients();
        clientRepository.updateClientName("Iwona",(long)2);
        printClients();
        System.out.println("|||||||||||||||||||||||||||||||||||||");
        printCarts();
        System.out.println("Add new cart");
        cartRepository.save(new Cart("unpaid"));
        printCarts();
        System.out.println("Remove cart number 1");
        cartRepository.deleteById((long)1);
        printCarts();
        cartRepository.updateCartName("delivered", (long)2);
        printCarts();
        System.out.println("|||||||||||||||||||||||||||||||||||||");
        printProducents();
        System.out.println("Add new producent");
        producentRepository.save(new Producent("Black Mank"));
        printProducents();
        System.out.println("Remove producent number 1");
        producentRepository.deleteById((long)1);
        printProducents();
        producentRepository.updateProducentName("Black Monk",(long)2);
        printProducents();
        System.out.println("|||||||||||||||||||||||||||||||||||||");
        printProducts();
        System.out.println("Add new product");
        productRepository.save(new Product("Warcaby"));
        printProducts();
        System.out.println("Remove product number 1");
        productRepository.deleteById((long)1);
        printProducts();
        productRepository.updateProductName("Bierki",(long)2);
        printProducts();


    }



    public void printCategories(){
        System.out.println("=====================================");
        System.out.println("Categories...");
        for (Category category : categoryRepository.findAll())
        {
            System.out.println(category.toString());
        }
        System.out.println("=====================================");
    }

    public void printClients(){
        System.out.println("=====================================");
        System.out.println("Clients...");
        for (Client client : clientRepository.findAll())
        {
            System.out.println(client.toString());
        }
        System.out.println("=====================================");
    }

    public void printCarts(){
        System.out.println("=====================================");
        System.out.println("Orders...");
        for (Cart order : cartRepository.findAll())
        {
            System.out.println(order.toString());
        }
        System.out.println("=====================================");
    }

    public void printProducents(){
        System.out.println("=====================================");
        System.out.println("Producents...");
        for (Producent producent : producentRepository.findAll())
        {
            System.out.println(producent.toString());
        }
        System.out.println("=====================================");
    }

    public void printProducts(){
        System.out.println("=====================================");
        System.out.println("Products...");
        for (Product product : productRepository.findAll())
        {
            System.out.println(product.toString());
        }
        System.out.println("=====================================");
    }

}
