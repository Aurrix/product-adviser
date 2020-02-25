package se.seb.productadviser.product.dto.recommendation;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CustomerDto {

  @NotNull
  private int age;
  @NotNull
  private boolean student;
  @NotNull
  private BigDecimal income;
}
