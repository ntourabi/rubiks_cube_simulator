package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.service.solving.*;

import java.util.List;

public class LayerByLayerCubeSolvingServiceImpl implements LayerByLayerCubeSolvingService {

    private final List<SolvingStage> stageList = List.of(
            new WhiteCrossSolver(),
            new WhiteCornersSolver(),
            new MiddleLayerEdgesSolver(),
            new YellowCrossSolver(),
            new OrientYellowCornersSolver(),
            new PermuteYellowCornersSolver(),
            new PermuteYellowEdgesSolver()
    );
    /**
     * Run through all seven stages of the layer by layer solving method.
     * Stage 1 - solveWhiteCross
     * Stage 2 - solveWhiteCorners
     * Stage 3 - solveMiddleLayerEdges
     * Stage 4 - solveYellowCross
     * Stage 5 - orientYellowCorners
     * Stage 6 - permuteYellowCorners
     * Stage 7 - permuteYellowEdges
     *
     * @param cube
     * @return
     */
    @Override
    public String solveCube(Cube cube) {
        StringBuilder result = new StringBuilder();
        for (SolvingStage stage : stageList) {
            result.append(stage.solve(cube)).append("\n");
        }
        return result.toString().trim();
    }
}
