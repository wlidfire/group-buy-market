package cn.bugstack.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 反馈的实体信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeLockRuleFilterBackEntity {

    private Integer userTakeOrderCount;

}
