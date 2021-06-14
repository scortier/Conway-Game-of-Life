//will not be having ife object
public class Life {
    public static int ROW=20;
    public static int COL=80;
    public static int DELAY=300;

public static void initialize_Board(Board b)
{
    for(int r=0;r<ROW;r++)
    {
        for(int c=0;c<COL;c++)
        {
            int randVal=(int) (Math.random()*3); //random nummber from 0 to 2
            if(randVal==0) //probab = 1/3 having live
            {
                b.set(r,c,1);
            }
        }
    }
}
public static void main(String [] args)
{
    Board board=new Board(ROW,COL);
    initialize_Board(board);
}
}
