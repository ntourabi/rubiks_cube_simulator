package com.nizar.rubiks_cube_sim.model;

//What's clockwise depends on the way you look at the cube.
//Assume you're looking directly at the face you're rotating.
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
