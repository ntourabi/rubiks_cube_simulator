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

    @Override
    public String toString() {
        //Top Layer
        String str = getFace(FaceName.UP).toString();
        //Middle Layers
        Colour[] front = getFace(FaceName.FRONT).getTiles();
        Colour[] right = getFace(FaceName.RIGHT).getTiles();
        Colour[] back = getFace(FaceName.BACK).getTiles();
        Colour[] left = getFace(FaceName.LEFT).getTiles();
        for (int i = 0; i < 3; i++) {
            str += front[3*i].toString() + front[3*i + 1].toString() + front[3*i + 2].toString() + " ";
            str += right[3*i].toString() + right[3*i + 1].toString() + right[3*i + 2].toString() + " ";
            str += back[3*i].toString() + back[3*i + 1].toString() + back[3*i + 2].toString() + " ";
            str += left[3*i].toString() + left[3*i + 1].toString() + left[3*i + 2].toString() + "\n";
        }
        //Bottom Layer
        str += getFace(FaceName.DOWN).toString();

        return str;
    }
}

