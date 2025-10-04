package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;
import com.nizar.rubiks_cube_sim.model.FaceName;
import com.nizar.rubiks_cube_sim.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CubeScrambleServiceImpl implements CubeScrambleService {

    private final CubeInteractorService cubeInteractorService;

    @Autowired
    public CubeScrambleServiceImpl(CubeInteractorService cubeInteractorService) {
        this.cubeInteractorService = cubeInteractorService;
    }

    @Override
    public Cube createScrambledCube() {
        Cube cube = Cube.createSolvedCube();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            FaceName randomFace = FaceName.values()[rand.nextInt(FaceName.values().length)];
            Turn randomTurn = Turn.values()[rand.nextInt(Turn.values().length)];
            cubeInteractorService.makeMove(cube, randomFace, randomTurn);
        }
        return cube;
    }
}
