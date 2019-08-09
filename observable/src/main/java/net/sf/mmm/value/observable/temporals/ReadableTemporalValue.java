/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporals;

import java.time.temporal.Temporal;

import net.sf.mmm.value.observable.objects.ReadableTypedObjectValue;

/**
 * {@link net.sf.mmm.value.ReadableValue} containing a {@link Temporal} {@link #getValue() value}.
 *
 * @param <V> is the generic type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface ReadableTemporalValue<V extends Temporal> extends ReadableTypedObjectValue<V> {

}