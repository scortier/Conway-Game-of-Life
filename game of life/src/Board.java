import java.util.*;  
// 
// Each cell is encouter by its surrounding 8 cells
//alive  0 -> exact  3 life neighbours -> 1  
//death 1 -> <2 life or  >3 life -> 0
// next gen 1 -> 2 or 3 life -> 1 
//2d array which store random collection of 0 and 1

public class Board {

    int [][] grid;
    int R=grid.length;
    int C=grid[0].length;
    /**
     * Constructor for objects of class Board
     * Intitialize with 0's .
     * @param row as the row fo the grid
     * @param col as the column of the grid 
     */

     public Board(int row,int col)
     {
         grid=new int[row][col];

     }
    
    /**
     *get return the value allocated at particular cell.
     * @param row as the row fo the grid
     * @param col as the column of the grid 
     */
     public int get(int row,int col)
     {
         return grid[row][col];
     }


     /**
      * set method setd the specified row, col location to the specifiec value
      * @param row as the row fo the grid
      * @param col as the column of the grid 
      */
      public void set(int row,int col,int value)
      {
          grid[row][col]=value;
      }

      

      public int getRow()
      {
          return grid.length;
      }

      public int getCol()
      {
          return grid[0].length;
      }

    /**
      * toDisplay method display the grid
      * @param row as the row fo the grid
      * @param col as the column of the grid 
      */

      public String toDisplay()
      {
          String answer="";
          for(int r=0;r<getRow();r++)
          {
              for(int c=0;c<getCol();c++)
              {
                  answer+=grid[r][c];
              }
          }
        //   System.out.println(answer);
    return answer;  
    }

     public static void main(String[] args) throws Exception {
        // Scanner sc= new Scanner(System.in); 
        // int r= sc.nextInt();  
        // int c= sc.nextInt();  
        // String x;
        // // int r,c;

        // Board bo=new Board(r,c);
        // x=bo.toDisplay();
        // System.out.println("display"+ x);
        
    }

    
}