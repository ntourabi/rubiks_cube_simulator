package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.*;

public class CubeInteractorServiceImpl implements CubeInteractorService {

    public CubeInteractorServiceImpl() {};

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
     * @param faceName
     * @param turn
     */
    @Override
    public void rotateEdgesBorderingFace(Cube cube, FaceName faceName, Turn turn) {
        //Recall that FaceEdge records tell us: which face + which three int indices.
        //Recall that each set of edges is automatically ordered for a clockwise quarter rotation.
        FaceEdge[] edges = faceName.getBorderingEdges();
        //The exact 9 tiles of each of the four faces bordering our target face.
        Colour[] f1 = cube.getFace(edges[0].face()).getTiles();
        Colour[] f2 = cube.getFace(edges[1].face()).getTiles();
        Colour[] f3 = cube.getFace(edges[2].face()).getTiles();
        Colour[] f4 = cube.getFace(edges[3].face()).getTiles();
        //Which tiles we want to specifically target corresponding to each face.
        int[] f1_indices = edges[0].edgeType().getIndices();
        int[] f2_indices = edges[1].edgeType().getIndices();
        int[] f3_indices = edges[2].edgeType().getIndices();
        int[] f4_indices = edges[3].edgeType().getIndices();
        //Save f1's edge.
        Colour[] f1_temp = {f1[f1_indices[0]], f1[f1_indices[1]], f1[f1_indices[2]]};

        if (turn == Turn.CLOCKWISE_QUARTER) {
            //Move f4's edge to f1.
            f1[f1_indices[0]] = f4[f4_indices[0]];
            f1[f1_indices[1]] = f4[f4_indices[1]];
            f1[f1_indices[2]] = f4[f4_indices[2]];
            //Move f3's edge to f4.
            f4[f4_indices[0]] = f3[f3_indices[0]];
            f4[f4_indices[1]] = f3[f3_indices[1]];
            f4[f4_indices[2]] = f3[f3_indices[2]];
            //Move f2's edge to f3.
            f3[f3_indices[0]] = f2[f2_indices[0]];
            f3[f3_indices[1]] = f2[f2_indices[1]];
            f3[f3_indices[2]] = f2[f2_indices[2]];
            //Move f1's edge (held in temp) to f2.
            f2[f2_indices[0]] = f1_temp[0];
            f2[f2_indices[1]] = f1_temp[1];
            f2[f2_indices[2]] = f1_temp[2];
        } else if (turn == Turn.ANTICLOCKWISE_QUARTER) {
            //Move f2's edge to f1.
            f1[f1_indices[0]] = f2[f2_indices[0]];
            f1[f1_indices[1]] = f2[f2_indices[1]];
            f1[f1_indices[2]] = f2[f2_indices[2]];
            //Move f3's edge to f2.
            f2[f2_indices[0]] = f3[f3_indices[0]];
            f2[f2_indices[1]] = f3[f3_indices[1]];
            f2[f2_indices[2]] = f3[f3_indices[2]];
            //Move f4's edge to f3.
            f3[f3_indices[0]] = f4[f4_indices[0]];
            f3[f3_indices[1]] = f4[f4_indices[1]];
            f3[f3_indices[2]] = f4[f4_indices[2]];
            //Move f1's edge (held in temp) to f4
            f4[f4_indices[0]] = f1_temp[0];
            f4[f4_indices[1]] = f1_temp[1];
            f4[f4_indices[2]] = f1_temp[2];
        } else if (turn == Turn.HALF) {
            //Move f3's edge to f1.
            f1[f1_indices[0]] = f3[f3_indices[0]];
            f1[f1_indices[1]] = f3[f3_indices[1]];
            f1[f1_indices[2]] = f3[f3_indices[2]];
            //Write f1 (held in temp) to f3.
            f3[f3_indices[0]] = f1_temp[0];
            f3[f3_indices[1]] = f1_temp[1];
            f3[f3_indices[2]] = f1_temp[2];
            //Save f4.
            Colour[] f4_temp = {f4[f4_indices[0]], f4[f4_indices[1]], f4[f4_indices[2]]};
            //Move f2 to f4.
            f4[f4_indices[0]] = f2[f2_indices[0]];
            f4[f4_indices[1]] = f2[f2_indices[1]];
            f4[f4_indices[2]] = f2[f2_indices[2]];
            //Write f4 (temp) to f2.
            f2[f2_indices[0]] = f4[0];
            f2[f2_indices[1]] = f4[1];
            f2[f2_indices[2]] = f4[2];
        }
    }

    /**
     * This combines rotateFace() and rotateEdgesBorderingFace().
     *
     *
     * @param cube
     * @param faceName
     * @param turn
     */
    @Override
    public void makeMove(Cube cube, FaceName faceName, Turn turn) {
        rotateFace(cube.getFace(faceName), turn);
        rotateEdgesBorderingFace(cube, faceName, turn);
    }
}
