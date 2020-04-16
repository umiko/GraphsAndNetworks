package com.umiko.graphs.models;

import java.util.Collection;

public abstract class GraphRepresentation implements IGraphRepresentation {
    protected boolean isStrict, isDirected, isWeighted;

    @Override
    public boolean isStrict() {
        return isStrict;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override
    public boolean isWeighted() {
        return isWeighted;
    }

    @Override
    public void setStrict(boolean strict) {
        isStrict = strict;
    }

    @Override
    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    @Override
    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }
}
