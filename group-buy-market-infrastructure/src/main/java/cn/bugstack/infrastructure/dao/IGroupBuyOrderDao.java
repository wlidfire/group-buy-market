package cn.bugstack.infrastructure.dao;

import cn.bugstack.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.bugstack.domain.trade.model.entity.UserGroupBuyOrderDetailEntity;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrder;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrderList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface IGroupBuyOrderDao {

    GroupBuyOrder queryGroupBuyProgress(String teamId);

    int updateAddLockCount(String teamId);

    void insert(GroupBuyOrder groupBuyOrder);

    int updateAddCompleteCount(String teamId);

    GroupBuyOrder queryGroupBuyTeamByTeamId(String teamId);

    int updateOrderStatus2COMPLETE(String teamId);

    Integer queryAllTeamCompleteCount(Set<String> teamIds);

    Integer queryAllTeamCount(Set<String> teamIds);

    Integer queryAllUserCount(Set<String> teamIds);

    List<GroupBuyOrder> queryGroupBuyProgressByTeamIds(Set<String> teamIds);
}
