package com.nizar.rubiks_cube_sim.model;

public enum FaceName {
    FRONT("F"),
    BACK("B"),
    UP("U"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("R");

    private final String notation;

    FaceName(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}
