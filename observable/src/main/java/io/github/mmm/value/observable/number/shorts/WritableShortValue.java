/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.shorts;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Short} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableShortValue extends ReadableShortValue, WritableNumberValue<Short> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Short)
   */
  default void set(short value) {

    setValue(Short.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Short)) {
      setValue((Short) value);
    } else {
      setValue(Short.valueOf(value.shortValue()));
    }
  }

}
