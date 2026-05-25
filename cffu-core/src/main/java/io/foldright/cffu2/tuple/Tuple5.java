package io.foldright.cffu2.tuple;

import java.io.Serializable;
import java.util.Objects;

/**
 * Tuple5, contains 5 elements.
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 */
public final class Tuple5<T1, T2, T3, T4, T5> implements Serializable {

    private static final long serialVersionUID = -5233150935079343699L;

    public final T1 _1;

    public final T2 _2;

    public final T3 _3;

    public final T4 _4;

    public final T5 _5;

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
