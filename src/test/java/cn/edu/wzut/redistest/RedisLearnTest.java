package cn.edu.wzut.redistest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;

@SpringBootTest
public class RedisLearnTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //建立连接
        //jedis = new Jedis("47.113.230.51", 6379);
        jedis = JedisConnectionFactory.getJedis();
        //设置密码
        jedis.auth("gry2219");
        //选择库
        jedis.select(0);
    }

    @Test
    void testhash() {
        //插入hash
        jedis.hset("user:1", "name", "jack");
        jedis.hset("user:1", "age", "21");

        //获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @Test
    void testString() {
        //插入数据
        String result = jedis.set("name", "虎哥");
        System.out.println("result = " + result);
        //获取数据
        String name = jedis.get("name");
        System.out.println("name =" + name);

    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}