package com.bitop.testflink.redis;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

public class RedisExampleMapper implements RedisMapper<Tuple2<String, String>> {
    @Override
    public RedisCommandDescription getCommandDescription() {
        return new RedisCommandDescription(RedisCommand.HSET, "HASH_NAME");
    }

    @Override
    public String getKeyFromData(Tuple2<String, String> stringStringTuple2) {
        return stringStringTuple2.f0;
    }

    @Override
    public String getValueFromData(Tuple2<String, String> stringStringTuple2) {
        return stringStringTuple2.f1;
    }
//
//    FlinkJedisPoolConfig conf = new FlinkJedisPoolConfig.Builder().setHost("127.0.0.1").build();
//
//    DataStream<String> stream = ...;
//stream.addSink(new RedisSink<Tuple2<String, String>>(conf, new RedisExampleMapper());
}
