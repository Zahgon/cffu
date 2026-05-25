package io.foldright.cffu2.tuple;

import java.io.Serializable;
import java.util.Objects;

/**
 * Tuple2(aka Pair).
 *
 * @author Jerry Lee (oldratlee at gmail dot com)
 */
public final class Tuple2<T1, T2> implements Serializable {

    private static final long serialVersionUID = -6858695624564198288L;

    public final T1 _1;

    public final T2 _2;

    public static <T1, T2> Tuple2<T1, T2> of(T1 _1, T2 _2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
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
