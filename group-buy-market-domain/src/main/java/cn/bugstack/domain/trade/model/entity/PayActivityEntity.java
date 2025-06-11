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
public class PayActivityEntity {
    private String teamId;
    private Long activityId;
    private String activityName;
    private Date startTime;
    private Date endTime;
    private Integer targetCount;
}
