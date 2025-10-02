package com.nizar.rubiks_cube_sim.model;

// A way of pinpointing a row/column of exactly 3 stickers on the cube.
public record FaceEdge(FaceName face, EdgeType edgeType) {}
