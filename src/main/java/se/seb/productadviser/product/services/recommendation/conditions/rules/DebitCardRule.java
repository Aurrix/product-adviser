package se.seb.productadviser.product.services.recommendation.conditions.rules;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Component;
import se.seb.productadviser.product.Product;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;
import se.seb.productadviser.product.repository.ProductRepository;
import se.seb.productadviser.product.services.recommendation.conditions.RecommendationRule;

@Component
public class DebitCardRule implements RecommendationRule {

  private final ProductRepository productRepository;

  public DebitCardRule(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Optional<Product> validate(CustomerDto customerDto) {
    if (customerDto.getAge() > 17
        && customerDto.getIncome().compareTo(BigDecimal.valueOf(12000.00)) < 0) {
      return Optional.ofNullable(productRepository.findByName("Debit Card"));
    }
    return Optional.empty();
  }
}
