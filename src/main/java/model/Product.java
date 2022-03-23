package model;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Json(name = "product name")
    private String name;

    @Json(ignore = true)
    private BigDecimal price;
}
