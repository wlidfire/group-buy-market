package cn.bugstack.domain.activity.model.valobj;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupBuyActivityDiscountVO {
    /* 活动ID（唯一标识） */
    private Long activityId;

    private String activityName;

    /*来源（如：APP、H5、小程序等，最大长度8）*/
    private String source;

    /*渠道（如：微信、支付宝、京东等，最大长度8）*/
    private String channel;

    /* 商品ID（最大长度12）*/
    private String goodsId;

    /* 折扣ID（最大长度8） */
    private GroupBuyDiscount groupBuyDiscount;

    /* 拼团方式（0自动成团、1达成目标拼团） */
    private Byte groupType;

    /* 拼团次数限制，默认值1 */
    private Integer takeLimitCount;

    /* 拼团目标人数，默认值1 */
    private Integer target;

    /* 拼团时长（单位：分钟），默认值15 */
    private Integer validTime;

    /* 活动状态（0创建、1生效、2过期、3废弃） */
    private Byte status;

    /* 活动开始时间，默认当前时间 */
    private Date startTime;

    /* 活动结束时间，默认当前时间 */
    private Date endTime;

    /* 人群标签规则标识（可为空） */
    private String tagId;

    /* 人群标签规则范围（多选；1可见限制、2参与限制） */
    private String tagScope;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GroupBuyDiscount {

        /* 折扣标题（最大长度64） */
        private String discountName;

        /* 折扣描述（最大长度256） */
        private String discountDesc;

        /* 折扣类型（0:base、1:tag） */
        private DiscountTypeEnum discountType;

        /* 营销优惠计划（ZJ:直减、MJ:满减、N元购） */
        private String marketPlan;

        /* 营销优惠表达式，用于计算优惠规则 */
        private String marketExpr;

        /* 人群标签，特定优惠限定（可为空） */
        private String tagId;
    }
}
