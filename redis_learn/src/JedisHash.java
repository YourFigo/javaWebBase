import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class JedisHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");
        String name = jedis.hget("user","name");
        System.out.println(name);

        Map<String,String> user = jedis.hgetAll("user");
        Set<String> keyset = user.keySet();
        for (String key : keyset){
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        jedis.close();

    }
}
