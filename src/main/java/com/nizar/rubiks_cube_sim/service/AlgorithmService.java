package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Algorithm;
import com.nizar.rubiks_cube_sim.model.Cube;

public interface AlgorithmService {
    public Cube applyAlgorithm(Cube cube, Algorithm algorithm);
}
