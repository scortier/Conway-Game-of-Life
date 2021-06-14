package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class main_view extends VBox {

    private Button stepButton;
    private Canvas canvas;

    private simulate temp_simulate;
    public main_view(){
        stepButton = new Button("step");
        canvas=new Canvas(400,400);

        this.getChildren().addAll(this.stepButton,this.canvas);

        this.temp_simulate=new simulate(10,10);

        temp_simulate.setAlive( 2, 2);
        temp_simulate.setAlive(3, 2);
        temp_simulate.setAlive(4, 2);
        temp_simulate.setAlive(5, 6);
        temp_simulate.setAlive(5, 5);
        temp_simulate.setAlive(6, 5);
        temp_simulate.setAlive(6, 6);

    }

    public void draw(){
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0,0,400,400);

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
    }
}
