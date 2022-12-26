package com.projects.InMemoryCacheImplementation.service;

import com.projects.InMemoryCacheImplementation.entity.Cache;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Service
public class CacheService<K, V> {

    private Deque<K> q = new LinkedList<>();
    private Map<K, Cache> map = new HashMap<>();
    int CACHE_CAPACITY = 4;
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
        return map;
    }
}
