/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.value.observable.number.doubles;

import io.github.mmm.value.observable.number.WritableNumberValue;

/**
 * {@link WritableNumberValue} with {@link Double} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableDoubleValue extends ReadableDoubleValue, WritableNumberValue<Double> {

  /**
   * @param value the new {@link #getValue() value} as primitive.
   * @see #setValue(Double)
   */
  default void set(double value) {

    setValue(Double.valueOf(value));
  }

  @Override
  default void setValueAsNumber(Number value) {

    if ((value == null) || (value instanceof Double)) {
      setValue((Double) value);
    } else {
      setValue(Double.valueOf(value.doubleValue()));
    }
  }

}
