package cn.bugstack.infrastructure.dao;

import cn.bugstack.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ISCSkuActivityDao {
    //查询拼团活动列表
    SCSkuActivity querySCSkuActivityBySCGooodsId(SCSkuActivity scSkuActivity);
}
