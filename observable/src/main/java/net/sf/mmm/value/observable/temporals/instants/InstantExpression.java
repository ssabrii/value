package net.sf.mmm.value.observable.temporals.instants;

import java.time.Instant;

import net.sf.mmm.value.observable.booleans.BooleanBinding;
import net.sf.mmm.value.observable.temporals.DateExpression;

/**
 * {@link DateExpression} for {@link Instant} {@link #getValue() values}.
 *
 */
public interface InstantExpression extends ObservableInstantValue, DateExpression<Instant> {

  @Override
  default BooleanBinding inFuture() {

    return new BooleanBinding(() -> InstantHelper.isInFuture(getValue()));
  }

  @Override
  default BooleanBinding inPast() {

    return new BooleanBinding(() -> InstantHelper.isInPast(getValue()));
  }

}
