package cn.bugstack.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamStatisticVO {
    private Integer allTeamCount;
    private Integer allTeamCompleteCount;
    private Integer allTeamUserCount;
}
