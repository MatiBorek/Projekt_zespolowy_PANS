package joindemo.loaddata;

import joindemo.entity.*;
import joindemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private CategoryRepository categoryRepository;
    private ClientRepository clientRepository;

    private CartRepository cartRepository;
    private ProducentRepository producentRepository;
    private ProductRepository productRepository;

    @Autowired
    public DataLoader(CartRepository cartRepository, CategoryRepository categoryRepository, ClientRepository clientRepository, ProducentRepository producentRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.clientRepository = clientRepository;
        this.producentRepository = producentRepository;
        this.productRepository = productRepository;
    }

    public void run(ApplicationArguments args) {

        cartRepository.save(new Cart("payed"));
        categoryRepository.save(new Category("imprezowa"));
        clientRepository.save(new Client("Tadeusz"));

        producentRepository.save(new Producent("Rebel"));
        productRepository.save(new Product("Szachy"));
    }
}