package org.vertexium;

import org.vertexium.util.ArrayIterable;

import java.util.Arrays;
import java.util.Iterator;

public class Path implements Iterable<String> {
    private final String[] vertexIds;

    public Path(String... vertexIds) {
        this.vertexIds = vertexIds;
    }

    public Path(Path path, String vertexId) {
        this.vertexIds = Arrays.copyOf(path.vertexIds, path.vertexIds.length + 1);
        this.vertexIds[this.vertexIds.length - 1] = vertexId;
    }

    public int length() {
        return this.vertexIds.length;
    }

    public String get(int i) {
        return this.vertexIds[i];
    }

    @Override
    public Iterator<String> iterator() {
        return new ArrayIterable<>(this.vertexIds).iterator();
    }

    @Override
    public String toString() {
        return Arrays.toString(vertexIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Path pathOther = (Path) o;
        if (pathOther.vertexIds.length != vertexIds.length) {
            return false;
        }
        for (int i = 0; i < vertexIds.length; i++) {
            if (!pathOther.vertexIds[i].equals(vertexIds[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertexIds);
    }
}
