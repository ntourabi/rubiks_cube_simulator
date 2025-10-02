package com.nizar.rubiks_cube_sim.model;

/**
 * MODEL CLASS: Face
 * Represents a face on a Rubik's Cube. Features an array to represent 9 stickers.
 * Each sticker is represented by a specific colour.
 * Index 0 represents the top left. Next indices are obtained moving left to right, then  top to bottom.
 */
public class Face {
    private static final int FACE_SIZE = 9;

    private Sticker[] stickers;

    public Face(Sticker[] stickers) {
        if (stickers == null) {
            throw new IllegalArgumentException("Face object cannot have 'null' stickers.");
        } else if (stickers.length != FACE_SIZE) {
            throw new IllegalArgumentException("Face object must have exactly 9 stickers.");
        }
        this.stickers = stickers.clone();
    }

    public Sticker[] getStickers() {
        return stickers.clone();
    }

    public void setStickers(Sticker[] stickers) {
        this.stickers = stickers;
    }

    public Sticker getSticker(int index) {
        return stickers[index];
    }

    public void setSticker(int index, Sticker sticker) {
        stickers[index] = sticker;
    }

    public static Face createSolvedFace(Sticker sticker) {
        return new Face(new Sticker[] {sticker, sticker, sticker, sticker, sticker, sticker, sticker, sticker, sticker});
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < FACE_SIZE; i++) {
            str.append(stickers[i].toString());
            if (i == 2 || i == 5 || i == 8) {
                str.append("\n");
            }
        }
        return str.toString();
    }
}
