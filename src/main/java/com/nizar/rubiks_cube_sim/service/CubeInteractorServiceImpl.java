package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.*;
import org.springframework.stereotype.Service;

@Service
public class CubeInteractorServiceImpl implements CubeInteractorService {

    public CubeInteractorServiceImpl() {}

    /**
     * Takes a face and repaints it to simulate a rotation.
     *
     * @param face - The target face.
     * @param turn - The type of move.
     */
    @Override
    public void rotateFace(Face face, Turn turn) {
        Sticker[] stickers = face.getStickers();
        Sticker temp1 = stickers[0];
        Sticker temp2 = stickers[1];
        if (turn == Turn.CLOCKWISE_QUARTER) {
            stickers[0] = stickers[6];
            stickers[6] = stickers[8];
            stickers[8] = stickers[2];
            stickers[2] = temp1;

            stickers[1] = stickers[3];
            stickers[3] = stickers[7];
            stickers[7] = stickers[5];
            stickers[5] = temp2;
        } else if (turn == Turn.ANTICLOCKWISE_QUARTER) {
            stickers[0] = stickers[2];
            stickers[2]  = stickers[8];
            stickers[8] = stickers[6];
            stickers[6] = temp1;

            stickers[1] = stickers[5];
            stickers[5] = stickers[7];
            stickers[7] = stickers[3];
            stickers[3] = temp2;
        } else if (turn == Turn.HALF) {
            stickers[0] = stickers[8];
            stickers[8] = temp1;
            temp1 = stickers[2];
            stickers[2] = stickers[6];
            stickers[6] = temp1;

            stickers[1] = stickers[7];
            stickers[7] = temp2;
            temp2 = stickers[3];
            stickers[3] = stickers[5];
            stickers[5] = temp2;
        }
        face.setStickers(stickers);
    }

    /**
     * Each face has four bordering faces/edges. This will rotate the edges directly bordering one specific face.
     *
     * @param cube - The cube we are transforming.
     * @param faceName - The target face.
     * @param turn - The type of move.
     */
    @Override
    public void rotateEdgesBorderingFace(Cube cube, FaceName faceName, Turn turn) {
        //Recall that StickerTripletLocation records tell us: which face + which three int indices.
        //Recall that each set of triplets is automatically ordered for a clockwise quarter rotation.
        StickerTripletLocation[] edges = faceName.getBorderingEdges();
        //The exact 9 stickers of each of the four faces bordering our target face.
        Sticker[] f1 = cube.getFace(edges[0].face()).getStickers();
        Sticker[] f2 = cube.getFace(edges[1].face()).getStickers();
        Sticker[] f3 = cube.getFace(edges[2].face()).getStickers();
        Sticker[] f4 = cube.getFace(edges[3].face()).getStickers();
        //Which stickers we want to specifically target corresponding to each face.
        int[] f1_indices = edges[0].stickerTriplet().getIndices();
        int[] f2_indices = edges[1].stickerTriplet().getIndices();
        int[] f3_indices = edges[2].stickerTriplet().getIndices();
        int[] f4_indices = edges[3].stickerTriplet().getIndices();
        //Save f1's edge.
        Sticker[] f1_temp = {f1[f1_indices[0]], f1[f1_indices[1]], f1[f1_indices[2]]};

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
            Sticker[] f4_temp = {f4[f4_indices[0]], f4[f4_indices[1]], f4[f4_indices[2]]};
            //Move f2 to f4.
            f4[f4_indices[0]] = f2[f2_indices[0]];
            f4[f4_indices[1]] = f2[f2_indices[1]];
            f4[f4_indices[2]] = f2[f2_indices[2]];
            //Write f4 (temp) to f2.
            f2[f2_indices[0]] = f4_temp[0];
            f2[f2_indices[1]] = f4_temp[1];
            f2[f2_indices[2]] = f4_temp[2];
        }
        //The exact 9 stickers of each of the four faces bordering our target face.
        cube.getFace(edges[0].face()).setStickers(f1);
        cube.getFace(edges[1].face()).setStickers(f2);
        cube.getFace(edges[2].face()).setStickers(f3);
        cube.getFace(edges[3].face()).setStickers(f4);
    }

    /**
     * This combines rotateFace() and rotateEdgesBorderingFace.
     *
     * @param cube - The cube we are transforming.
     * @param faceName - The target face.
     * @param turn - The type of move.
     */
    @Override
    public void makeMove(Cube cube, FaceName faceName, Turn turn) {
        rotateFace(cube.getFace(faceName), turn);
        rotateEdgesBorderingFace(cube, faceName, turn);
    }

    /**
     * Apply a common predefined sequence of moves (an algorithm) to the cube.
     *
     * @param cube - the cube to apply the algorithm to
     * @param algorithm - the sequence of moves
     */
    @Override
    public void applyAlgorithm(Cube cube, Algorithm algorithm) {

    }
}
