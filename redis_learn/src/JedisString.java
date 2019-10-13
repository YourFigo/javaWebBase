import redis.clients.jedis.Jedis;

public class JedisString {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.setex("activatecode",20,"hehe");
        System.out.println(jedis.get("activatecode"));
        jedis.close();
    }
}
