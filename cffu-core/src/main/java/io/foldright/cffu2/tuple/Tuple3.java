package io.foldright.cffu2.tuple;

import java.io.Serializable;
import java.util.Objects;

/**
 * Tuple3(aka Triple).
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 */
public final class Tuple3<T1, T2, T3> implements Serializable {

    private static final long serialVersionUID = 5884106206529157433L;

    public final T1 _1;

    public final T2 _2;

    public final T3 _3;

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 _1, T2 _2, T3 _3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Tuple3(T1 _1, T2 _2, T3 _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
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
