package cn.bugstack.types.design.framework.tree;


public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 受理执行的业务流程。每个业务流程执行时，如果有数据是从前面节点到后面节点要使用的，那么可以填充到dynamicContext上下文中
     */
    R apply(T requestParameter, D dynamicContext) throws Exception;
}
