package com.nizar.rubiks_cube_sim.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MODEL CLASS: Cube
 * A class representing the standard 3x3 Rubik's Cube.
 * Cubes have exactly 6 individually named faces (FRONT, BACK, TOP, BOTTOM, RIGHT, LEFT)
 * Solving algorithms will be applied to the cube model to generate solutions.
 */
public class Cube {
    private Map<FaceName, Face> faces;

    public Cube(Map<FaceName, Face> faces) {
        if (faces == null) {
            throw new IllegalArgumentException("You can't create a Cube with 'null' faces.");
        }
        this.faces = new HashMap<>(faces);
    }

    /**
     * Creates a solved Rubik's Cube.
     * The face/colour mapping matches standard cubing convention. For example:
     * - FRONT is GREEN, BACK is BLUE, RIGHT is RED, etc...
     * @return reference to the newly generated solved Rubik's Cube.
     */
    public static Cube createSolvedCube() {
        Map<FaceName, Face> solvedFaces = new HashMap<>();
        solvedFaces.put(FaceName.FRONT, Face.createSolvedFace((Sticker.GREEN)));
        solvedFaces.put(FaceName.BACK, Face.createSolvedFace((Sticker.BLUE)));
        solvedFaces.put(FaceName.RIGHT, Face.createSolvedFace((Sticker.RED)));
        solvedFaces.put(FaceName.LEFT, Face.createSolvedFace((Sticker.ORANGE)));
        solvedFaces.put(FaceName.UP, Face.createSolvedFace((Sticker.WHITE)));
        solvedFaces.put(FaceName.DOWN, Face.createSolvedFace((Sticker.YELLOW)));
        return new Cube(solvedFaces);
    }

    /**
     * Get an unmodifiable map of all 6 faces on the cube.
     * @return - Unmodifiable faces map.
     */
    public Map<FaceName, Face> getFaces() {
        return Collections.unmodifiableMap(faces);
    }

    public void setFaces(Map<FaceName, Face> faces) {
        this.faces = faces;
    }

    public Face getFace(FaceName faceName) {
        return faces.get(faceName);
    }

    public void setFace(FaceName faceName, Face face) {
        faces.put(faceName, face);
    }

    /**
     * Generates a human-readable visual representation of the Cube.
     * The top square naturally represents the TOP of the cube.
     * The middle 4 squares represent FRONT, RIGHT, BACK, LEFT from left-to-right.
     * The bottom square naturally represents the BOTTOM of the cube.
     * @return Cube as String.
     */
    @Override
    public String toString() {
        //Top Layer
        StringBuilder str = new StringBuilder(getFace(FaceName.UP).toString());

        //Middle Layers
        Sticker[] front = getFace(FaceName.FRONT).getStickers();
        Sticker[] right = getFace(FaceName.RIGHT).getStickers();
        Sticker[] back = getFace(FaceName.BACK).getStickers();
        Sticker[] left = getFace(FaceName.LEFT).getStickers();
        for (int i = 0; i < 3; i++) {
            str.append(front[3 * i].toString()).append(front[3 * i + 1].toString()).append(front[3 * i + 2].toString()).append(" ");
            str.append(right[3 * i].toString()).append(right[3 * i + 1].toString()).append(right[3 * i + 2].toString()).append(" ");
            str.append(back[3 * i].toString()).append(back[3 * i + 1].toString()).append(back[3 * i + 2].toString()).append(" ");
            str.append(left[3 * i].toString()).append(left[3 * i + 1].toString()).append(left[3 * i + 2].toString()).append("\n");
        }

        //Bottom Layer
        str.append(getFace(FaceName.DOWN).toString());

        return str.toString();
    }
}

