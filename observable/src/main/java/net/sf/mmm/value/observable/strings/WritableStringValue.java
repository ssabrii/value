/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.strings;

import net.sf.mmm.value.WritableValue;

/**
 * {@link WritableValue} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableStringValue extends WritableValue<String>, ReadableStringValue {
 
  /**
   * @param value the value to set.
   * @see #get()
   * @see #setValue(String)
   */
  default void set(String value) {

    setValue(value);
  }

}
