package com.entrenamosuy.tarea1.util;

import java.util.Objects;

public class Triple<T, U, S> {

    private final T first;

    private final U second;

    private final S third;

    public Triple(T first, U second, S third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public S getThird() {
        return third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Triple<?, ?, ?> other = (Triple<?, ?, ?>) obj;
        return first.equals(other.first) && second.equals(other.second)
                && third.equals(other.third);
    }
}
