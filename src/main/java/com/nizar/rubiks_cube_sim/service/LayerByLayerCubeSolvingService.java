package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;

public interface LayerByLayerCubeSolvingService {
    /**
     * Run through all seven stages of the layer by layer solving method.
     * Stage 1 - solveWhiteCross
     * Stage 2 - solveWhiteCorners
     * Stage 3 - solveMiddleLayerEdges
     * Stage 4 - solveYellowCross
     * Stage 5 - orientYellowCorners
     * Stage 6 - permuteYellowCorners
     * Stage 7 - permuteYellowEdges
     * @param cube
     * @return
     */
    public String solveCube(Cube cube);
}
