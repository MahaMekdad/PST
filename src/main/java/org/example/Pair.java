package org.example;

public class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>>{

    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getKey() {
        return first;
    }

    public S getValue() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }

    @Override
    public int compareTo(Pair<F, S> that) {
        int cmp = this.getKey().compareTo(that.getKey());
        if (cmp == 0) cmp = this.getValue().compareTo(that.getValue());
        return cmp;
    }
}
