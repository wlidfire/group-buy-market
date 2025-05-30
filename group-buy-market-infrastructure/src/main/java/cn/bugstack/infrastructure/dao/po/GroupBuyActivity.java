package cn.bugstack.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 拼团活动信息实体类
 * 对应数据库表：group_buy_activity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyActivity {

    /* 自增ID */
    private Long id;

    /* 活动ID（唯一标识） */
    private Long activityId;

    /* 来源（如：APP、H5、小程序等，最大长度8） */
    private String source;

    /* 渠道（如：微信、支付宝、京东等，最大长度8） */
    private String channel;

    /* 商品ID（最大长度12） */
    private String goodsId;

    /* 折扣ID（最大长度8） */
    private String discountId;

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
    private LocalDateTime startTime;

    /* 活动结束时间，默认当前时间 */
    private LocalDateTime endTime;

    /* 人群标签规则标识（可为空） */
    private String tagId;

    /* 人群标签规则范围（多选；1可见限制、2参与限制） */
    private String tagScope;

    /* 创建时间 */
    private Date createTime;

    /* 更新时间 */
    private Date updateTime;
}
