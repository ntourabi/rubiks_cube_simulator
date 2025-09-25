package com.nizar.rubiks_cube_sim.service.solving;

import com.nizar.rubiks_cube_sim.model.Colour;
import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.FaceName;

import java.util.Map;

public class WhiteCornersSolver implements SolvingStage {
    @Override
    public String solve(Cube cube) {
        String sequence = "";
        FaceName whiteFace = determineWhiteFace(cube);
        return sequence;
    }

    private FaceName determineWhiteFace(Cube cube) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName faceName : faces.keySet()) {
            Face face = faces.get(faceName);
            if (face.getTile(4) == Colour.WHITE) return faceName;
        }
        throw new RuntimeException("No white face found");
    }

    private boolean whiteCornersSolved(Cube cube, FaceName whiteFace) {
        Face face = cube.getFace(whiteFace);
        return face.getTile(0) == Colour.WHITE && face.getTile(2) == Colour.WHITE && face.getTile(6) == Colour.WHITE && face.getTile(8) == Colour.WHITE;
    }
}
