package com.nizar.rubiks_cube_sim.service.solvingStages;

import com.nizar.rubiks_cube_sim.model.Sticker;
import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.FaceName;
import com.nizar.rubiks_cube_sim.service.CubeInteractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WhiteCornersSolver implements SolvingStage {

    CubeInteractorService cubeInteractorService;

    @Autowired
    public WhiteCornersSolver(CubeInteractorService cubeInteractorService) {
        this.cubeInteractorService = cubeInteractorService;
    }

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
            if (face.getTile(4) == Sticker.WHITE) return faceName;
        }
        throw new RuntimeException("No white face found");
    }

    private boolean whiteCornersSolved(Cube cube, FaceName whiteFace) {
        Face face = cube.getFace(whiteFace);
        return face.getTile(0) == Sticker.WHITE && face.getTile(2) == Sticker.WHITE && face.getTile(6) == Sticker.WHITE && face.getTile(8) == Sticker.WHITE;
    }
}
