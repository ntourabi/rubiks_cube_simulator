package com.nizar.rubiks_cube_sim.model;

/**
 * MODEL CLASS: Face
 * Represents a face on a Rubik's Cube. Features an array to represent 9 tiles.
 * Each tile is represented by a specific colour.
 * Index 0 represents the top left. Next indices are obtained moving left to right, then  top to bottom.
 */
public class Face {
    private Colour[] tiles;

    public Face(Colour[] tiles) {
        this.tiles = tiles;
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

}
