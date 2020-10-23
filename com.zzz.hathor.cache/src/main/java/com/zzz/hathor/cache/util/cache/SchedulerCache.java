package com.zzz.hathor.cache.util.cache;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerCache<K,V> {
	private  ConcurrentHashMap<? super K, ? super V> cachePools;
	
	private Integer initCapcity = 16;
	
	private Integer maxElements = 16;
	
	private HashMap<K, EvictKey<K>> evictKeys ;
	
	private long expireTime = -1 ;
	
	private TimeUnit timeUnit;
	
	private volatile static SchedulerCache cache ;
	
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
	
	public static <K1 ,V1> SchedulerCache<K1,V1> newBuilder() {
		return new SchedulerCache<>();
	}
	
	
	public  V get(K k) {
		return (V) cachePools.get(k);
	}
	
	public void put(K k,V v) {
		cachePools.put(k, v);
	}
	
	public SchedulerCache<K,V> initCapcity(int initsize) {
		this.initCapcity = initsize;
		return this;
	}
	
	public SchedulerCache<K,V> maxSize(int maxsize) {
		this.maxElements = maxsize;
		return this;
	}
	
	public synchronized <K,V> SchedulerCache<K,V> build () {
		if(evictKeys==null) {
			this.evictKeys = new HashMap<>();
		}
		this.cachePools = new ConcurrentHashMap<>(this.initCapcity);
		cache = this;
		cache.executor.scheduleAtFixedRate(new EvictThread(cache), 0, 100, TimeUnit.MILLISECONDS);
		return cache;
	}
	/*public boolean remove(K k) {
		this.cachePools.remove(k);
	}*/
	
	public V  remove(K k) {
		return (V) this.cachePools.remove(k);
	}
	
	public boolean isExist(K k) {
		return cachePools.containsKey(k);
	}
	
	public synchronized SchedulerCache<K,V> evict(K k , long expireTime , TimeUnit timeUnit) {
		
		EvictKey<K> key = new EvictKey<>(k,expireTime,timeUnit);
		evictKeys.put(k, key);
		return this;
	}
	
	public HashMap<K, EvictKey<K>> evictKeys () {
		return this.evictKeys;
	}
	
	public void clear() {
		
	}
	
	public static <K, V> SchedulerCache<K, V> getCache() {
		return cache;
	}
	
	public void destroyCache() {
		cachePools.clear();
		cache.executor.shutdown();
		cache=null;
	}
	public static void main(String[] args) {
		SchedulerCache<String, String > cache = SchedulerCache.newBuilder().maxSize(10)
												.initCapcity(10).evict("1",10, TimeUnit.MINUTES)
                                					.evict("2", 100, TimeUnit.SECONDS).build();
		cache.put("1", "张三");
		System.out.println(cache.get("1"));
		cache.remove("1");
		System.out.println(cache.get("1")==null);
	}
	
	
	class EvictThread implements Runnable  {
		private ConcurrentHashMap<? super K, ? super V> cachePools;
		
		private HashMap<K, EvictKey<K>> evictKeys ;

		public EvictThread(SchedulerCache<K,V> cache) {

			super();
			this.cachePools = cache.cachePools;
			this.evictKeys = cache.evictKeys;
		} 
		
		public void clean() {
			System.out.println("cleanning ");
			if(evictKeys.size() == 0 || cachePools.size() == 0) {
				//return ;
			}
			/*Set<K> keys =  evictKeys.keySet();
			for(K key : keys ) {
				System.out.println("key");
			}
			return ;*/
		}
		
		private boolean stillAlive(K k) {
			return cachePools.contains(k);
		}
		
		
		private boolean isSurvived(K k) {
			EvictKey evict= evictKeys.get(k);
			// 创建日期 和当前系统日期 进行比较
			long expire = 1;//evict.getExpireTime();
			Date createTime = evict.getPushTime();
			evict.setVisitTime(new Date());
			if(createTime != null) {
				int isOver= compareTime(evict.getPushTime(),new Date(),expire);
				if(isOver == 1 ) {
					cachePools.remove(k);
				}
			}
			return false;
		}

		
		public int compareTime(Date pre, Date next , long max) {
			try {
			SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			long preT = spf.parse(pre.toLocaleString()).getTime();
			long nextT = spf.parse( next.toLocaleString()).getTime();
			long beTween = nextT- preT;
			return beTween>=max ? 1 :0;}
			catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
				
		}
		public void run() {
			
			//System.out.println("扫描过期Key");
			// clean();
			//this.clean();
		}
		
		
		
	}
}


