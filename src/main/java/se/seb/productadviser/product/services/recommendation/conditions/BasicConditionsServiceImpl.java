package se.seb.productadviser.product.services.recommendation.conditions;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import se.seb.productadviser.product.Product;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;

@Service
public class BasicConditionsServiceImpl implements ConditionsService {

  private final Set<RecommendationRule> recommendationRules;
  private final ModelMapper mapper;

  public BasicConditionsServiceImpl(
      Set<RecommendationRule> recommendationRules, ModelMapper mapper) {
    this.recommendationRules = recommendationRules;
    this.mapper = mapper;
  }

  @Override
  public Set<ProductDto> getProducts(CustomerDto customerDto) {
    Set<ProductDto> productDtos = new HashSet<>();

    recommendationRules.forEach(
        rule -> {
          Optional<Product> productOptional = rule.validate(customerDto);
          productOptional.ifPresent(
              product -> productDtos.add(mapper.map(product, ProductDto.class)));
        });

    return productDtos;
  }
}
