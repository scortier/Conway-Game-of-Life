package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class main_view extends VBox {

    private Button stepButton;
    private Canvas canvas;
    public main_view(){
        stepButton = new Button("step");
        canvas=new Canvas(400,400);

        this.getChildren().addAll(this.stepButton,this.canvas);
    }


}
