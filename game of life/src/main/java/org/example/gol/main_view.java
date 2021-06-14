package org.example.gol;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

public class main_view extends VBox {

    private Button stepButton;
    private Canvas canvas;

    private Affine affine; //rearange things in canvas

    private simulate temp_simulate;

    private int Draw_Mode=1; //1 as live and 0 as dead
    public main_view(){
        stepButton = new Button("STEP");
        this.stepButton.setOnAction(actionEvent -> {
            temp_simulate.step();
            draw();
        });



        this.canvas=new Canvas(400,400);

        this.canvas.setOnMousePressed(this::handleDraw); //draw while clicking mouse
        this.canvas.setOnMouseDragged(this::handleDraw); //draw while dragging mouse

        this.setOnKeyPressed(this::onKeyPressed);

        this.getChildren().addAll(this.stepButton,this.canvas);
        this.affine=new Affine();
        this.affine.appendScale(400/10f,400/10f);
        this.temp_simulate=new simulate(10,10);

//        temp_simulate.setAlive( 2, 2);
//        temp_simulate.setAlive(3, 2);
//        temp_simulate.setAlive(4, 2);
//        temp_simulate.setAlive(5, 6);
//        temp_simulate.setAlive(5, 5);
//        temp_simulate.setAlive(6, 5);
//        temp_simulate.setAlive(6, 6);

    }

    private void onKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.D){
            this.Draw_Mode=1;
            System.out.println("Draw mode");
        }
        else if(keyEvent.getCode()==KeyCode.E)
        {
            this.Draw_Mode=0;
            System.out.println("Erase Mode");
        }
    }

    private void handleDraw(MouseEvent event)
    {
        double mouseX=event.getX();
        double mouseY=event.getY();
//        System.out.println(mouseX+","+mouseY);


        try{
            Point2D coord= this.affine.inverseTransform(mouseX,mouseY);
            int coordX=(int) coord.getX();
            int coordY=(int) coord.getY();
//            System.out.println(coord);
            System.out.println(coordX+","+coordY); //to convert coord into integers

//            this.temp_simulate.setAlive(coordX,coordY);

//            this.temp_simulate.board[coordX][coordY]=Draw_Mode;

            this.temp_simulate.setState(coordX,coordY,Draw_Mode);
            draw();


        } catch (NonInvertibleTransformException e) {
            System.out.println("OOPS could not trnsform");
        }
    }

    public void draw(){
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.setTransform(this.affine);
        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0,0,450,450);

        g.setFill(Color.BLACK);
        for(int x=0;x<this.temp_simulate.width;x++)
        {
            for(int y=0;y<this.temp_simulate.height;y++)
            {
                if(this.temp_simulate.getState(x,y)==1)
                {
                    g.fillRect(x,y,1,1);
                }
            }
        }

        g.setStroke(Color.GRAY);
        g.setLineWidth(0.05);
        for(int x=0;x<=this.temp_simulate.width;x++)
        {
            g.strokeLine(x,0,x,10);
        }

        for(int y=0;y<=this.temp_simulate.height;y++)
        {
            g.strokeLine(0,y,10,y);
        }

    }
}
