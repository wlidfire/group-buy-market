package cn.bugstack.types.design.framework.link.model2.chain;

import cn.bugstack.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 业务链路
 * @create 2025-01-18 10:27
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T, D, R>{

    /**
     * 调用父类 LinkedList 的构造函数，将 name 传递给父类
     * 父类通过 name 可以对链进行表示、管理或日志记录等操作
     * 作用：
     *  - 命名责任链
     *  - 初始化链结构
     *  - 支持链式执行
     */
    public BusinessLinkedList(String name) {
        super(name);
    }

    /**
     * 从头结点开始遍历链表，每个节点是 ILogicHandler，执行 apply 方法处理请求
     */
    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        Node<ILogicHandler<T, D, R>> current = this.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);

        return null;
    }

}
