package org.eaudex.lego;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;


class Dataset implements Iterable<Point> {

    private final List<Point> dataPoints;

    public Dataset() {
        dataPoints = new LinkedList<Point>();
    }

    public void add(Point pt) {
        dataPoints.add(pt);
    }

    public int size() {
        return dataPoints.size();
    }

    @Override
    public Iterator<Point> iterator() {
        return dataPoints.iterator();
    }

}

