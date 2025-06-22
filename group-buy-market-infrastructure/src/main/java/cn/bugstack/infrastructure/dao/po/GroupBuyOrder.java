package cn.bugstack.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyOrder {

    /** 自增ID */
    private String id;
    /** 拼单组队ID */
    private String teamId;
    /** 活动ID */
    private Long activityId;
    /** 渠道 */
    private String source;
    /** 来源 */
    private String channel;
    /** 原始价格 */
    private BigDecimal originalPrice;
    /** 折扣金额 */
    private BigDecimal deductionPrice;
    /** 支付价格 */
    private BigDecimal payPrice;
    /** 目标数量 */
    private int targetCount;
    /** 完成数量 */
    private int completeCount;
    /** 锁单数量 */
    private int lockCount;
    /** 状态（0-拼单中、1-完成、2-失败） */
    private String status;
    /** 拼团开始时间 */
    private Date validStartTime;
    /** 拼团结束时间 */
    private Date validEndTime;
    /** 回调地址 */
    private String notifyUrl;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
