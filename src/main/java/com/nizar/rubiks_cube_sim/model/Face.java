package com.nizar.rubiks_cube_sim.model;

/**
 * MODEL CLASS: Face
 * Represents a face on a Rubik's Cube. Features an array to represent 9 tiles.
 * Each tile is represented by a specific colour.
 * Index 0 represents the top left. Next indices are obtained moving left to right, then  top to bottom.
 */
public class Face {
    private static final int FACE_SIZE = 9;

    private Colour[] tiles;

    public Face(Colour[] tiles) {
        if (tiles == null) {
            throw new IllegalArgumentException("Face object cannot have 'null' tiles.");
        } else if (tiles.length != FACE_SIZE) {
            throw new IllegalArgumentException("Face object must have exactly 9 tiles.");
        }
        this.tiles = tiles.clone();
    }

    public Colour[] getTiles() {
        return tiles;
    }

    public void setTiles(Colour[] tiles) {
        this.tiles = tiles;
    }

    public Colour getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, Colour tile) {
        tiles[index] = tile;
    }

    public static Face createSolvedFace(Colour colour) {
        return new Face(new Colour[] {colour, colour, colour, colour, colour, colour, colour, colour, colour});
    }
}
