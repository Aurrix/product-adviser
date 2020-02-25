package se.seb.productadviser.product.services.recommendation.conditions;

import java.util.Set;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;

public interface ConditionsService {

  Set<ProductDto> getProducts(CustomerDto customerDto);
}
