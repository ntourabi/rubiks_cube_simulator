package com.nizar.rubiks_cube_sim.model;

/**
 * MODEL CLASS: Face
 * Represents a face on a Rubik's Cube. Features a 2D array to represent 9 tiles.
 * Each tile is represented by a specific colour.
 * Each subarray is an entire row. Each subarray element represents a particular column in that row.
 */
public class Face {
    private Colour[][] tiles;

    public Face(Colour[][] tiles) {
        this.tiles = tiles;
    }

    public Colour[][] getTiles() {
        return tiles;
    }

    public void setTiles(Colour[][] tiles) {
        this.tiles = tiles;
    }

    public Colour getTile(int row, int column) {
        return tiles[row][column];
    }

    public void setTile(int row, int column, Colour tile) {
        tiles[row][column] = tile;
    }

}
