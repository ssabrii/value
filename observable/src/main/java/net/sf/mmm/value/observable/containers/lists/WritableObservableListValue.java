/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.lists;

import java.util.List;

import net.sf.mmm.value.observable.containers.collections.WritableObservableCollectionValue;

/**
 * {@link WritableObservableCollectionValue} for {@link ObservableList} {@link #getValue() value}s.
 *
 * @param <E> type of the {@link List#contains(Object) elements}.
 * @since 1.0.0
 */
public interface WritableObservableListValue<E>
    extends WritableObservableCollectionValue<ObservableList<E>, E>, ReadableObservableListValue<E> {

}
