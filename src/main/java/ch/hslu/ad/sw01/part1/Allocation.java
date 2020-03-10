package ch.hslu.ad.sw01.part1;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {

    private final int startAddress;
    private final int capacity;

    public Allocation(final int startAddress, final int capacity) {
        this.startAddress = startAddress;
        this.capacity = capacity;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.startAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Allocation)) {
            return false;
        }

        Allocation that = (Allocation) obj;
        return this.capacity == that.capacity;
    }

    @Override
    public int compareTo(Allocation allocation) {
        if (allocation != null) {
            return Integer.compare(this.startAddress, allocation.startAddress);
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "startAddress=" + startAddress +
                ", capacity=" + capacity +
                '}';
    }
}
