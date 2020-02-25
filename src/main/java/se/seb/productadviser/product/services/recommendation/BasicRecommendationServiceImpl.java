package se.seb.productadviser.product.services.recommendation;

import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;
import se.seb.productadviser.product.services.recommendation.conditions.ConditionsService;

@Service
public class BasicRecommendationServiceImpl implements RecommendationService {

  private final ConditionsService conditionsService;

  public BasicRecommendationServiceImpl(
      ConditionsService conditionsService) {
    this.conditionsService = conditionsService;
  }

  @Override
  public ResponseEntity<Set<ProductDto>> advise(CustomerDto customerDto) {
    return ResponseEntity.ok(conditionsService.getProducts(customerDto));
  }
}
