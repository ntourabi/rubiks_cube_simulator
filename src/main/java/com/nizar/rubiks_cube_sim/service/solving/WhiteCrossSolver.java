package com.nizar.rubiks_cube_sim.service.solving;

import com.nizar.rubiks_cube_sim.model.*;

import java.util.List;
import java.util.Map;

public class WhiteCrossSolver implements SolvingStage {
    @Override
    public String solve(Cube cube) {
        Face whiteFace = getWhiteFace(cube);
        String sequence = "";


        while (!whiteCrossComplete(whiteFace)) {
            TileLocation unsolvedEdge = findUnsolvedWhiteEdgeTile(cube, whiteFace);
        }

        return sequence;
    }

    private Face getWhiteFace(Cube cube) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName faceName : faces.keySet()) {
            Face face = faces.get(faceName);
            if (face.getTile(5) == Colour.WHITE) return face;
        }
        throw new RuntimeException("Couldn't find white face on cube.");
    }

    private boolean whiteCrossComplete(Face whiteFace) {
        Colour[] tiles = whiteFace.getTiles();
        if (tiles[1] == Colour.WHITE && tiles[3] == Colour.WHITE && tiles[5] == Colour.WHITE && tiles[7] == Colour.WHITE) return true;
        return false;
    }

    /**
     * An unsolved white edge piece is:
     *  - Not already on the white face, so its on one of the five other faces.
     *  - Will be in index 1, 3, 5, or 7.
     * We can put an unsolved white edge into place by:
     *  - Identifying any target tile to solve.
     *  - Selecting any unsolved white edge piece.
     *  - Finding the sequence of moves necessary to move it into place.
     *
     * @param cube - The cube we are currently trying to solve.
     * @param whiteFace - A reference to the face with a white middle tile.
     * @return TileLocation - The name of the face, and the tile index (0-8).
     */
    private TileLocation findUnsolvedWhiteEdgeTile(Cube cube, Face whiteFace) {
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

    private String makeMove(Cube cube, TileLocation currentLocation, TileLocation targetLocation) {
        return "";
    }
}
