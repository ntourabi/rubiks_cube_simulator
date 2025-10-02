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
     * Cube net:
     *   U
     * L F R B
     *   D
     * Each face numbered 1-9, left to right and top to bottom.
     * Each array of FaceEdges is deliberately pre-ordered for easy swapping / rotations. In-order traversal = Right Quarter Turn.
     * @return all the edges that border a particular face.
     */
    public StickerTripletLocation[] getBorderingEdges() {
        return switch(this) {
            case FRONT -> new StickerTripletLocation[] {
                    new StickerTripletLocation(UP, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(RIGHT, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(DOWN, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(LEFT, StickerTriplet.RIGHT_EDGE)
            };
            case BACK -> new StickerTripletLocation[] {
                    new StickerTripletLocation(UP, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(LEFT, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(DOWN, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(RIGHT, StickerTriplet.RIGHT_EDGE)
            };
            case UP -> new StickerTripletLocation[] {
                    new StickerTripletLocation(BACK, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(RIGHT, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(FRONT, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(LEFT, StickerTriplet.TOP_EDGE)
            };
            case DOWN -> new StickerTripletLocation[] {
                    new StickerTripletLocation(FRONT, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(RIGHT, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(BACK, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(LEFT, StickerTriplet.BOTTOM_EDGE)
            };
            case LEFT -> new StickerTripletLocation[] {
                    new StickerTripletLocation(UP, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(FRONT, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(DOWN, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(BACK, StickerTriplet.RIGHT_EDGE)
            };
            case RIGHT -> new StickerTripletLocation[] {
                    new StickerTripletLocation(UP, StickerTriplet.BOTTOM_EDGE),
                    new StickerTripletLocation(BACK, StickerTriplet.LEFT_EDGE),
                    new StickerTripletLocation(DOWN, StickerTriplet.TOP_EDGE),
                    new StickerTripletLocation(FRONT, StickerTriplet.RIGHT_EDGE)

            };
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }
}
