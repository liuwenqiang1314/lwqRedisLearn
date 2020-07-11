package redisSubPubLearn;

import redis.clients.jedis.Jedis;

/**
 * redis的消息发布者
 * @author LWQ
 *
 */
public class RedisPublisher {

	public static void main(String[] args) {
		//建立redis服务的连接
		Jedis jedis = new Jedis("127.0.0.1");
		//打印一下连接标识看看
		System.out.println(jedis.ping());
		
		//向redis的频道发布消息
		jedis.publish("channelLWQ", "LWQ的第一次消息发布");
		//关闭
		jedis.close();

	}

}
