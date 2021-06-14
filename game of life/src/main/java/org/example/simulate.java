package org.example;

public class simulate {
    int width;
    int height;
    int[][] board;

    public simulate(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void printBoard() {
        System.out.println("-");
        for (int y = 0; y < height; y++) {
            String line = "!";
            for (int x = 0; x < width; x++) {

                if (this.board[x][y] == 0) {
                    line += ".";
                } else {
                    line += "*";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("-\n");
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    }

        public int countAliveNeigh(int x,int y)
        {
            int count=0;
            count += getState (x - 1,y - 1);
            count += getState (x,y - 1);
            count += getState (x + 1,y - 1);
            count += getState (x - 1,y);
            count += getState (x + 1,y) ;

            count += getState (x - 1,y + 1);
            count += getState ( x,y + 1);
            count += getState (x + 1,y + 1);
            return  count;
        }

        public int getState(int x,int y)
        {
            if(x<0 || x>=width)
                return 0;

            if(y<0 || y>=height)
                return 0;
            return this.board[x][y];
        }
        public void step()
        {
            int [][] new_board=new int[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int aliveNeighbours = countAliveNeigh(x, y);


                    if (getState(x,y) == 1) {
                        if (aliveNeighbours < 2) {
                            this.board[x][y] = 0;
                        } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                            this.board[x][y] = 1;
                        } else if (aliveNeighbours > 3) {
                            this.board[x][y] = 0;
                        }
                    } else {
                        if (aliveNeighbours==3)
                        {
                            this.board[x][y]=1;
                        }
                    }
                }
            }
            this.board=new_board;
        }
    public static void main(String[] args) {
        simulate temp_test = new simulate(8,5);
        temp_test.setAlive( 2, 2);
        temp_test.setAlive(3, 2);
        temp_test.setAlive(4, 2);

        temp_test.printBoard();

//        System.out.println(temp_test.countAliveNeigh(3,2));
        temp_test.step();

        temp_test.printBoard();
        temp_test.step();
        temp_test.printBoard();


    }

}
