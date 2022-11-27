package com.example.demo5;





import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class View extends StackPane implements InteractionModel {


    ObservableList<String> array_bookings;
    Button new_booking_button;
    Button manage_booking_button;
    Button multiple_booking_button;
    Model model = new Model();
    View1 new_booking = new View1();
    View2 manage_booking = new View2();
    View3 multiple_bookings = new View3();

    //public static ArrayList<String[]> bookings = new ArrayList<String[]>();


    public View(){

        VBox root = new VBox(10);

        new_booking_button = new Button("New Booking");
        new_booking_button.setFont(new Font("Arial Narrow", 10 ));

        //new_booking_button.setLayoutX(this.getWidth()/3);
        //new_booking_button.setPrefWidth(this.getWidth()/3);
        //new_booking_button.setPrefHeight(this.getHeight()/3);



        manage_booking_button = new Button("Manage Bookings");
        manage_booking_button.setFont(new Font("Arial Narrow", 10));

        multiple_booking_button = new Button("Multiple Bookings");
        multiple_booking_button.setFont(new Font("Arial Narrow", 10));


        root.getChildren().addAll(new_booking_button,manage_booking_button,multiple_booking_button);
        //root.setPadding(new Insets(20));


        array_bookings = FXCollections.observableArrayList();

        // sizing
        root.setPrefSize(300, 300);
        root.setMinSize(100,100);
        root.setMaxSize(500,500);

        //alignment
        root.setAlignment(Pos.CENTER);
        new_booking_button.setAlignment(Pos.TOP_CENTER);
        manage_booking_button.setAlignment(Pos.CENTER);
        multiple_booking_button.setAlignment(Pos.BOTTOM_CENTER);

        this.getChildren().add(root);
    }

    public void setModel(Model newModel) {
        model = newModel;
    }

    public void setController(Controller controller) {

        new_booking_button.setOnAction(controller::handle_new_booking);
        manage_booking_button.setOnAction(controller::manage_new_booking);
        multiple_booking_button.setOnAction(controller::handle_multiple_bookings);


        new_booking.submit_bt.setOnAction(controller::submit_button_handling);
        //new_booking.cancel_bt.setOnAction(controller::cancel_button_handling);
    }

    public void modelChanged() {

        new_booking.setModel(model);

        StackPane secondaryLayout = new StackPane();


        if (model.new_booking_button_pressed){
            secondaryLayout.getChildren().add(new_booking);
        }

        else if (model.manage_booking_button_pressed){
            secondaryLayout.getChildren().add(manage_booking);
        }

        else if (model.multiple_bookings_button_pressed){
            secondaryLayout.getChildren().add(multiple_bookings);
        }

        else {
            secondaryLayout.getChildren().add(new_booking);
        }


        Scene secondScene = new Scene(secondaryLayout, 300,300);
        Stage newWindow = new Stage();
        newWindow.setScene(secondScene);


        newWindow.show();

    }
}
