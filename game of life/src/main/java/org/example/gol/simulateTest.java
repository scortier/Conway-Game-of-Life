package org.example.gol;

import static org.junit.jupiter.api.Assertions.*;

class simulateTest {

    private Board board;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    void copy_sameSizeAsOriginal(){
        board copy=board.copy();

        assertEqauals();
    }
}