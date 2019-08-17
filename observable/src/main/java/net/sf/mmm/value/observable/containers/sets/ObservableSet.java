/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.value.observable.containers.sets;

import java.util.Set;

import net.sf.mmm.value.observable.containers.collections.ObservableCollection;

/**
 * {@link net.sf.mmm.value.observable.containers.ObservableContainer} that is a {@link Set}.
 *
 * @param <E> the type of the elements in the container.
 * @since 1.0.0
 */
public interface ObservableSet<E>
    extends ObservableCollection<E, SetChange<E>, SetChangeListener<E>>, Set<E> {

}
