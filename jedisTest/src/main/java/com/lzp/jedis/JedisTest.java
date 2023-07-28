package com.lzp.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: LZPing
 * @date: 2022-12-07 11:44
 * @Description
 */

public class JedisTest {

    @Test
    public void testStandalone() {
        Jedis jedis = new Jedis("192.168.245.129", 6379);
        jedis.set("name", "Standalone");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
//    连接池
    public void testPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.245.129", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("name", "Pool");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    public void testCluster() {
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7003));
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7004));
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7005));
        jedisClusterNode.add(new HostAndPort("192.168.245.129", 7006));
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode);
        jedisCluster.set("name", "cluster");
        String value = jedisCluster.get("name");
        System.out.println(value);
    }


}
