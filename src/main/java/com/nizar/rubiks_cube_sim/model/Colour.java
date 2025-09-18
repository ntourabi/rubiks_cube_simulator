package com.nizar.rubiks_cube_sim.model;

/**
 * ENUM: Colour
 * All possible types of tile colour on a Rubik's cube.
 */
public enum Colour {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    WHITE;

    @Override
    public String toString() {
        return switch (this) {
            case RED -> "R";
            case ORANGE -> "O";
            case YELLOW -> "Y";
            case GREEN -> "G";
            case BLUE -> "B";
            case WHITE -> "W";
        };
    }
}
