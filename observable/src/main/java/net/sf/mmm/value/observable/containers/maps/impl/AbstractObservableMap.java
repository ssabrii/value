/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.maps.impl;

import java.util.AbstractMap;
import java.util.Map;

import net.sf.mmm.event.ChangeType;
import net.sf.mmm.event.EventListener;
import net.sf.mmm.event.EventSourceAdapter;
import net.sf.mmm.value.observable.EventListenerWithChange;
import net.sf.mmm.value.observable.containers.maps.MapChange;
import net.sf.mmm.value.observable.containers.maps.MapChangeListener;
import net.sf.mmm.value.observable.containers.maps.ObservableMap;

/**
 * Abstract base implementation of mutable {@link ObservableMap}.
 *
 * @param <K> type of the {@link Map#containsKey(Object) keys}.
 * @param <V> type of the {@link Map#containsValue(Object) values}.
 * @since 1.0.0
 */
public abstract class AbstractObservableMap<K, V> extends AbstractMap<K, V> implements ObservableMap<K, V> {

  private EventSourceAdapter<MapChange<K, V>, MapChangeListener<K, V>> eventAdapter;

  private boolean changeAware;

  /**
   * The constructor.
   */
  public AbstractObservableMap() {

    super();
    this.eventAdapter = EventSourceAdapter.empty();
    this.changeAware = false;
  }

  @Override
  public void addListener(MapChangeListener<K, V> listener, boolean weak) {

    this.eventAdapter = this.eventAdapter.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(MapChangeListener<K, V> listener) {

    EventSourceAdapter<MapChange<K, V>, MapChangeListener<K, V>> adapter = this.eventAdapter.removeListener(listener);
    if (adapter == null) {
      return false;
    }
    this.eventAdapter = adapter;
    return true;
  }

  /**
   * @return {@code true} if at least one {@link MapChangeListener} is {@link #addListener(MapChangeListener, boolean)
   *         registered}, {@code false} otherwise.
   */
  protected boolean hasListeners() {

    return this.eventAdapter.hasListeners();
  }

  /**
   * @return {@code true} if modification events should be generated (at least one <b>active</b> or multiple listeners
   *         registered), {@code false} otherwise.
   */
  protected boolean isObserved() {

    int listenerCount = this.eventAdapter.getListenerCount();
    if (listenerCount == 0) {
      return false;
    }
    if (listenerCount == 1) {
      EventListener<? super MapChange<K, V>> listener = this.eventAdapter.getRawListener(0);
      if (listener == null) {
        return false;
      }
      if (listener instanceof EventListenerWithChange) {
        // performance tweak - if there is only one listener available and that is
        // change aware it can toggle change events
        boolean changeAware = ((EventListenerWithChange<?>) listener).isChangeAware();
      }
    }
    // TODO
    return true;
  }

  /**
   * @param modification the {@link MapChange} to {@link MapChangeListener#onEvent(Object) send} to all
   *        {@link #addListener(MapChangeListener, boolean) registered} {@link MapChangeListener}s.
   */
  protected void fireEvent(MapChange<K, V> modification) {

    if (modification == null) {
      return;
    }
    this.eventAdapter.fireEvent(modification);
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#UPDATE update} event.
   *
   * @param keys the keys of the values that have been updated.
   */
  protected void fireUpdate(Object... keys) {

    if (!isObserved()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.UPDATE, keys));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#ADD add} event.
   *
   * @param keys the keys of the values that have been inserted.
   */
  protected void fireAdd(Object... keys) {

    if (!isObserved()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, ChangeType.ADD, keys));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#REMOVE remove} event.
   *
   * @param keys the keys that have been removed.
   * @param values the values that have been removed in the order corresponding to the {@code keys}.
   */
  protected void fireRemove(Object[] keys, Object[] values) {

    if (!isObserved()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, keys, values));
  }

  /**
   * {@link #fireEvent(MapChange) Fires} an {@link ChangeType#REMOVE remove} event.
   *
   * @param key the key that has been removed.
   * @param value the value that has been removed.
   */
  protected void fireRemove(Object key, Object value) {

    if (!isObserved()) {
      return;
    }
    fireEvent(new MapChangeImpl<>(this, new Object[] { key }, new Object[] { value }));
  }

  /**
   * @return the {@link MapChange} event for the remove of all entries or {@code null} if not {@link #isObserved()
   *         observed} or {@link #isEmpty() empty}.
   */
  protected MapChange<K, V> modRemoveAll() {

    if (isObserved()) {
      return null;
    }
    int size = size();
    if (size == 0) {
      return null;
    }
    Object[] keys = new Object[size];
    Object[] values = new Object[size];
    int i = 0;
    for (Entry<K, V> entry : entrySet()) {
      keys[i] = entry.getKey();
      values[i] = entry.getValue();
    }
    return new MapChangeImpl<>(this, keys, values);
  }

}
