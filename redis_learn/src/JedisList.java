import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
//        jedis.lpush("mylist","a","b","c");
//        jedis.rpush("mylist","a","b","c");
        List<String> mylist = jedis.lrange("mylist",0,-1);
        System.out.println(mylist);

        String element1 = jedis.lpop("mylist");
        String element2 = jedis.rpop("mylist");
        System.out.println(element1);
        System.out.println(element2);
        List<String> mylist2 = jedis.lrange("mylist",0,-1);
        System.out.println(mylist2);
        jedis.close();
    }
}
