/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.temporal.instant;

import java.time.Instant;

import net.sf.mmm.value.observable.temporal.WritableTemporalValue;

/**
 * {@link net.sf.mmm.value.WritableValue} containing a {@link Instant} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface WritableInstantValue extends ReadableInstantValue, WritableTemporalValue<Instant> {

}