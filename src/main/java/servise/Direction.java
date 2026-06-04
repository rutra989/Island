package servise;

import lombok.Getter;

@Getter
public enum Direction {
    // направление движения
        UP(0, -1),
        DOWN(0, 1),
        RIGHT(1, 0),
        LEFT(-1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

