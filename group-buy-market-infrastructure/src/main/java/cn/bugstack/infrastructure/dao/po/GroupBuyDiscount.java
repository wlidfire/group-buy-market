package cn.bugstack.infrastructure.dao.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyDiscount {
    private Long id;
    private Integer discountId;
    private String discountName;
    private String discountDesc;
    private Byte discountType;
    private String marketPlan;
    private String marketExpr;
    private String tagId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
