package com.nizar.rubiks_cube_sim.service.verification;

import com.nizar.rubiks_cube_sim.model.Cube;

public interface CubeVerificationService {
    /**
     * Checks a sequence of moves
     * @param cube - the cube to apply the moves to.
     * @param moves - a sequence of cube operations/moves
     * @return validation message
     */
    public String verifySolution(Cube cube, String moves);
}
