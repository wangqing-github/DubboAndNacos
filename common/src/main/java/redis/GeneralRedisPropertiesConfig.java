//package redis;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//
//@Getter
//@Setter
//@Configuration
//@ConfigurationProperties(prefix = "spring.redis.general-config")
//public class GeneralRedisPropertiesConfig {
//
//    private int minIdle;
//    private int maxIdle;
//    private int maxTotal;
//    private int maxWait;
//    private boolean testOnBorrow;
//    private boolean blockWhenExhausted;
//    private boolean testOnReturn;
//    private boolean testOnCreate;
//    private boolean testWhileIdle;
//    private int timeBetweenEvictionRunsMillis;
//    private int minEvictableIdleTimeMillis;
//    private int numTestsPerEvictionRun;
//
//    @Bean(name = "redisClientConfiguration")
//    public JedisClientConfiguration getRedisPoolConfiguration() {
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMinIdle(minIdle);
//        poolConfig.setMaxIdle(maxIdle);
//        poolConfig.setMaxTotal(maxTotal);
//        poolConfig.setMaxWaitMillis(maxWait);
//        poolConfig.setTestOnBorrow(testOnBorrow);
//        poolConfig.setBlockWhenExhausted(blockWhenExhausted);
//        poolConfig.setTestOnReturn(testOnReturn);
//        poolConfig.setTestOnCreate(testOnCreate);
//        poolConfig.setTestWhileIdle(testWhileIdle);
//        poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        poolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
//        return JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).build();
//    }
//
//    public void setRedisSerializeMethod(RedisTemplate<String,Object> redisTemplate) {
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//    }
//
//    public RedisStandaloneConfiguration generateRedisConfig(String hostName, int port, int database, String password) {
//        RedisPassword redisPassword;
//        if (StringUtils.isEmpty(password) || StringUtils.equalsIgnoreCase("none",password)) {
//            redisPassword = RedisPassword.none();
//        }else {
//            redisPassword = RedisPassword.of(password);
//        }
//        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration(hostName,port);
//        standaloneConfiguration.setDatabase(database);
//        standaloneConfiguration.setPassword(redisPassword);
//        return standaloneConfiguration;
//    }
//}
