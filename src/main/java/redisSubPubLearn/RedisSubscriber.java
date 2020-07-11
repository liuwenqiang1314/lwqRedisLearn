package redisSubPubLearn;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 先创建一个订阅者的类，因为得先有订阅者。
 * 这个类要继承一个JedisPubSub的类。这个父类里提供各式各样的回调函数，我们重写一个，实现自己的业务。
 * 此处我的业务就是打印一下消息，没别的。
 * @author LWQ
 *
 */
public class RedisSubscriber extends JedisPubSub{
	
	/**
	 * 这是一个回调函数，当订阅者接收到发布者的消息时就会调用这个函数，所以接收到之后的业务逻辑可以写在这里
	 */
	public void onMessage(String channel, String message) {
		//写业务逻辑的，处理数据
		System.out.println("订阅频道" + channel + "的用户今天的订阅消息是:" + message);
	}
	
	/**
	 * main方法负责建立连接，实现订阅
	 * @param args
	 */
	public static void main(String[] args) {
		//建立redis服务的连接
		Jedis jedis = new Jedis("127.0.0.1");
		//打印一下连接标识看看
		System.out.println(jedis.ping());
		
		//创建一个借阅订阅的对象实例，就是一个JedisPubSub的对象，完成传参
		//而JedisPubSub是一个抽象类不能被实例化，所以创建我们自己的这个类，这是个JedisPubSub的子类
		//为什么创建自己：就是因为这个参数的传递决定你的回调函数，你传自己就会回调你自己重写的回调函数，你传一个其他的
		//子类，就会回调那个子类的回调函数，我们这里就是看看自己的业务（输出）所以传自己，实际上你可以传任意一个，但是你就得把回调的业务写在
		//你传那个类的里面了
		RedisSubscriber redisSubscriber = new RedisSubscriber();
		//从redis频道中订阅消息
		jedis.subscribe(redisSubscriber, "channelLWQ");

	}

}
