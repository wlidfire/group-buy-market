package cn.bugstack.api.dto;

import lombok.Data;

/**
 * 营销商品信息
 */
@Data
public class GoodsMarketRequestDTO {
    // 用户ID
    private String userId;
    // 渠道
    private String source;
    // 来源
    private String channel;
    // 商品ID
    private String goodsId;
}
