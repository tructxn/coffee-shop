package common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

@Component("redisFactory")
public class RedisFactory {
    private static final Logger logger = LoggerFactory.getLogger(RedisFactory.class);
    @Bean
    public Jedis createJedis(JedisConnectionFactory jedisConnectionFactory) {
        JedisShardInfo shardInfo = new JedisShardInfo(jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort());
        shardInfo.setPassword(jedisConnectionFactory.getPassword());
        Jedis jedis = new Jedis(shardInfo);
        jedis.connect();
        logger.info("start conect to redis host name " +  jedisConnectionFactory.getStandaloneConfiguration().getHostName());
        logger.info("ping redis " + jedis.ping("test ping "));
        return jedis;
    }
}
