package com.shard.jdbc.config;

import com.shard.jdbc.utils.HashUtil;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;

/**
 * 数据库映射计算
 */
public class DataSourceAlg implements PreciseShardingAlgorithm<String> {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceAlg.class);
    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<String> value) {
        LOG.debug("分库算法参数 {},{}",names,value);
        int hash = HashUtil.rsHash(String.valueOf(value.getValue()));
        return "ds_" + ((hash % 2) + 2) ;
    }
}
