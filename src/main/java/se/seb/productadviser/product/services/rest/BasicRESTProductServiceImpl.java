package se.seb.productadviser.product.services.rest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.seb.productadviser.global.exceptions.NotFoundException;
import se.seb.productadviser.product.Product;
import se.seb.productadviser.product.dto.ProductDto;
import se.seb.productadviser.product.repository.ProductRepository;

@Service
public class BasicRESTProductServiceImpl implements RESTProductService {

  private final ProductRepository productRepository;
  private final ModelMapper modelMapper;

  public BasicRESTProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public ResponseEntity<List<ProductDto>> getAll() {
    return ResponseEntity.ok(
        productRepository.findAll().stream()
            .map(product -> modelMapper.map(product, ProductDto.class))
            .collect(Collectors.toList()));
  }

  @Override
  public ResponseEntity<ProductDto> getOne(String id) {
    Product product = productRepository.findById(id);
    if (product == null) {
      throw new NotFoundException();
    }
    return ResponseEntity.ok(modelMapper.map(product, ProductDto.class));
  }

  @Override
  public ResponseEntity<Void> postOne(ProductDto productDto) {
    Product product =
        Product.builder()
            .productId(0L)
            .id(UUID.randomUUID().toString())
            .name(productDto.getName())
            .build();
    productRepository.save(product);
    return ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(product.getId())
            .toUri())
        .build();
  }

  @Override
  public ResponseEntity<Void> putOne(ProductDto productDto, String id) {
    Product product = productRepository.findById(id);
    if (product == null) {
      throw new NotFoundException();
    }
    modelMapper.map(productDto, product);
    productRepository.save(product);
    return ResponseEntity.accepted().build();
  }

  @Override
  public ResponseEntity<Void> deleteOne(String id) {
    Product product;
    product = productRepository.findById(id);
    if (product == null) {
      throw new NotFoundException();
    }
    productRepository.delete(product);
    return ResponseEntity.accepted().build();
  }
}
