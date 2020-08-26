package cache;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CaffineCacheTest
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/26 11:13
 * @Version 1.0.0
 **/
public class CaffineCacheTest {

    public  void test_caffinePut(){
        Caffeine.newBuilder().maximumSize(10)
                .removalListener((key, value, cause) -> {
                    System.out.println(String.format("key %s was removed %s / %s", key, value, cause));
                }).build();
        Caffeine.newBuilder().maximumWeight(10).maximumSize(10).refreshAfterWrite(10, TimeUnit.MINUTES).removalListener((o, o2, removalCause) -> {

        }).expireAfterAccess(new Duration(10))

    }
}
