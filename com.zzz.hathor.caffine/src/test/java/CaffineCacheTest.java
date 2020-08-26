import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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

    @Test
    public  void test_caffinePut(){
      Cache cache=  Caffeine.newBuilder().maximumSize(10)
                .removalListener((key, value, cause) -> {
                    System.out.println(String.format("key %s was removed %s / %s", key, value, cause));
                }).build();
        cache.put("1","Hello");
     cache.invalidate("1");


/*        Caffeine.newBuilder().maximumWeight(10).maximumSize(10).refreshAfterWrite(10, TimeUnit.MINUTES).removalListener((o, o2, removalCause) -> {

        }).expireAfterAccess(10,TimeUnit.MINUTES).initialCapacity(10).build();*/

    }
}
