package com.projects.InMemoryCacheImplementation.dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CacheDTO<K, V> {
    @NonNull
    public K key;
    public V value;
}
