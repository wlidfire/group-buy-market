package cn.bugstack.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockMarketPayOrderRequestDTO {

    private String userId;
    private String teamId;
    private Long activityId;
    private String goodsId;
    private String source;
    private String channel;
    private String outTradeNo;
}
