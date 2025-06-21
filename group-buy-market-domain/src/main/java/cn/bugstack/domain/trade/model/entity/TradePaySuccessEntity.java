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
public class TradePaySuccessEntity {

    private String userId;
    /** 外部交易单号 */
    private String outTradeNo;
    private Date outTradeTime;
    private Integer status;
    private String source;
    private String channel;

}
