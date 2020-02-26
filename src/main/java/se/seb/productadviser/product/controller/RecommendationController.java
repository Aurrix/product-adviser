package se.seb.productadviser.product.controller;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;
import se.seb.productadviser.product.services.recommendation.RecommendationService;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

  private final RecommendationService recommendationService;

  public RecommendationController(RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  @PostMapping
  public ResponseEntity<Set<ProductDto>> getRecommendations(
      @RequestBody @Valid CustomerDto customerDto) {
    return recommendationService.advise(customerDto);
  }
}
