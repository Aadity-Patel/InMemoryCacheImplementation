package com.projects.InMemoryCacheImplementation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Cache<K, V> {
    private K key;
    private V value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cache<?, ?> cache = (Cache<?, ?>) o;
        return this.key == cache.key;
    }
    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
