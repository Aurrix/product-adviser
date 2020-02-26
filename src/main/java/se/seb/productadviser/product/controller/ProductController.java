package se.seb.productadviser.product.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.services.rest.RESTProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final RESTProductService restProductService;

  public ProductController(RESTProductService restProductService) {
    this.restProductService = restProductService;
  }

  @GetMapping
  public ResponseEntity<List<ProductDto>> getAll() {
    return restProductService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getOne(@PathVariable String id) {
    return restProductService.getOne(id);
  }

  @PostMapping
  public ResponseEntity<Void> postOne(@RequestBody @Valid ProductDto productDto) {
    return restProductService.postOne(productDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> putOne(@PathVariable String id,
      @RequestBody @Valid ProductDto productDto) {
    return restProductService.putOne(productDto, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOne(@PathVariable String id) {
    return restProductService.deleteOne(id);
  }
}
