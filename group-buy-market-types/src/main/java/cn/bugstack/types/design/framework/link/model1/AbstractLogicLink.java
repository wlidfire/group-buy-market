package cn.bugstack.types.design.framework.link.model1;

public abstract class AbstractLogicLink<T, D, R> implements ILogicLink<T, D, R> {

    private ILogicLink<T, D, R> next;

    @Override
    public ILogicLink<T, D, R> next() {
        return next;
    }

    @Override
    public ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next) {
        this.next = next;
        return next;
    }

    protected R next(T requestParameter, D dynamicContext) throws Exception {
        //next是下一个节点的实例，因此调用的也是下一个节点的方法
        return next.apply(requestParameter, dynamicContext);
    }
}
