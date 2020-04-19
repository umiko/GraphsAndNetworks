package com.umiko.graphs.models;

import java.util.Collection;

public class Node extends Vertex {
    private int parentId, distanceToRoot = Integer.MAX_VALUE, timeDiscovered, timeFinished;
    private Color color = Color.WHITE;

    //region accessors

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getDistanceToRoot() {
        return distanceToRoot;
    }

    public void setDistanceToRoot(int distanceToRoot) {
        this.distanceToRoot = distanceToRoot;
    }

    public int getTimeDiscovered() {
        return timeDiscovered;
    }

    public void setTimeDiscovered(int timeDiscovered) {
        this.timeDiscovered = timeDiscovered;
    }

    public int getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(int timeFinished) {
        this.timeFinished = timeFinished;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //endregion

    public Node(int id) {
        super(id);
    }

    public Node(int id, Collection<Integer> neighbourIds) {
        super(id, neighbourIds);
    }

    public Node(int id, IGraphRepresentation graphRepresentation) {
        super(id);
        this.neighbourIds = graphRepresentation.toEdgeList().getAdjacentNodeIds(id);
    }

    public Node(int id, int parentId, IGraphRepresentation graphRepresentation) {
        super(id);
        this.parentId = parentId;
        this.neighbourIds = graphRepresentation.toEdgeList().getAdjacentNodeIds(id);
    }

    public Collection<Integer> getChildIds() {
        Collection<Integer> neighbourIds = getNeighbourIds();
        neighbourIds.remove(parentId);
        return neighbourIds;
    }

    @Override
    public String toString() {
        if (this.getParentId() == 0) {
            return String.valueOf(this.getId()) + "\n";
        }
        return String.format("%s --> %s\n", this.getParentId(), this.getId());
    }
}