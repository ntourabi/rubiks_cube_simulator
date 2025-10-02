package com.nizar.rubiks_cube_sim.service.solvingStages;

import com.nizar.rubiks_cube_sim.model.*;
import com.nizar.rubiks_cube_sim.service.CubeInteractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WhiteCrossSolver implements SolvingStage {

    CubeInteractorService cubeInteractorService;

    @Autowired
    public WhiteCrossSolver(CubeInteractorService cubeInteractorService) {
        this.cubeInteractorService = cubeInteractorService;
    }

    /**
     * The main solving method. Takes a cube and solves the white cross stage, if it has not been solved yet.
     * Stages are solved by repeatedly cycling through a process until solved.
     * 1) Locate a misplaced white edge tile.
     * 2) Pick a spot to move the white edge tile to.
     * 3) Move the white edge tile into the correct spot.
     * @param cube - The cube to be solved.
     * @return String - Sequence of operations in cubing notation to perform to get to that particular solving stage.
     */
    @Override
    public String solve(Cube cube) {
        FaceName whiteFace = getWhiteFace(cube);
        StringBuilder sequence = new StringBuilder();

        while (!whiteCrossComplete(cube.getFace(whiteFace))) {
            StickerLocation startingLocation = searchCubeForWhiteEdgeTile(cube, cube.getFace(whiteFace));
            StickerLocation targetLocation = selectUnsolvedWhiteEdgeTile(cube, whiteFace);
            sequence.append(makeMove(cube, startingLocation, targetLocation));
        }

        return sequence.toString();
    }

    /**
     * This method finds the white face by checking all faces on a given cube.
     * @param cube - The cube to search for a white face on.
     * @return FaceName - the name of the white face i.e. the face with a white middle tile.
     */
    private FaceName getWhiteFace(Cube cube) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName faceName : faces.keySet()) {
            Face face = faces.get(faceName);
            if (face.getSticker(4) == Sticker.WHITE) return faceName;
        }
        throw new RuntimeException("Couldn't find white face on cube.");
    }

    /**
     * This method checks if the current solving stage is complete.
     * @param whiteFace - A reference to the face with a white middle tile of the cube being solved.
     * @return boolean - Whether a white cross has been fully formed.
     */
    private boolean whiteCrossComplete(Face whiteFace) {
        Sticker[] tiles = whiteFace.getStickers();
        return tiles[1] == Sticker.WHITE && tiles[3] == Sticker.WHITE && tiles[5] == Sticker.WHITE && tiles[7] == Sticker.WHITE;
    }

    /**
     * This method finds a white edge tile that can be moved to its correct place.
     * An unsolved white edge tile is:
     *  - Not already on the white face, so its on one of the five other faces.
     *  - Will be in index 1, 3, 5, or 7 because it is an edge tile.
     *
     * @param cube - The cube we are currently trying to solve.
     * @param whiteFace - A reference to the face with a white middle tile.
     * @return StickerLocation - The name of the face, and the tile index (0-8).
     */
    private StickerLocation searchCubeForWhiteEdgeTile(Cube cube, Face whiteFace) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName face : faces.keySet()) {
            if (faces.get(face) == whiteFace) continue;
            if (faces.get(face).getSticker(1) == Sticker.WHITE) return new StickerLocation(face, 1);
            if (faces.get(face).getSticker(3) == Sticker.WHITE) return new StickerLocation(face, 3);
            if (faces.get(face).getSticker(5) == Sticker.WHITE) return new StickerLocation(face, 5);
            if (faces.get(face).getSticker(7) == Sticker.WHITE) return new StickerLocation(face, 7);
        }
        throw new RuntimeException("Couldn't find unsolved white edge on non-white faces.");
    }

    /**
     * This method picks an edge tile to solve from the white face.
     * @param cube - The cube we are trying to solve.
     * @param whiteFace - The name of the face with a white middle tile.
     * @return StickerLocation - A way of pinpointing the exact tile's location on the cube.
     */
    private StickerLocation selectUnsolvedWhiteEdgeTile(Cube cube, FaceName whiteFace) {
        Sticker[] tiles = cube.getFace(whiteFace).getStickers();
        if (tiles[1] != Sticker.WHITE) return new StickerLocation(whiteFace, 1);
        if (tiles[3] != Sticker.WHITE) return new StickerLocation(whiteFace, 3);
        if (tiles[5] != Sticker.WHITE) return new StickerLocation(whiteFace, 5);
        if (tiles[7] != Sticker.WHITE) return new StickerLocation(whiteFace, 7);
        throw new RuntimeException("Couldn't find unsolved white edge on white face.");
    }

    /**
     * Edge cubies have two stickers.
     * The point of this method is to find the colour of the second sticker on a cubie,
     * where the first sticker is white.
     * @param cube - The cube we are searching.
     * @param stickerLocation - The location of the white sticker on the target edge cubie.
     */
    private void findWhiteEdge_SecondColour(Cube cube, StickerLocation stickerLocation) {}

    /**
     * This method will take a misplaced white edge tile and put it in the correct spot.
     *
     * We can put an unsolved white edge into place by:
     *  - Identifying any target tile with a missing white edge (targetLocation)
     *  - Selecting any unsolved white edge piece (currentLocation)
     *  - Finding the sequence of moves necessary to move it into place.
     *
     *  We'll call the white face the top (U). The process for moving a white edge tile is as follows:
     *  - If it's on the bottom face (D), move it to the middle faces (L/F/R/B).
     *  - Move the edge to index 7 of any middle face adjacent to the face touching the targetLocation.
     *  - Perform a standard algorithm to put it into place.
     *
     * @param cube - The cube we are currently trying to solve.
     * @param currentLocation - The location of the current white tile.
     * @param targetLocation - Where we want our current white tile to end up.
     * @return String - The moves we took to solve the edge piece, using standard cube notation.
     */
    private String makeMove(Cube cube, StickerLocation currentLocation, StickerLocation targetLocation) {
        String moves = "";
        //We need to take care to avoid destroying already solved white edges.
        while (!currentLocation.equals(targetLocation)) {
            if (currentLocation.name() == FaceName.DOWN) {
                //We'd be destroying a solved white tile if the current target is vertically 3 tiles away.
                if (currentLocation.stickerIndex() == 1) {

                } else if (currentLocation.stickerIndex() == 3) {

                } else if (currentLocation.stickerIndex() == 5) {

                } else if (currentLocation.stickerIndex() == 7) {

                }
            } else {

            }
        }
        return moves;
    }
}
