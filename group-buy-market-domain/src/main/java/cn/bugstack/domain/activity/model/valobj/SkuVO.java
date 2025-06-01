package cn.bugstack.domain.activity.model.valobj;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuVO {

    /* 商品ID */
    private String goodsId;

    /* 商品名称 */
    private String goodsName;

    /* 商品价格 */
    private BigDecimal originalPrice;

}
