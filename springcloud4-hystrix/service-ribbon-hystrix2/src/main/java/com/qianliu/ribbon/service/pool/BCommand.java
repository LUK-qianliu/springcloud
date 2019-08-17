package com.qianliu.ribbon.service.pool;

import com.netflix.hystrix.*;


public class BCommand extends HystrixCommand<String> {


    public BCommand() {
        super(Setter.withGroupKey(
                //服务分组
                HystrixCommandGroupKey.Factory.asKey("BGroup"))
                //线程分组
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("BPool"))
                //线程池配置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withKeepAliveTimeMinutes(5)
                        .withMaxQueueSize(10)
                        .withQueueSizeRejectionThreshold(10000))
                .andCommandPropertiesDefaults( HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
    }

    @Override
    protected String run() throws Exception {
        return Thread.currentThread().getName();
    }
}
