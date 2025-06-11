package cn.bugstack.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GroupBuyProgressVO {

    /** 目标数量 */
    private Integer targetCount;
    /** 锁单数量 */
    private Integer lockCount;

}
