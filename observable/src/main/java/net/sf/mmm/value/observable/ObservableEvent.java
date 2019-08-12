/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable;

/**
 * Event notifying about changes of an {@link ObservableValue}.
 *
 * @param <V> type of observed {@link ObservableValue#getValue() value}.
 * @since 1.0.0
 * @see ObservableEventListener
 * @see ObservableValue
 */
public interface ObservableEvent<V> {

  /**
   * @return the {@link ObservableValue} that changed and send this event.
   */
  ObservableValue<V> getObservable();

  /**
   * @return the current {@link ObservableValue#getValue() value}.
   */
  V getValue();

  /**
   * @return the {@link ObservableValue#getValue() value} before the change. May be {@code null} if the previous value
   *         was {@code null} or {@link #hasOldValue() the old value is not available}.
   */
  V getOldValue();

  /**
   * @return {@code true} if the old value is available, {@code false} otherwise. For advanced performance the old value
   *         is not available for dynamically computed {@link ObservableValue}s by default. It is guaranteed to be
   *         available if at least one of the {@link ObservableValue#addListener(net.sf.mmm.event.EventListener)
   *         registered} {@link ObservableEventListener}s has called {@link #getValue()} on the previous
   *         {@link ObservableEvent} forcing an eager evaluation.
   */
  boolean hasOldValue();

  /**
   * @param <M> type of the modification.
   * @return the modification in case of a {@link #isModification() value change}, {@code null} otherwise.
   * @see net.sf.mmm.value.observable.containers.lists.ListModification
   * @see net.sf.mmm.value.observable.containers.maps.MapModification
   * @see net.sf.mmm.value.observable.containers.sets.SetModification
   */
  <M> M getModification();

  /**
   * @return {@code true} if the {@link #getValue() value} object instance itself has been modified. Most
   *         {@link ObservableValue}s contain immutable value types (such as {@link String}, {@link Boolean},
   *         {@link Integer}, {@link java.math.BigDecimal}, {@link java.time.Instant}, etc.). However, values like e.g.
   *         {@link java.util.Collection} are mutable and may support notifying {@link #getModification()
   *         modifications}. Otherwise, if {@code false} the {@link #getObservable() observable} itself was modified and
   *         its {@link #getValue() value} has changed (or was invalidated and needs to be recalculated).
   * @see #getModification()
   */
  default boolean isModification() {

    return (getModification() != null);
  }

}
