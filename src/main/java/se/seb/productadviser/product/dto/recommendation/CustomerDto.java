package se.seb.productadviser.product.dto.recommendation;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

  @NotNull(message = "Age must be present")
  @Min(value = 16, message = "Too young")
  @Max(value = 120, message = "Too dead")
  private int age;

  @NotNull(message = "Is student must be present")
  private boolean student;

  @NotNull(message = "Income must be present")
  @Min(value = 0, message = "Income cannot be negative")
  private BigDecimal income;
}
