package cn.bugstack.types.design.framework.link.model1;

/**
 * 定义了逻辑链节点的行为
 */
public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R> {

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
