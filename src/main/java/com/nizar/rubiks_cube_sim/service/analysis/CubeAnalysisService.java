package com.nizar.rubiks_cube_sim.service.analysis;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.FaceName;
import com.nizar.rubiks_cube_sim.model.Sticker;
import org.springframework.stereotype.Service;

// Need to implement WhiteCrossSolver as a minimum before considering using this.
@Service
public interface CubeAnalysisService {
    /**
     * You can tell what colour is associated with a face judging by its middle tile.
     * This method checks all middle tiles for the target colour.
     * @param cube - The Rubik's Cube to check.
     * @param sticker - The colour of the tile.
     * @return FaceName of the face with a middle tile matching our target colour.
     */
    public FaceName identifyFaceByColour(Cube cube, Sticker sticker);
}
