package io.github.mmm.value.observable.number.doubles;

import java.util.function.Supplier;

import io.github.mmm.value.ReadableValue;
import io.github.mmm.value.observable.ObservableValue;
import io.github.mmm.value.observable.number.NumberBinding;
import io.github.mmm.value.observable.number.NumberExpression;

/**
 * {@link NumberBinding} with {@link Double} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public class DoubleBinding extends NumberBinding<Double> implements DoubleExpression {

  private static final Double ZERO = Double.valueOf(0);

  /**
   * The constructor.
   *
   * @param expression the {@link Supplier} to compute the {@link #getValue() value}.
   * @param dependencies the {@link ObservableValue}s the {@code expression} depends on.
   */
  public DoubleBinding(Supplier<Double> expression, ObservableValue<?>... dependencies) {

    super(expression, dependencies);
  }

  /**
   * @param expression the {@link DoubleExpression} to negate.
   * @return a new {@link DoubleExpression} holding the negation of the {@link #getValue() value} from the given
   *         {@link DoubleExpression}.
   * @see #negate()
   */
  public static DoubleExpression negate(DoubleExpression expression) {

    return new DoubleBinding(() -> negate(expression.getValue()), expression);
  }

  /**
   * @param expression the {@link NumberExpression} to convert.
   * @return the given {@link NumberExpression} converted to a {@link DoubleExpression}.
   */
  public static DoubleExpression cast(NumberExpression<?> expression) {

    if (expression == null) {
      return null;
    } else if (expression instanceof DoubleExpression) {
      return (DoubleExpression) expression;
    } else {
      return new DoubleBinding(() -> to(expression.getValue()), expression);
    }
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param other the {@link ObservableValue} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> plus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param constant the constant {@link Number} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return add(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression} to add.
   * @param constant the constant {@code double} to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #add(ObservableDoubleValue)
   */
  public static DoubleExpression add(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> plus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to add.
   * @return a new {@link DoubleExpression} holding the sum of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression addAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> plusAll(observables), observables);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param other the {@link ObservableValue} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value}s of the first and
   *         the second given {@link ObservableValue}s.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> minus(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@link Number} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return subtract(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@code double} to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} with the given {@code constant}.
   * @see #subtract(ObservableDoubleValue)
   */
  public static DoubleExpression subtract(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> minus(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to subtract.
   * @return a new {@link DoubleExpression} holding the difference of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression subtractAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> minusAll(observables), observables);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param other the {@link ObservableValue} to multiply.
   * @return a new {@link DoubleExpression} holding the product of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #multiply(ObservableDoubleValue)
   */
  public static DoubleExpression multiply(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> mul(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@link Number} to multiply.
   * @return a new {@link DoubleExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableDoubleValue)
   */
  public static DoubleExpression multiply(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return multiply(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@code double} to multiply.
   * @return a new {@link DoubleExpression} holding the product of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} multiplied with the given {@code constant}.
   * @see #multiply(ObservableDoubleValue)
   */
  public static DoubleExpression multiply(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> mul(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to multiply.
   * @return a new {@link DoubleExpression} holding the product of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression multiplyAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> mulAll(observables), observables);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param other the {@link ObservableValue} to divide.
   * @return a new {@link DoubleExpression} holding the quotient of the {@link #getValue() value}s of the first and the
   *         second given {@link ObservableValue}s.
   * @see #divide(ObservableDoubleValue)
   */
  public static DoubleExpression divide(NumberExpression<?> expression, ObservableValue<? extends Number> other) {

    if (other == null) {
      return cast(expression);
    }
    return new DoubleBinding(() -> div(expression, other), expression, other);
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@link Number} to divide.
   * @return a new {@link DoubleExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} divided by the given {@code constant}.
   * @see #divide(ObservableDoubleValue)
   */
  public static DoubleExpression divide(NumberExpression<?> expression, Number constant) {

    if (constant == null) {
      return cast(expression);
    }
    return divide(expression, constant.doubleValue());
  }

  /**
   * @param expression the {@link DoubleExpression}.
   * @param constant the constant {@code double} to divide.
   * @return a new {@link DoubleExpression} holding the quotient of the {@link #getValue() value} from the given
   *         {@link DoubleExpression} divided by the given {@code constant}.
   * @see #divide(ObservableDoubleValue)
   */
  public static DoubleExpression divide(NumberExpression<?> expression, double constant) {

    return new DoubleBinding(() -> div(expression.getValue(), constant), expression);
  }

  /**
   * @param observables the {@link ObservableValue}s to divide.
   * @return a new {@link DoubleExpression} holding the quotient of the {@link #getValue() value}s from the given
   *         {@link ObservableValue}s.
   */
  @SafeVarargs
  public static DoubleExpression divideAll(ObservableValue<? extends Number>... observables) {

    return new DoubleBinding(() -> divAll(observables), observables);
  }

  private static Double to(Number value) {

    if (value == null) {
      return ZERO;
    } else if (value instanceof Double) {
      return (Double) value;
    } else {
      return Double.valueOf(value.doubleValue());
    }
  }

  private static Double negate(Double value) {

    if (value == null) {
      return null;
    }
    return Double.valueOf(-value.doubleValue());
  }

  @SafeVarargs
  private static Double plusAll(ReadableValue<? extends Number>... observables) {

    double sum = 0;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          sum = sum + value.doubleValue();
        }
      }
    }
    return Double.valueOf(sum);
  }

  private static Double plus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return plus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double plus(Number v1, Number v2) {

    if (v1 == null) {
      return to(v2);
    } else if (v2 == null) {
      return to(v1);
    }
    return Double.valueOf(v1.doubleValue() + v2.doubleValue());
  }

  private static Double plus(Number v1, double v2) {

    if (v1 != null) {
      return v2 = v2 + v1.doubleValue();
    }
    return Double.valueOf(v2);
  }

  @SafeVarargs
  private static Double minusAll(ReadableValue<? extends Number>... observables) {

    double difference = 0;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            difference = value.doubleValue();
          } else {
            difference = difference - value.doubleValue();
          }
        }
      }
      first = false;
    }
    return Double.valueOf(difference);
  }

  private static Double minus(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return minus(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double minus(Number v1, Number v2) {

    if (v1 == null) {
      if (v2 == null) {
        return ZERO;
      } else {
        return Double.valueOf(-v2.doubleValue());
      }
    } else if (v2 == null) {
      return to(v1);
    }
    return Double.valueOf(v1.doubleValue() - v2.doubleValue());
  }

  private static Double minus(Number v1, double v2) {

    double d1 = 0;
    if (v1 != null) {
      d1 = v1.doubleValue();
    }
    return Double.valueOf(d1 - v2);
  }

  @SafeVarargs
  private static Double mulAll(ReadableValue<? extends Number>... observables) {

    double product = 1;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable == null) {
        return ZERO;
      }
      Number value = observable.getValue();
      if (value == null) {
        return ZERO;
      }
      product = product * value.doubleValue();
    }
    return Double.valueOf(product);
  }

  private static Double mul(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return mul(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double mul(Number v1, Number v2) {

    if ((v1 == null) || (v2 == null)) {
      return ZERO;
    }
    return Double.valueOf(v1.doubleValue() * v2.doubleValue());
  }

  private static Double mul(Number v1, double v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Double.valueOf(v2 * v1.doubleValue());
  }

  @SafeVarargs
  private static Double divAll(ReadableValue<? extends Number>... observables) {

    double quotient = 1;
    boolean first = true;
    for (ReadableValue<? extends Number> observable : observables) {
      if (observable != null) {
        Number value = observable.getValue();
        if (value != null) {
          if (first) {
            quotient = value.doubleValue();
          } else {
            quotient = quotient / value.doubleValue();
          }
        }
      }
      first = false;
    }
    return Double.valueOf(quotient);
  }

  private static Double div(ReadableValue<? extends Number> v1, ReadableValue<? extends Number> v2) {

    return div(ReadableValue.unwrap(v1), ReadableValue.unwrap(v2));
  }

  private static Double div(Number v1, Number v2) {

    if (v1 == null) {
      return ZERO;
    }
    double d2 = 0;
    if (v2 != null) {
      d2 = v2.doubleValue();
    }
    return Double.valueOf(v1.doubleValue() / d2);
  }

  private static Double div(Number v1, double v2) {

    if (v1 == null) {
      return ZERO;
    }
    return Double.valueOf(v1.doubleValue() / v2);
  }

}
