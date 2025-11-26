package com.nizar.rubiks_cube_sim.service.verification;

import com.nizar.rubiks_cube_sim.model.Cube;
import org.springframework.stereotype.Service;

@Service
public class CubeVerificationServiceImpl implements CubeVerificationService {
    /**
     * Checks a sequence of moves
     *
     * @param cube  - the cube to apply the moves to.
     * @param moves - a sequence of cube operations/moves
     * @return validation message
     */
    @Override
    public String verifySolution(Cube cube, String moves) {
        return "";
    }
}