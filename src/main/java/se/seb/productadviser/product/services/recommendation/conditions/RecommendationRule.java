package se.seb.productadviser.product.services.recommendation.conditions;

import java.util.Optional;
import se.seb.productadviser.product.Product;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;

public interface RecommendationRule {

  Optional<Product> validate(CustomerDto customerDto);
}
