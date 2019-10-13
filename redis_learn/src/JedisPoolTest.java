import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String[] args) {
/*        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedispool","yes");
        System.out.println(jedis.get("jedispool"));
        jedis.close();*/

        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("jedispoolutils","yes");
        System.out.println(jedis.get("jedispoolutils"));
        jedis.close();
    }
}
