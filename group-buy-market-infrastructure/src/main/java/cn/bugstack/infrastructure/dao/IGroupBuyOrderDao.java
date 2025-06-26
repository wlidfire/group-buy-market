package cn.bugstack.infrastructure.dao;

import cn.bugstack.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.bugstack.domain.trade.model.entity.UserGroupBuyOrderDetailEntity;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrder;
import cn.bugstack.infrastructure.dao.po.GroupBuyOrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    Integer queryAllTeamCompleteCount(@Param("teamIds") Set<String> teamIds);

    Integer queryAllTeamCount(@Param("teamIds") Set<String> teamIds);

    Integer queryAllUserCount(@Param("teamIds") Set<String> teamIds);

    List<GroupBuyOrder> queryGroupBuyProgressByTeamIds(@Param("teamIds") Set<String> teamIds);
}
