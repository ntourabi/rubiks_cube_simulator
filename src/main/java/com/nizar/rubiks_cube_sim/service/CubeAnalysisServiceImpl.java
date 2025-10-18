package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.FaceName;
import com.nizar.rubiks_cube_sim.model.Sticker;

import java.util.Map;

public class CubeAnalysisServiceImpl implements CubeAnalysisService {
    /**
     * You can tell what colour is associated with a face judging by its middle tile.
     * This method checks all middle tiles for the target colour.
     *
     * @param cube    - The Rubik's Cube to check.
     * @param sticker - The colour of the tile.
     * @return FaceName of the face with a middle tile matching our target colour.
     */
    @Override
    public FaceName identifyFaceByColour(Cube cube, Sticker sticker) {
        Map<FaceName, Face> faces = cube.getFaces();
        for (FaceName faceName : faces.keySet()) {
            Face face = faces.get(faceName);
            if (face.getSticker(4) == sticker) return faceName;
        }
        throw new RuntimeException("Couldn't find face on cube with middle sticker " + sticker.toString());
    }
}
