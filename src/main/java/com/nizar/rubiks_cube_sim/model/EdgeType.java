package com.nizar.rubiks_cube_sim.model;

public enum EdgeType {
    TOP_EDGE(new int[]{1, 2, 3}),
    BOTTOM_EDGE(new int[]{7, 8, 9}),
    LEFT_EDGE(new int[]{1, 4, 7}),
    RIGHT_EDGE(new int[]{3, 6, 9});

    private int[] values;

    EdgeType(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }
}
