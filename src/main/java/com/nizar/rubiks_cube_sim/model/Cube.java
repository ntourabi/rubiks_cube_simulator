package com.nizar.rubiks_cube_sim.model;

public class Cube {
    private Face[] faces;

    public Cube(Face[] faces) {
        this.faces = faces;
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public Face getFace(int index) {
        return faces[index];
    }

    public void setFace(int index, Face face) {
        faces[index] = face;
    }
}
