package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.adapter.repository.IActivityRepository;
import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrialBalanceEntity;
import cn.bugstack.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.bugstack.domain.trade.adapter.repository.ITradeRepository;
import cn.bugstack.domain.trade.model.entity.UserGroupBuyOrderDetailEntity;
import cn.bugstack.domain.trade.model.valobj.TeamStatisticVO;
import cn.bugstack.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Resource
    private IActivityRepository repository;

    /**
     * 首页市场试算
     */
    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) {
        //获取策略处理器
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();
        //获取试算结果 - trialBalanceEntity为试算结果实体
        TrialBalanceEntity trialBalanceEntity = null;
        DefaultActivityStrategyFactory.DynamicContext dynamicContext= new DefaultActivityStrategyFactory.DynamicContext();
        try {
            trialBalanceEntity = strategyHandler.apply(marketProductEntity, dynamicContext);
            trialBalanceEntity.setGroupBuyActivityDiscountVO(dynamicContext.getGroupBuyActivityDiscountVO());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //返回试算结果
        return trialBalanceEntity;
    }

    @Override
    public TeamStatisticVO queryTeamStatisticByActivityId(Long activityId) {
        return repository.queryTeamStatisticByActivityId(activityId);
    }

    @Override
    public List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailList(Long activityId, String userId, int ownerCount, int randomCount) {
        List<UserGroupBuyOrderDetailEntity> unionAllList = new ArrayList<>();

        // 查询个人拼团数据
        if (0 != ownerCount) {
            List<UserGroupBuyOrderDetailEntity> ownerList = repository.queryInProgressUserGroupBuyOrderDetailListByOwner(activityId, userId, ownerCount);
            if (null != ownerList && !ownerList.isEmpty()){
                unionAllList.addAll(ownerList);
            }
        }

        // 查询其他非个人拼团
        if (0 != randomCount) {
            List<UserGroupBuyOrderDetailEntity> randomList = repository.queryInProgressUserGroupBuyOrderDetailListByRandom(activityId, userId, randomCount);
            if (null != randomList && !randomList.isEmpty()){
                unionAllList.addAll(randomList);
            }
        }

        return unionAllList;

    }

}