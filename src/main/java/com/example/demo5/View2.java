package com.example.demo5;




import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class View2 extends StackPane implements InteractionModel {

    Model model;
    public static ArrayList<String[]> bookings;


    VBox root;

    public View2(){

        VBox root = new VBox(10);

        Label your_bookings_lb = new Label("Your Bookings: ");
        root.getChildren().add(your_bookings_lb);

        bookings = new ArrayList<String[]>();

        String[] a = {"11th Oct 2022", "C5", "10AM - 11AM"};
        String[] b = {"12th Oct 2022", "C3", "10AM - 11AM"};

        bookings.add(a);
        bookings.add(b);

        for (String[] e: bookings){

            VBox vb = new VBox();

            Label date_lb = new Label("Date: " + e[0]);
            Label court_lb = new Label("Court: " + e[1]);
            Label time_lb = new Label("Time: " + e[2]);
            Button del_button = new Button("Delete");
            Button edit_button = new Button("Edit");
            vb.setPadding(new Insets(10));
            HBox buton_hb = new HBox();
            buton_hb.getChildren().addAll(del_button, edit_button);

            vb.getChildren().addAll(date_lb,court_lb,time_lb,buton_hb);
            root.getChildren().add(vb);

        }

        //Button cancel_button = new Button("Cancel");
        //cancel_button.setAlignment(Pos.CENTER_RIGHT);
        //root.getChildren().add(cancel_button);

        root.setPadding(new Insets(20));


        // sizing
        root.setPrefSize(300, 300);
        root.setMinSize(100,100);
        root.setMaxSize(500,500);

        //alignment
        root.setAlignment(Pos.CENTER);


        /*
        for (String[] e: bookings){
            System.out.println(e[0]);
            System.out.println(e[1]);
            System.out.println(e[2]);
            System.out.println("");
        }*/


        this.getChildren().add(root);
    }

    public void setModel(Model newModel) {
        model = newModel;
    }

    public void setController(Controller controller) {

        //root.getChildren().get(2).;

        System.out.println("");
    }

    public ArrayList<String[]> getBookings(){
        return bookings;
    }

    public void modelChanged(){
        System.out.println("awefberu");
    }
}
