package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrialBalanceEntity;
import cn.bugstack.domain.trade.model.entity.UserGroupBuyOrderDetailEntity;
import cn.bugstack.domain.trade.model.valobj.TeamStatisticVO;

import java.util.List;

public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity);

    TeamStatisticVO queryTeamStatisticByActivityId(Long activityId);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailList(Long activityId, String userId, int ownerCount, int randomCount);
}
