package com.redis.redisexample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Flux;

import java.util.Map;

@SpringBootApplication
public class RedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisExampleApplication.class, args);
	}


//	@Bean
//	ApplicationRunner geography(ReactiveRedisTemplate<String ,String> template){
//		return args ->{
//			var sicily= "Sicily";
//			var geoTemplate= template.opsForGeo();
//			var mapOfPoints= Map.of(
//					"Arigneto",new Point(13.361389,38.11555556),
//					"Catania",new Point(13.361389,38.11555556),
//					"Palermo",new Point(13.361389,38.11555556)
//			);
//			Flux.fromIterable(mapOfPoints.entrySet())
//					.flatMap(e-> geoTemplate.add(sicily,e.getValue(),e.getKey()))
//					.thenMany(geoTemplate.radius(sicily,new Circle(
//							new Point(13.583333,37.31667),
//							new Distance(10, RedisGeoCommands.DistanceUnit.KILOMETERS)
//					)))
//					.map(GeoResult::getContent)
//					.map(RedisGeoCommands.GeoLocation::getName)
//					.doOnNext(System.out::println)
//					.subscribe();
//		};
//	}
//
//	@Bean
//	ApplicationRunner list(ReactiveRedisTemplate<String, String> template){
//		return args -> {
//			var listTemplate= template.opsForList();
//			var listName="spring-team";
//
//			var push = listTemplate.leftPushAll(listName,"sumit","shubham","shreyash","niraj","ram");
//			push.thenMany(listTemplate.leftPop(listName))
//					.doOnNext(System.out::println)
//					.thenMany(listTemplate.leftPop(listName))
//					.doOnNext(System.out::println)
//					.subscribe();
//		};
//	}
}


