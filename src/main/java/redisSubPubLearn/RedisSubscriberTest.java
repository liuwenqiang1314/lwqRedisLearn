package redisSubPubLearn;

import redis.clients.jedis.JedisPubSub;

/**
 * 先创建一个订阅者的类，因为得先有订阅者。
 * 这个类要继承一个JedisPubSub的类。这个父类里提供各式各样的回调函数，我们重写一个，实现自己的业务。
 * 此处我的业务就是打印一下消息，没别的。
 * @author LWQ
 *
 */
public class RedisSubscriberTest extends JedisPubSub{
	
	public void onMessage(String channel, String message) {
		System.out.println("ceshi1");
	}
}
