package com.nizar.rubiks_cube_sim.model;

/**
 * MODEL CLASS: Face
 * Represents a face on a Rubik's Cube. Features an array to represent 9 tiles.
 * Each tile is represented by a specific colour.
 * Index 0 represents the top left. Next indices are obtained moving left to right, then  top to bottom.
 */
public class Face {
    private static final int FACE_SIZE = 9;

    private Sticker[] tiles;

    public Face(Sticker[] tiles) {
        if (tiles == null) {
            throw new IllegalArgumentException("Face object cannot have 'null' tiles.");
        } else if (tiles.length != FACE_SIZE) {
            throw new IllegalArgumentException("Face object must have exactly 9 tiles.");
        }
        this.tiles = tiles.clone();
    }

    public Sticker[] getTiles() {
        return tiles;
    }

    public void setTiles(Sticker[] tiles) {
        this.tiles = tiles;
    }

    public Sticker getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, Sticker tile) {
        tiles[index] = tile;
    }

    public static Face createSolvedFace(Sticker sticker) {
        return new Face(new Sticker[] {sticker, sticker, sticker, sticker, sticker, sticker, sticker, sticker, sticker});
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < FACE_SIZE; i++) {
            str += tiles[i].toString();
            if (i == 2 || i == 5 || i == 8) {
                str += "\n";
            }
        }
        return str;
    }
}
