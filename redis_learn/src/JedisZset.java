import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisZset {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.zadd("mysortset",2,"亚瑟");
        jedis.zadd("mysortset",34,"后裔");
        jedis.zadd("mysortset",18,"孙悟空");
        Set<String> mysortset = jedis.zrange("mysortset",0,-1);
        System.out.println(mysortset);
        jedis.close();
    }
}
