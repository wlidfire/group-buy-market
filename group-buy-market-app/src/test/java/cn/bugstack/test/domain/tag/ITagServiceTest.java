package cn.bugstack.test.domain.tag;

import cn.bugstack.domain.tag.service.ITagService;
import cn.bugstack.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class ITagServiceTest {

    @Resource
    private ITagService tagService;

    @Resource
    private IRedisService redisService;

    @Test
    public void test_tag_job() {
        tagService.execTagBatchJob("RQ_KJHKL98UU78H66554GFDV", "10001");
    }

    @Test
    public void test_get_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("RQ_KJHKL98UU78H66554GFDV");
        log.info("测试结果：{}", bitSet.get(redisService.getIndexFromUserId("xiaofuge")));
        log.info("测试结果：{}", bitSet.get(redisService.getIndexFromUserId("gudebai")));
    }
}
