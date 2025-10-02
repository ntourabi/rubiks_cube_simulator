package com.nizar.rubiks_cube_sim.model;

/**
 * A reference to the exact location of a sticker on the cube.
 * @param name
 * @param stickerIndex
 */
public record StickerLocation(FaceName name, int stickerIndex) {
}
