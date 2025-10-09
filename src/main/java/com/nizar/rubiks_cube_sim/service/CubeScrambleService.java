package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Cube;

public interface CubeScrambleService {
    /**
     * Creates a new cube and applies randomly generated moves to it.
     * @return scrambled Rubik's Cube.
     */
    public Cube createScrambledCube();
}
