package redisKeyValueLearn;

import redis.clients.jedis.Jedis;

public class JedisValueStrLearn {

	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis运行:" + jedis.ping());
		/************************String类型值的相关操作*************************/
		//先清一下以前数据，重新来
		//System.out.println(jedis.flushAll());
		/*jedis.set("k1", "v1");
		String v1 = jedis.get("k1");
		System.out.println(v1);*/
		
		//数值类的自增
		/*jedis.set("k2", "5");
		System.out.println(jedis.get("k2"));
		jedis.incr("k2");
		System.out.println(jedis.get("k2"));*/
		
		//数值类的自减
		/*jedis.decr("k2");
		System.out.println(jedis.get("k2"));*/
		
		//设置过期时间
		/*jedis.setex("k3", 3, "v3");
		System.out.println(jedis.get("k3"));
		Thread.sleep(4000);
		System.out.println(jedis.get("k3"));*/
		
		//如果key不存在就设置一个这个值，如果存在则不管
		/*jedis.setnx("k4", "v4");
		System.out.println(jedis.get("k4"));*/
		//分多层级目录创建存储
		//jedis.set("a:b:c","value2");
		jedis.flushAll();
		//关闭jedis
		jedis.close();
	}

}
