package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeInteractorServiceTests {

    private final CubeInteractorService cubeInteractorService = new CubeInteractorServiceImpl();

    @Test
    void rotateFace_clockwise_success() {
        //Arrange.
        Face face = new Face(new Colour[] {
                Colour.RED, Colour.BLUE, Colour.RED,
                Colour.YELLOW, Colour.ORANGE, Colour.YELLOW,
                Colour.GREEN, Colour.WHITE, Colour.GREEN
        });
        Face expectedFace = new Face(new Colour[] {
           Colour.GREEN, Colour.YELLOW, Colour.RED,
           Colour.WHITE, Colour.ORANGE, Colour.BLUE,
           Colour.GREEN, Colour.YELLOW, Colour.RED
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.CLOCKWISE_QUARTER);
        //Assert.
        Colour[] colours = face.getTiles();
        Colour[] expectedColours = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(colours[i], expectedColours[i]);
        }
    }

    @Test
    void rotateFace_counterClockwise_success() {
        //Arrange.
        Face face = new Face(new Colour[] {
                Colour.RED, Colour.BLUE, Colour.RED,
                Colour.YELLOW, Colour.ORANGE, Colour.YELLOW,
                Colour.GREEN, Colour.WHITE, Colour.GREEN
        });
        Face expectedFace = new Face(new Colour[] {
                Colour.RED, Colour.YELLOW, Colour.GREEN,
                Colour.BLUE, Colour.ORANGE, Colour.WHITE,
                Colour.RED, Colour.YELLOW, Colour.GREEN
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.ANTICLOCKWISE_QUARTER);
        //Assert.
        Colour[] colours = face.getTiles();
        Colour[] expectedColours = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(colours[i], expectedColours[i]);
        }
    }

    @Test
    void rotateFace_counterCounterClockwise_success() {
        //Arrange.
        Face face = new Face(new Colour[] {
                Colour.RED, Colour.BLUE, Colour.RED,
                Colour.YELLOW, Colour.ORANGE, Colour.YELLOW,
                Colour.GREEN, Colour.WHITE, Colour.GREEN
        });
        Face expectedFace = new Face(new Colour[] {
                Colour.GREEN, Colour.WHITE, Colour.GREEN,
                Colour.YELLOW, Colour.ORANGE, Colour.YELLOW,
                Colour.RED, Colour.BLUE, Colour.RED
        });
        //Act.
        cubeInteractorService.rotateFace(face, Turn.HALF);
        //Assert.
        Colour[] colours = face.getTiles();
        Colour[] expectedColours = expectedFace.getTiles();
        for (int i = 0; i < 9; i++) {
            assertEquals(colours[i], expectedColours[i]);
        }
    }

    @Test
    void rotateEdgesBorderingFace_clockwise_success() {
        //Arrange
        Cube originalCube = Cube.createSolvedCube();
        Cube expectedCube = Cube.createSolvedCube();
        //The faces bordering UP are FRONT, RIGHT, BACK, LEFT.
        //Additionally, it is always the TOP_EDGE.
        Face front = expectedCube.getFace(FaceName.FRONT);
        Face back = expectedCube.getFace(FaceName.BACK);
        Face left = expectedCube.getFace(FaceName.LEFT);
        Face right = expectedCube.getFace(FaceName.RIGHT);

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
