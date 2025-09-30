package com.nizar.rubiks_cube_sim.service.solving;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.service.CubeInteractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YellowCrossSolver implements SolvingStage {

    CubeInteractorService cubeInteractorService;

    @Autowired
    public YellowCrossSolver(CubeInteractorService cubeInteractorService) {
        this.cubeInteractorService = cubeInteractorService;
    }

    @Override
    public String solve(Cube cube) {
        return "";
    }
}
