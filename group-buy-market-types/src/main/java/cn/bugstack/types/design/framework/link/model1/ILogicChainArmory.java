package cn.bugstack.types.design.framework.link.model1;

public interface ILogicChainArmory<T, D, R> {

    //获取当前节点的下一个节点
    ILogicLink<T, D, R> next();

    //设置当前节点的下一个节点
    ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next);

}
