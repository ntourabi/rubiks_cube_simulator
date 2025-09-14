package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Colour;
import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.Turn;

public class CubeInteractorServiceImpl implements CubeInteractorService {
    /**
     * Takes a face and repaints it to simulate a rotation.
     *
     * @param face
     * @param turn
     */
    @Override
    public void rotateFace(Face face, Turn turn) {
        Colour[] tiles = face.getTiles();
        Colour temp1 = tiles[0];
        Colour temp2 = tiles[1];
        if (turn == Turn.CLOCKWISE_QUARTER) {
            tiles[0] = tiles[6];
            tiles[6] = tiles[8];
            tiles[8] = tiles[2];
            tiles[2] = temp1;

            tiles[1] = tiles[3];
            tiles[3] = tiles[7];
            tiles[7] = tiles[5];
            tiles[5] = temp2;
        } else if (turn == Turn.ANTICLOCKWISE_QUARTER) {
            tiles[0] = tiles[2];
            tiles[2]  = tiles[8];
            tiles[8] = tiles[6];
            tiles[6] = temp1;

            tiles[1] = tiles[5];
            tiles[5] = tiles[7];
            tiles[7] = tiles[3];
            tiles[3] = temp2;
        } else if (turn == Turn.HALF) {
            tiles[0] = tiles[8];
            tiles[8] = temp1;
            temp1 = tiles[2];
            tiles[2] = tiles[6];
            tiles[6] = temp1;

            tiles[1] = tiles[7];
            tiles[7] = temp2;
            temp2 = tiles[3];
            tiles[3] = tiles[5];
            tiles[5] = temp2;
        }
    }

    /**
     * Each face has four bordering faces/edges. This will rotate the edges directly bordering one specific face.
     *
     * @param cube
     * @param face
     * @param turn
     */
    @Override
    public void rotateEdgesBorderingFace(Cube cube, Face face, Turn turn) {

    }

    /**
     * This combines rotateFace() and rotateEdgesBorderingFace.
     *
     * @param cube
     * @param face
     * @param turn
     */
    @Override
    public void makeMove(Cube cube, Face face, Turn turn) {
        rotateFace(face, turn);
        rotateEdgesBorderingFace(cube, face, turn);
    }
}
