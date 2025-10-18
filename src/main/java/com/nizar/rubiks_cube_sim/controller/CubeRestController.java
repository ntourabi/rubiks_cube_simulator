package com.nizar.rubiks_cube_sim.controller;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.service.scramble.CubeScrambleService;
import com.nizar.rubiks_cube_sim.service.verification.CubeVerificationService;
import com.nizar.rubiks_cube_sim.service.solving.LayerByLayerCubeSolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cube")
public class CubeRestController {

    final private CubeScrambleService cubeScrambleService;
    final private LayerByLayerCubeSolvingService layerByLayerCubeSolvingService;
    final private CubeVerificationService cubeVerificationService;

    @Autowired
    public CubeRestController(CubeScrambleService cubeScrambleService, LayerByLayerCubeSolvingService layerByLayerCubeSolvingService, CubeVerificationService cubeVerificationService) {
        this.cubeScrambleService = cubeScrambleService;
        this.layerByLayerCubeSolvingService = layerByLayerCubeSolvingService;
        this.cubeVerificationService = cubeVerificationService;
    }

    @GetMapping("/scramble")
    public String getScramble() {
        return cubeScrambleService.createScrambledCube().toString();
    }

    @PostMapping("/solve")
    public String postSolutionToCube(@RequestBody Cube cube) {
        return layerByLayerCubeSolvingService.solveCube(cube);
    }

    @PostMapping("/verify")
    public String verifySolution(@RequestParam Cube cube, @RequestParam String solution) {
        return cubeVerificationService.verifySolution(cube, solution);
    }
}
