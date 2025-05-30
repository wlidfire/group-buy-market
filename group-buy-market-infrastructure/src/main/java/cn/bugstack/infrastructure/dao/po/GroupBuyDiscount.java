package cn.bugstack.infrastructure.dao.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 拼团折扣信息实体类
 * 对应数据库表：group_buy_discount
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyDiscount {
    /* 自增ID */
    private Long id;

    /* 折扣ID */
    private Integer discountId;

    /* 折扣标题（最大长度64） */
    private String discountName;

    /* 折扣描述（最大长度256） */
    private String discountDesc;

    /* 折扣类型（0:base、1:tag） */
    private Byte discountType;

    /* 营销优惠计划（ZJ:直减、MJ:满减、N元购） */
    private String marketPlan;

    /* 营销优惠表达式，用于计算优惠规则 */
    private String marketExpr;

    /* 人群标签，特定优惠限定（可为空） */
    private String tagId;

    /* 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /* 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
