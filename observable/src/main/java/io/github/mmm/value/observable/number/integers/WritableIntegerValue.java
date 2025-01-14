/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.integers;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Integer} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableIntegerValue extends ReadableIntegerValue, WritableNumberValue<Integer> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Integer)
   */
  default void set(int value) {

    setValue(Integer.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Integer)) {
      setValue((Integer) value);
    } else {
      setValue(Integer.valueOf(value.intValue()));
    }
  }

}
