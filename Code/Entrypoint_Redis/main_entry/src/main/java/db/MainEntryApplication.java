package db;

import db.connectors.DataConnectorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = {"db"})

@EnableCaching
@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class MainEntryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainEntryApplication.class, args);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(60000);
//        requestFactory.setReadTimeout(50000);
//        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    @Primary
    @Bean
    public DataConnectorImpl getDataConnector() {
        final DataConnectorImpl connector = new DataConnectorImpl();
        return connector;
    }

}