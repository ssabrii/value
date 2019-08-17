/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps;

import java.util.Map;

import net.sf.mmm.value.observable.containers.ObservableContainer;

/**
 * {@link net.sf.mmm.value.observable.containers.ObservableContainer} that is a {@link Map}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface ObservableMap<K, V>
    extends ObservableContainer<V, MapChange<K, V>, MapChangeListener<K, V>>, Map<K, V> {

}
