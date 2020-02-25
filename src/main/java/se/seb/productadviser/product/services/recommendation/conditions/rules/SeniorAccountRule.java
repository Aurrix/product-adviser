package se.seb.productadviser.product.services.recommendation.conditions.rules;

import java.util.Optional;
import org.springframework.stereotype.Component;
import se.seb.productadviser.product.Product;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;
import se.seb.productadviser.product.repository.ProductRepository;
import se.seb.productadviser.product.services.recommendation.conditions.RecommendationRule;

@Component
public class SeniorAccountRule implements RecommendationRule {

  private final ProductRepository productRepository;

  public SeniorAccountRule(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Optional<Product> validate(CustomerDto customerDto) {
    if (customerDto.getAge() > 65) {
      return Optional.ofNullable(productRepository.findByName("Senior Account"));
    }
    return Optional.empty();
  }
}
