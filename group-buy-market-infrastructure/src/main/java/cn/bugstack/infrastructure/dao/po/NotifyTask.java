package cn.bugstack.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyTask {
    private Integer id;
    private Long activityId;
    private String teamId;
    private String notifyUrl;
    private Integer notifyCount;
    private Integer notifyStatus;
    private String parameterJson;
    private Date createTime;
    private Date updateTime;
}
