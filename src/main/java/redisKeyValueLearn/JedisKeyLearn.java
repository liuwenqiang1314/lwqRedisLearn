package redisKeyValueLearn;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisKeyLearn {

	public static void main(String[] args) {
		//连接redis服务，根据jedis的构造函数可以看到有各种连接方式，可以自己灵活运用,我这里指定ip连接，因为我本地就一个redis服务。
		//这个jedis对象里包括很多操作redis的方法。基本都和命令行的差不多。此处只是讲个简单的。
		Jedis jedis = new Jedis("r-2zepr4no73qwlh6yo1.redis.rds.aliyuncs.com");
		jedis.auth("taijiashequ@123");
		jedis.select(15);
		Map<String, String> resultMap = jedis.hgetAll("callPhone");
		for (String key : resultMap.keySet()) {
			System.out.println("key= "+ key + " and value= " + resultMap.get(key));
		}
		//连接成功ping的结果是pong
		System.out.println("服务正在运行:" + jedis.ping());
		
		/*//给redis中添加键值对,设置成功返回OK
		String setResult = jedis.set("sage", "20");
		System.out.println(setResult);
		
		//查看redis的所有的keys,可以使用表达式模糊查询,*不能放到前面，
		//这个表达式是有讲究的，和sql中的模糊不完全一样,返回的是String类型的set集合
		Set<String> resultSet = jedis.keys("*");
		Iterator<String> it = resultSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println(jedis.keys(""));
		System.out.println(jedis.keys("s*"));*/
	}
}
