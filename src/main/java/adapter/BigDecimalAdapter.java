package adapter;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.math.BigDecimal;

public class BigDecimalAdapter {
    @FromJson
    public BigDecimal fromJson(String value) {
        return new BigDecimal(value);
    }

    @ToJson
    public String toJson(BigDecimal value) {
        return value.toString();
    }
}
