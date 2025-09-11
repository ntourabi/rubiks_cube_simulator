package com.nizar.rubiks_cube_sim.model;

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
