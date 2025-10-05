package com.nizar.rubiks_cube_sim.controller;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.service.CubeScrambleService;
import com.nizar.rubiks_cube_sim.service.LayerByLayerCubeSolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cube")
public class CubeRestController {

    final private CubeScrambleService cubeScrambleService;
    final private LayerByLayerCubeSolvingService layerByLayerCubeSolvingService;

    @Autowired
    public CubeRestController(CubeScrambleService cubeScrambleService, LayerByLayerCubeSolvingService layerByLayerCubeSolvingService) {
        this.cubeScrambleService = cubeScrambleService;
        this.layerByLayerCubeSolvingService = layerByLayerCubeSolvingService;
    }

    @GetMapping("/scramble")
    public String getScramble() {
        return cubeScrambleService.createScrambledCube().toString();
    }

    @PostMapping("/solve")
    public String postSolutionToCube(@RequestBody Cube cube) {
        return layerByLayerCubeSolvingService.solveCube(cube);
    }
}
