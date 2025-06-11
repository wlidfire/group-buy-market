package cn.bugstack.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockMarketPayOrderResponseDTO {
    private String orderId;
    private BigDecimal deductionPrice;
    private Integer tradeOrderStatus;
}
