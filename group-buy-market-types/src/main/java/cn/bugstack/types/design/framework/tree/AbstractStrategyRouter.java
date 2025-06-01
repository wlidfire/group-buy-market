package cn.bugstack.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象策略路由类 - 根据经输入参数动态选择并执行对应的策略处理器
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 通过调用策略映射器get方法，控制节点流程的走向
     */
    public R router(T requestParameter, D dynamicContext) throws Exception {
        //实现了StrategyMapper，可以直接调用get()方法
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if (null != strategyHandler) return strategyHandler.apply(requestParameter, dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

}
