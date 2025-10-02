package com.nizar.rubiks_cube_sim.model;

/**
 * A way of pinpointing the exact location of a triplet of stickers on the cube.
 * @param face
 * @param stickerTriplet
 */
public record StickerTripletLocation(FaceName face, StickerTriplet stickerTriplet) {}
