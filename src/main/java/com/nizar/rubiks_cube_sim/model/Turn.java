package com.nizar.rubiks_cube_sim.model;

/**
 * Model (Enum): Turn
 * A person's definition of clockwise can change depending on the way they look at the cube.
 * We will always assume we're directly looking at the FRONT face for rotations.
 */
public enum Turn {
    CLOCKWISE_QUARTER(""),
    ANTICLOCKWISE_QUARTER("'"),
    HALF("2");

    private final String notation;

    Turn(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}
