package com.nizar.rubiks_cube_sim.service;


import com.nizar.rubiks_cube_sim.model.Cube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CubeScrambleServiceTests {
    private final CubeScrambleService cubeScrambleService;

    @Autowired
    public CubeScrambleServiceTests(CubeScrambleService cubeScrambleService) {
        this.cubeScrambleService = cubeScrambleService;
    }

    @Test
    public void createScrambledCube_createsScrambledCube() {
        Cube solvedCube = Cube.createSolvedCube();
        Cube scrambledCube = cubeScrambleService.createScrambledCube();

        assertNotNull(scrambledCube);
        //TODO: Would prefer having .equals methods for Cube before doing this properly.
        System.out.println(solvedCube);
        System.out.println(scrambledCube);

    }
}
