// 
// Each cell is encouter by its surrounding 8 cells
//alive  0 -> exact  3 life neighbours -> 1  
//death 1 -> <2 life or  >3 life -> 0
// next gen 1 -> 2 or 3 life -> 1 
//2d array which store random collection of 0 and 1


// class board{
//     public void GOT(int [][] board)
//     {
//         int row=board.length;
//         int column=board[0].length;

//         //considering 8 cell encoutering so 8 directions to look
//         int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
//         int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
//     }
// }

// A simple Java program to implement Game of Life


public class HelloWorld {
    public static void main(String[] args){
      // Prints "Hello, World" in the terminal window.
      System.out.println("Hello, World");
    } 
}