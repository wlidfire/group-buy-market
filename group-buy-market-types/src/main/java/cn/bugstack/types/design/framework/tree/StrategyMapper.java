package cn.bugstack.types.design.framework.tree;

public interface StrategyMapper<T, D, R> {

    /**
     * 获取待执行策略
     *
     * T - 入参
     * D - 上下文
     * R - 返参
     *
     * 用于获取每一个要执行的节点，相当于一个流程走完进入到下一个流程的过程
     */
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;
}
