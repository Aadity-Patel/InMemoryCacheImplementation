package com.projects.InMemoryCacheImplementation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cache<K, V> {
    private K key;
    private V value;
}
