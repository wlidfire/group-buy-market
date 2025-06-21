package cn.bugstack.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeSettlementRuleCommandEntity {

    private String userId;
    private String outTradeNo;
    private Date outTradeTime;
    private String source;
    private String channel;
}
