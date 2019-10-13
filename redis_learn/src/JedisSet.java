import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.sadd("myset","java","php","c++");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }
}
