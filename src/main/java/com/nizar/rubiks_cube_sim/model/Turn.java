package com.nizar.rubiks_cube_sim.model;

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
