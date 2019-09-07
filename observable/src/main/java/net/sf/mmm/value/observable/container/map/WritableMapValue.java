/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.container.map;

import java.util.HashMap;
import java.util.Map;

import net.sf.mmm.value.observable.container.WritableContainerValue;

/**
 * {@link WritableContainerValue} for {@link Map} {@link #getValue() value}s.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public interface WritableMapValue<K, V> extends WritableContainerValue<Map<K, V>, V>, ReadableMapValue<K, V> {

  @Override
  default Map<K, V> getOrCreateValue() {

    Map<K, V> value = getValue();
    if (value == null) {
      value = new HashMap<>();
      setValue(value);
    }
    return value;
  }

}