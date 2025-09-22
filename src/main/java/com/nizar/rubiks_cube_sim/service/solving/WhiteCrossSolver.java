package com.nizar.rubiks_cube_sim.service.solving;

import com.nizar.rubiks_cube_sim.model.Colour;
import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.FaceName;

import java.util.Map;

public class WhiteCrossSolver implements SolvingStage {
    @Override
    public String solve(Cube cube) {
        Face whiteFace = getWhiteFace(cube);
        String sequence = "";

        while (!whiteCrossComplete(whiteFace)) {
            break;
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

    private void findUnsolvedWhiteEdge(Cube cube) {}
}
