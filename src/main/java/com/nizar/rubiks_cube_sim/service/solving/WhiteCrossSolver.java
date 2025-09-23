package com.nizar.rubiks_cube_sim.service.solving;

import com.nizar.rubiks_cube_sim.model.*;

import java.util.Map;

public class WhiteCrossSolver implements SolvingStage {
    @Override
    public String solve(Cube cube) {
        FaceName whiteFace = getWhiteFace(cube);
        StringBuilder sequence = new StringBuilder();

        while (!whiteCrossComplete(cube.getFace(whiteFace))) {
            TileLocation startingLocation = searchCubeForWhiteEdgeTile(cube, cube.getFace(whiteFace));
            TileLocation targetLocation = selectUnsolvedWhiteEdgeTile(cube, whiteFace);
            sequence.append(makeMove(cube, startingLocation, targetLocation));
        }

        return sequence.toString();
    }

    private FaceName getWhiteFace(Cube cube) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName faceName : faces.keySet()) {
            Face face = faces.get(faceName);
            if (face.getTile(5) == Colour.WHITE) return faceName;
        }
        throw new RuntimeException("Couldn't find white face on cube.");
    }

    private boolean whiteCrossComplete(Face whiteFace) {
        Colour[] tiles = whiteFace.getTiles();
        return tiles[1] == Colour.WHITE && tiles[3] == Colour.WHITE && tiles[5] == Colour.WHITE && tiles[7] == Colour.WHITE;
    }

    /**
     * This method finds a white edge tile that can be moved to its correct place.
     * An unsolved white edge tile is:
     *  - Not already on the white face, so its on one of the five other faces.
     *  - Will be in index 1, 3, 5, or 7 because it is an edge tile.
     *
     * @param cube - The cube we are currently trying to solve.
     * @param whiteFace - A reference to the face with a white middle tile.
     * @return TileLocation - The name of the face, and the tile index (0-8).
     */
    private TileLocation searchCubeForWhiteEdgeTile(Cube cube, Face whiteFace) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName face : faces.keySet()) {
            if (faces.get(face) == whiteFace) continue;
            if (faces.get(face).getTile(1) == Colour.WHITE) return new TileLocation(face, 1);
            if (faces.get(face).getTile(3) == Colour.WHITE) return new TileLocation(face, 3);
            if (faces.get(face).getTile(5) == Colour.WHITE) return new TileLocation(face, 5);
            if (faces.get(face).getTile(7) == Colour.WHITE) return new TileLocation(face, 7);
        }
        throw new RuntimeException("Couldn't find unsolved white edge on non-white faces.");
    }

    /**
     * This method picks an edge tile to solve from the white face.
     * @param cube - The cube we are trying to solve.
     * @param whiteFace - The name of the face with a white middle tile.
     * @return TileLocation - A way of pinpointing the exact tile's location on the cube.
     */
    private TileLocation selectUnsolvedWhiteEdgeTile(Cube cube, FaceName whiteFace) {
        Colour[] tiles = cube.getFace(whiteFace).getTiles();
        if (tiles[1] != Colour.WHITE) return new TileLocation(whiteFace, 1);
        if (tiles[3] != Colour.WHITE) return new TileLocation(whiteFace, 3);
        if (tiles[5] != Colour.WHITE) return new TileLocation(whiteFace, 5);
        if (tiles[7] != Colour.WHITE) return new TileLocation(whiteFace, 7);
        throw new RuntimeException("Couldn't find unsolved white edge on white face.");
    }

    /**
     * This method will take a misplaced white edge tile and put it in the correct spot.
     * We can put an unsolved white edge into place by:
     *  - Identifying any target tile to solve.
     *  - Selecting any unsolved white edge piece.
     *  - Finding the sequence of moves necessary to move it into place.
     *
     * @param cube - The cube we are currently trying to solve.
     * @param currentLocation - The location of the current white tile.
     * @param targetLocation - Where we want our current white tile to end up.
     * @return String - The moves we took to solve the edge piece, using standard cube notation.
     */
    private String makeMove(Cube cube, TileLocation currentLocation, TileLocation targetLocation) {
        return "";
    }
}
