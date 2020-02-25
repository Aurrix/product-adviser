package se.seb.productadviser.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.seb.productadviser.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findById(String id);

  Product findByName(String name);
}
