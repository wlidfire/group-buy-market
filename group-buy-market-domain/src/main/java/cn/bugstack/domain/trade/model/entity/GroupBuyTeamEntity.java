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
public class GroupBuyTeamEntity {
    private Long activityId;
    private String teamId;
    private Integer targetCount;
    private Integer completeCount;
    private Date validStartTime;
    private Date validEndTime;
    private Integer lockCount;
    private Integer status;
    private String notifyUrl;
}