package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.*;

public interface CubeInteractorService {
    /**
     * Takes a face and repaints it to simulate a rotation.
     *
     * @param face - The target face.
     * @param turn - The type of move.
     */
    public void rotateFace(Face face, Turn turn);

    /**
     * Each face has four bordering faces/edges. This will rotate the edges directly bordering one specific face.
     *
     * @param cube - The cube we are transforming.
     * @param faceName - The target face.
     * @param turn - The type of move.
     */
    public void rotateEdgesBorderingFace(Cube cube, FaceName faceName, Turn turn);

    /**
     * This combines rotateFace() and rotateEdgesBorderingFace.
     *
     * @param cube - The cube we are transforming.
     * @param faceName - The target face.
     * @param turn - The type of move.
     */
    public void makeMove(Cube cube, FaceName faceName, Turn turn);

    /**
     * Apply a common predefined sequence of moves (an algorithm) to the cube.
     *
     * @param cube - the cube to apply the algorithm to
     * @param algorithm - the sequence of moves
     */
    public void applyAlgorithm(Cube cube, Algorithm algorithm);
}
