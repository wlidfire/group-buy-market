package cn.bugstack.types.design.framework.link.model2.handler;

/**
 * 逻辑处理器 - 定义链中的每个节点的行为规范
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
