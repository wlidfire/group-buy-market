package cn.bugstack.domain.trade.model.entity;

import cn.bugstack.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketPayOrderEntity {

    private String orderId;
    private BigDecimal deductionPrice;
    private TradeOrderStatusEnumVO tradeOrderStatusEnumVO;

}
