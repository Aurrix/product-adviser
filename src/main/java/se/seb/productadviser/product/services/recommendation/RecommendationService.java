package se.seb.productadviser.product.services.recommendation;

import java.util.Set;
import org.springframework.http.ResponseEntity;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;

public interface RecommendationService {

  ResponseEntity<Set<ProductDto>> advise(CustomerDto customerDto);
}
