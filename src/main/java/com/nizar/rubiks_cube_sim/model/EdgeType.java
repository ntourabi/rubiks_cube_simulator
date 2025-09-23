package com.nizar.rubiks_cube_sim.model;

/**
 * Each enum value refers to three tiles on one of any particular cube faces.
 * - TOP_EDGE: The three top tiles (indices 0,1,2)
 * - BOTTOM_EDGE: The three bottom tiles (indices 6,7,8)
 * - LEFT_EDGE: The three left tiles (indices 0,3,6)
 * - RIGHT_EDGE: The three right tiles (indices 2,5,8)
 */
public enum EdgeType {
    TOP_EDGE(new int[]{0, 1, 2}),
    BOTTOM_EDGE(new int[]{6, 7, 8}),
    LEFT_EDGE(new int[]{0, 3, 6}),
    RIGHT_EDGE(new int[]{2, 5, 8});

    private int[] indices;

    EdgeType(int[] indices) {
        this.indices = indices;
    }

    public int[] getIndices() {
        return indices;
    }
}
