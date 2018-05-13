package com.example.csp.model;

import java.util.Collections;
import java.util.List;

public abstract class CSP<V, D, C> {
    protected List<V> variables;

    protected List<D> domains;

    protected List<C> constraints;

    public List<V> getVariables() {
        return Collections.unmodifiableList(variables);
    }

    public List<D> getDomains() {
        return Collections.unmodifiableList(domains);
    }

    public List<C> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }
}
