package cn.bugstack.infrastructure.dao;

import cn.bugstack.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrder;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrderList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGroupBuyOrderDao {

    GroupBuyOrder queryGroupBuyProgress(String teamId);

    int updateAddLockCount(String teamId);

    void insert(GroupBuyOrder groupBuyOrder);

    int updateOrderStatus2COMPLETE(String teamId);

    int updateAddCompleteCount(String teamId);

    GroupBuyOrder queryGroupBuyTeamByTeamId(String teamId);
}
