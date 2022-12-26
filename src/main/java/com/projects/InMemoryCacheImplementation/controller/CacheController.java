package com.projects.InMemoryCacheImplementation.controller;

import com.projects.InMemoryCacheImplementation.dto.CacheDTO;
import com.projects.InMemoryCacheImplementation.entity.Cache;
import com.projects.InMemoryCacheImplementation.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CacheController<K, V> {
    @Autowired
    private CacheService cacheService;

    @PostMapping("/add-data")
    public Map<K, Cache> addDataInToCache(@RequestBody CacheDTO dto){
        return cacheService.putElementInCache(dto.getKey(), dto.getValue());
    }


}
