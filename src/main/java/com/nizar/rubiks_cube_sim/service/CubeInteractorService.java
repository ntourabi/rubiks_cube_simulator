package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Face;

public interface CubeInteractorService {
    public void rotateFace();
    public void rotateEdgesBorderingFace();
    public void makeMove();
}
