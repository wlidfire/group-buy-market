package cn.bugstack.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupBuyOrderDetailEntity {
    private String userId;
    private String teamId;
    private Long activityId;
    private Integer targetCount;
    private Integer completeCount;
    private Integer lockCount;
    private Date validStartTime;
    private Date validEndTime;
    private String outTradeNo;
}
