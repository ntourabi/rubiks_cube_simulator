package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeInteractorServiceTests {

    private final CubeInteractorService cubeInteractorService = new CubeInteractorServiceImpl();

    @Test
    void rotateFace_clockwise_success() {
        //Arrange.
        Face face = new Face(new Sticker[] {
                Sticker.RED, Sticker.BLUE, Sticker.RED,
                Sticker.YELLOW, Sticker.ORANGE, Sticker.YELLOW,
                Sticker.GREEN, Sticker.WHITE, Sticker.GREEN
        });
        Face expectedFace = new Face(new Sticker[] {
           Sticker.GREEN, Sticker.YELLOW, Sticker.RED,
           Sticker.WHITE, Sticker.ORANGE, Sticker.BLUE,
           Sticker.GREEN, Sticker.YELLOW, Sticker.RED
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.CLOCKWISE_QUARTER);
        //Assert.
        Sticker[] stickers = face.getTiles();
        Sticker[] expectedStickers = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(stickers[i], expectedStickers[i]);
        }
    }

    @Test
    void rotateFace_counterClockwise_success() {
        //Arrange.
        Face face = new Face(new Sticker[] {
                Sticker.RED, Sticker.BLUE, Sticker.RED,
                Sticker.YELLOW, Sticker.ORANGE, Sticker.YELLOW,
                Sticker.GREEN, Sticker.WHITE, Sticker.GREEN
        });
        Face expectedFace = new Face(new Sticker[] {
                Sticker.RED, Sticker.YELLOW, Sticker.GREEN,
                Sticker.BLUE, Sticker.ORANGE, Sticker.WHITE,
                Sticker.RED, Sticker.YELLOW, Sticker.GREEN
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.ANTICLOCKWISE_QUARTER);
        //Assert.
        Sticker[] stickers = face.getTiles();
        Sticker[] expectedStickers = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(stickers[i], expectedStickers[i]);
        }
    }

    @Test
    void rotateFace_counterCounterClockwise_success() {
        //Arrange.
        Face face = new Face(new Sticker[] {
                Sticker.RED, Sticker.BLUE, Sticker.RED,
                Sticker.YELLOW, Sticker.ORANGE, Sticker.YELLOW,
                Sticker.GREEN, Sticker.WHITE, Sticker.GREEN
        });
        Face expectedFace = new Face(new Sticker[] {
                Sticker.GREEN, Sticker.WHITE, Sticker.GREEN,
                Sticker.YELLOW, Sticker.ORANGE, Sticker.YELLOW,
                Sticker.RED, Sticker.BLUE, Sticker.RED
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.HALF);
        //Assert.
        Sticker[] stickers = face.getTiles();
        Sticker[] expectedStickers = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(stickers[i], expectedStickers[i]);
        }
    }

    @Test
    void rotateEdgesBorderingFace_clockwise_success() {
        //Arrange
        Cube originalCube = Cube.createSolvedCube();
        Cube expectedCube = Cube.createSolvedCube();
        //The faces bordering UP are FRONT, RIGHT, BACK, LEFT.
        //Additionally, it is always the TOP_EDGE.
        Sticker[] left = expectedCube.getFace(FaceName.LEFT).getTiles();
        Sticker[] front = expectedCube.getFace(FaceName.FRONT).getTiles();
        Sticker[] right = expectedCube.getFace(FaceName.RIGHT).getTiles();
        Sticker[] back = expectedCube.getFace(FaceName.BACK).getTiles();

        System.out.println(originalCube.toString());

        //Act
        cubeInteractorService.rotateEdgesBorderingFace(originalCube, FaceName.UP, Turn.CLOCKWISE_QUARTER);
        //Assert

        System.out.println(originalCube.toString());


    }

    @Test
    void rotateEdgesBorderingFace_counterClockwise_success() {}

    @Test
    void rotateEdgesBorderingFace_counterCounterClockwise_success() {}
}
