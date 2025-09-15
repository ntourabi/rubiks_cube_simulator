package com.nizar.rubiks_cube_sim.model;

import java.util.HashMap;
import java.util.Map;

public class Cube {
    private Map<FaceName, Face> faces;

    public Cube(Map<FaceName, Face> faces) {
        if (faces == null) {
            throw new IllegalArgumentException("You can't create a Cube with 'null' faces.");
        }
        this.faces = new HashMap<>(faces);
    }

    //Follows traditional cube convention.
    public static Cube createSolvedCube() {
        Map<FaceName, Face> solvedFaces = new HashMap<FaceName, Face>();
        solvedFaces.put(FaceName.FRONT, Face.createSolvedFace((Colour.GREEN)));
        solvedFaces.put(FaceName.BACK, Face.createSolvedFace((Colour.BLUE)));
        solvedFaces.put(FaceName.RIGHT, Face.createSolvedFace((Colour.RED)));
        solvedFaces.put(FaceName.LEFT, Face.createSolvedFace((Colour.ORANGE)));
        solvedFaces.put(FaceName.UP, Face.createSolvedFace((Colour.WHITE)));
        solvedFaces.put(FaceName.DOWN, Face.createSolvedFace((Colour.YELLOW)));
        return new Cube(solvedFaces);
    }

    public Map<FaceName, Face> getFaces() {
        return faces;
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
}

