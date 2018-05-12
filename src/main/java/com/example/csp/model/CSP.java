package com.example.csp.model;

import java.util.List;

public abstract class CSP<V, D, C> {
    protected List<V> variables;

    protected List<D> domains;

    protected List<C> constraints;
}
