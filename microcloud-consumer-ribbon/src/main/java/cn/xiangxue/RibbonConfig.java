package cn.xiangxue;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className RibbonConfig
 * @date 2020/2/28  18:04
 */
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        //访问策略

        //线性轮训
        new RoundRobinRule();
        //可以重试的轮训
        new RetryRule();
        //根据运行情况来计算权重
        new WeightedResponseTimeRule();
        //过滤掉故障实例，选择请求数最小的实例
        new BestAvailableRule();
        //随机
        return new com.netflix.loadbalancer.RandomRule();
    }
}
