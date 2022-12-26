package com.projects.InMemoryCacheImplementation.service;

import ch.qos.logback.core.util.TimeUtil;
import com.projects.InMemoryCacheImplementation.entity.Cache;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class CacheService<K, V> {

    private Deque<K> q = new LinkedList<>();
    private Map<K, Cache> map = new HashMap<>();
    private final HashMap<K, Long> timestamps = new HashMap<>();
    int CACHE_CAPACITY = 4;

    static TimeUnit ttlUnit = TimeUnit.SECONDS;
    private static long ttl = ttlUnit.toNanos(10);
    public Map<K, Cache> putElementInCache(K key, V value)
    {
        if(map.containsKey(key))
        {
            Cache curr = map.get(key);
            q.remove(curr.getKey());
        }
        else
        {
            if(q.size() == CACHE_CAPACITY)
            {
                K temp = q.removeLast();
                map.remove(temp);
            }
        }
        Cache newItem = new Cache(key, value);
        q.addFirst((K) newItem.getKey());
        map.put(key, newItem);
        timestamps.put(key, System.nanoTime());
        return map;
    }
    public V getElementFromCache(K key)
    {
        if(map.containsKey(key)){
            Cache current = map.get(key);
            q.remove(current.getKey());
            q.addFirst((K) current.getKey());
            V value = (V) current.getValue();
            if (value != null && expired(key, value)) {
                map.remove(key);
                timestamps.remove(key);
                return (V) "Key Expired!!!";
            } else {
                return value;
            }
        }
        return (V) "Key Doesn't exist";
    }

    private boolean expired(K key, V value) {
        return (System.nanoTime() - timestamps.get(key)) > ttl;
    }

}
