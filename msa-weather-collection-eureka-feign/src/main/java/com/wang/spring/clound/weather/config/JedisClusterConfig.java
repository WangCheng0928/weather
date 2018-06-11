//package com.wang.spring.clound.weather.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @Author: wangcheng
// * @Date: Created in 13:08 2018/6/6
// */
//@Configuration
//public class JedisClusterConfig {
//
//    //注入集群节点信息
//    @Value("${spring.redis.cluster.nodes}}")
//    private String clusterNodes;
//
//    @Value("${spring.redis.timeout}")
//    private String timeout;
//
//
//
//    @Bean
//    public JedisCluster getJedisCluster(){
//        //分割集群节点
//        String[] cNodes = clusterNodes.split(",");
//        System.out.println(cNodes);
//        //创建Set集合对象
//        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
//        //循环集群节点对象
//        for (String node : cNodes){
//            String[] hp = node.split(":");
////            nodes.add(new HostAndPort(hp[0].trim(), Integer.parseInt(hp[1].trim())));
//            nodes.add(new HostAndPort(hp[0].trim(), Integer.parseInt(hp[1].endsWith("}")?hp[1].substring(0,hp[1].length()-1):hp[1])));
//        }
////        nodes.add(new HostAndPort("127.0.0.1", 7000));
////        nodes.add(new HostAndPort("127.0.0.1", 7001));
////        nodes.add(new HostAndPort("127.0.0.1", 7002));
////        nodes.add(new HostAndPort("127.0.0.1", 7003));
////        nodes.add(new HostAndPort("127.0.0.1", 7004));
////        nodes.add(new HostAndPort("127.0.0.1", 7005));
//        Integer jedisTimeOut = Integer.parseInt(timeout.substring(0,timeout.length()-1));
//
//        //创建redis集群对象
//        JedisCluster jedisCluster = new JedisCluster(nodes, jedisTimeOut, new GenericObjectPoolConfig());
//        return jedisCluster;
//    }
//}
