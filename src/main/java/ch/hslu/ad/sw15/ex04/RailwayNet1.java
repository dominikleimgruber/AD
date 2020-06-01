package ch.hslu.ad.sw15.ex04;

import java.util.ArrayList;
import java.util.List;

public class RailwayNet1 {

    private final int noOfNodes;
    private final String[] nodeName;
    private final int[][] adjaMx;
    private int noOfConnections;

    public RailwayNet1(String... nodeName) {
        this.noOfNodes = nodeName.length;
        this.nodeName = nodeName;
        this.adjaMx = new int[noOfNodes][noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                adjaMx[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    public void removeEdge(final String from, final String to) {
        int indexFrom = findIndex(from);
        int indexTo = findIndex(to);

        adjaMx[indexFrom][indexTo] = Integer.MAX_VALUE;
        adjaMx[indexTo][indexFrom] = Integer.MAX_VALUE;
    }

    public String getNodeName(final int k) {
        if (k < nodeName.length && k >= 0) {
            return nodeName[k];
        }
        throw new IllegalArgumentException("invalid index");
    }

    public int getDuration(final String from, final String to) {
        return adjaMx[findIndex(from)][findIndex(to)];
    }

    public int getNoOfConnections() {
        return noOfConnections;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public boolean isDirectEdge(final String from, final String to) {
        int indexFrom = findIndex(from);
        int indexTo = findIndex(to);
        return adjaMx[indexFrom][indexTo] < Integer.MAX_VALUE;
    }

    public void addConnection(final String from, final String to, final int duration) {
        int indexFrom = findIndex(from);
        int indexTo = findIndex(to);

        if (duration < 0) {
            throw new IllegalArgumentException("non-realistic value for duration");
        }

        if (adjaMx[indexFrom][indexTo] == Integer.MAX_VALUE && adjaMx[indexTo][indexFrom] == Integer.MAX_VALUE) {
            noOfConnections++;
        }
        adjaMx[indexFrom][indexTo] = duration;
        adjaMx[indexTo][indexFrom] = duration;
    }

    public List<String> getDirectConnectedNodes(final String from) {
        List<String> connected = new ArrayList<>();
        for (String station : nodeName) {
            if (isDirectEdge(station, from)) {
                connected.add(station);
            }
        }
        return connected;
    }

    private int findIndex(String station) {
        for (int i = 0; i < noOfNodes; i++) {
            if (station.equals(nodeName[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("Station " + station + " does not exist");
    }

}
