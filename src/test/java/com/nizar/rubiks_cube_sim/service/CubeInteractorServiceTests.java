package com.nizar.rubiks_cube_sim.service;

import com.nizar.rubiks_cube_sim.model.Colour;
import com.nizar.rubiks_cube_sim.model.Face;
import com.nizar.rubiks_cube_sim.model.Turn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CubeInteractorServiceTests {

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
    void rotateFace_counterClockwise_success() {}

    @Test
    void rotateFace_counterCounterClockwise_success() {}

    @Test
    void rotateEdgesBorderingFace_clockwise_success() {}

    @Test
    void rotateEdgesBorderingFace_counterClockwise_success() {}

    @Test
    void rotateEdgesBorderingFace_counterCounterClockwise_success() {}
}
