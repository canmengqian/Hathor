import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
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
      Cache cache=  Caffeine.newBuilder().initialCapacity(10).maximumSize(100)
                .removalListener((key, value, cause) -> {
                    System.out.println(String.format("key %s was removed %s / %s", key, value, cause));
                }).expireAfterWrite(10,TimeUnit.SECONDS).build();
        cache.put("1","Hello");
        String value = (String) cache.getIfPresent("1");
        Assert.assertEquals("Hello",value);
        cache.invalidate("1");
        cache.invalidateAll();
/*        Caffeine.newBuilder().maximumWeight(10).maximumSize(10).refreshAfterWrite(10, TimeUnit.MINUTES).removalListener((o, o2, removalCause) -> {

        }).expireAfterAccess(10,TimeUnit.MINUTES).initialCapacity(10).build();*/

    }
    @Test
    public void test_fillPolicy() {
        /*
            手动填充
         */
        Cache cache=  Caffeine.newBuilder().initialCapacity(10).maximumSize(100)
                .removalListener((key, value, cause) -> {
                    System.out.println(String.format("key %s was removed %s / %s", key, value, cause));
                }).expireAfterWrite(10,TimeUnit.SECONDS).build();

        String val = (String) cache.get("1", func->{
            return "hello";
        });
        Assert.assertNotNull(val);
        cache =null;

        /**
         * 自动填充策略
         */
        cache=  Caffeine.newBuilder().initialCapacity(10).maximumSize(100)
                .removalListener((key, value, cause) -> {
                    System.out.println(String.format("key %s was removed %s / %s", key, value, cause));
                }).expireAfterWrite(10,TimeUnit.SECONDS).build(load->{
                    System.out.println(load.toString());
                    return load;
                });
        cache.put("1","1");
        val = (String) cache.getIfPresent("2");
        Assert.assertNull(val);
        val = (String) cache.getIfPresent("2");
        Assert.assertNotNull(val);
        Assert.assertEquals("2",val);
    }

    @Test
    public void  test_AsyncCache() {
        AsyncCache<String,CompletableFuture> cache =  Caffeine.newBuilder().buildAsync();
        cache.put("1", new CompletableFuture().thenRunAsync(()->{
            System.out.println("hello");
        }));

        cache.getIfPresent("1");
    }





}
