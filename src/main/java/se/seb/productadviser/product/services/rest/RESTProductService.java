package se.seb.productadviser.product.services.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import se.seb.productadviser.product.dto.ProductDto;

public interface RESTProductService {

  ResponseEntity<List<ProductDto>> getAll();

  ResponseEntity<ProductDto> getOne(String id);

  ResponseEntity<Void> postOne(ProductDto productDto);

  ResponseEntity<Void> putOne(ProductDto productDto, String id);

  ResponseEntity<Void> deleteOne(String id);

}
