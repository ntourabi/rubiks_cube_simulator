package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;

public interface LayerByLayerCubeSolvingService {
    //Stage 1
    public String solveWhiteCross(Cube cube);
    //Stage 2
    public String solveWhiteCorners(Cube cube);
    //Stage 3
    public String solveMiddleLayerEdges(Cube cube);
    //Stage 4
    public String solveYellowCross(Cube cube);
    //Stage 5
    public String orientYellowCorners(Cube cube);
    //Stage 6
    public String permuteYellowCorners(Cube cube);
    //Stage 7
    public String permuteYellowEdges(Cube cube);

    //Run through all stages.
    public String solveCube(Cube cube);

    //Apply a particular algorithm to the cube.
    public String applyAlgorithm(Cube cube);
}
