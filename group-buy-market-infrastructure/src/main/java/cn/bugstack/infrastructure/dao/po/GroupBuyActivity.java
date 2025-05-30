package cn.bugstack.infrastructure.dao.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyActivity {
    private Long id;
    private Long activityId;
    private String source;
    private String channel;
    private String goodsId;
    private String discountId;
    private Byte groupType;
    private Integer takeLimitCount;
    private Integer target;
    private Integer validTime;
    private Byte status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String tagId;
    private String tagScope;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
