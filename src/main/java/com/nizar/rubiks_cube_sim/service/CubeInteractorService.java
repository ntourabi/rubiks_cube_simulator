package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.Turn;

public interface CubeInteractorService {
    /**
     * Takes a face and repaints it to simulate a rotation.
     * @param face
     */
    public void rotateFace(Face face, Turn turn);

    /**
     * Each face has four bordering faces/edges. This will rotate the edges directly bordering one specific face.
     * @param cube
     * @param face
     * @param turn
     */
    public void rotateEdgesBorderingFace(Cube cube, Face face, Turn turn);

    /**
     * This combines rotateFace() and rotateEdgesBorderingFace.
     */
    public void makeMove(Cube cube, Face face, Turn turn);
}
