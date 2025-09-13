package com.nizar.rubiks_cube_sim.model;

public enum FaceName {
    FRONT("F"),
    BACK("B"),
    UP("U"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("R");

    private final String notation;

    FaceName(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    /**
     * Cube pattern:
     *   U
     * L F R B
     *   D
     * Each face numbered 1-9, left to right and top to bottom.
     *
     * @return all the edges that border a particular face.
     */
    public FaceEdge[] getBorderingEdges() {
        return switch(this) {
            case FRONT -> new FaceEdge[] {
                    new FaceEdge(UP, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(DOWN, EdgeType.TOP_EDGE),
                    new FaceEdge(LEFT, EdgeType.RIGHT_EDGE),
                    new FaceEdge(RIGHT, EdgeType.LEFT_EDGE)
            };
            case BACK -> new FaceEdge[] {
                    new FaceEdge(UP, EdgeType.TOP_EDGE),
                    new FaceEdge(DOWN, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(LEFT, EdgeType.LEFT_EDGE),
                    new FaceEdge(RIGHT, EdgeType.RIGHT_EDGE)
            };
            case UP -> new FaceEdge[] {
                    new FaceEdge(LEFT, EdgeType.TOP_EDGE),
                    new FaceEdge(RIGHT, EdgeType.TOP_EDGE),
                    new FaceEdge(FRONT, EdgeType.TOP_EDGE),
                    new FaceEdge(BACK, EdgeType.TOP_EDGE)
            };
            case DOWN -> new FaceEdge[] {
                    new FaceEdge(LEFT, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(RIGHT, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(FRONT, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(BACK, EdgeType.BOTTOM_EDGE)
            };
            case LEFT -> new FaceEdge[] {
                    new FaceEdge(UP, EdgeType.LEFT_EDGE),
                    new FaceEdge(DOWN, EdgeType.LEFT_EDGE),
                    new FaceEdge(FRONT, EdgeType.LEFT_EDGE),
                    new FaceEdge(BACK, EdgeType.RIGHT_EDGE)
            };
            case RIGHT -> new FaceEdge[] {
                    new FaceEdge(UP, EdgeType.BOTTOM_EDGE),
                    new FaceEdge(DOWN, EdgeType.TOP_EDGE),
                    new FaceEdge(FRONT, EdgeType.RIGHT_EDGE),
                    new FaceEdge(BACK, EdgeType.LEFT_EDGE)
            };
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }
}
