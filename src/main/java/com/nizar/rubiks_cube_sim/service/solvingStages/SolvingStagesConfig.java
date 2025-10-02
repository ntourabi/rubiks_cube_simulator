package com.nizar.rubiks_cube_sim.service.solvingStages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Our SolvingStage list MUST FOLLOW THIS EXACT ORDER.
 * This config class exists to ensure the correct order is followed during injection.
 */
@Configuration
public class SolvingStagesConfig {

    @Bean
    public List<SolvingStage> solvingStages(
            WhiteCrossSolver whiteCrossSolver,
            WhiteCornersSolver whiteCornersSolver,
            MiddleLayerEdgesSolver middleLayerEdgesSolver,
            YellowCrossSolver yellowCrossSolver,
            OrientYellowCornersSolver orientYellowCornersSolver,
            PermuteYellowCornersSolver permuteYellowCornersSolver,
            PermuteYellowEdgesSolver permuteYellowEdgesSolver
    ) {
        return List.of(
                whiteCrossSolver,
                whiteCornersSolver,
                middleLayerEdgesSolver,
                yellowCrossSolver,
                orientYellowCornersSolver,
                permuteYellowCornersSolver,
                permuteYellowEdgesSolver
        );
    }
}
