package com.nizar.rubiks_cube_sim.model;

import java.util.Map;

public class Cube {
    private Map<FaceName, Face> faces;

    public Cube(Map<FaceName, Face> faces) {
        this.faces = faces;
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
