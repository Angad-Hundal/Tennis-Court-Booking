package com.example.demo5;





import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Date;

public class View3 extends StackPane implements InteractionModel {

    Model model;
    TextField start_date_tf;
    TextField end_date_tf;
    TextField court_cb;
    TextField time_cb;
    Button submit_button;

    View2 view2 = new View2();
    public View3(){

        VBox root = new VBox(10);

        Label multiple_booking_lb = new Label("Multiple Bookings: ");
        root.getChildren().add(multiple_booking_lb);

        // start date
        HBox start_date_hb = new HBox();
        Label start_date_lb = new Label("Start Date (dd/mm/yy): ");
        start_date_tf = new TextField("");
        start_date_hb.getChildren().addAll(start_date_lb, start_date_tf);


        // End date
        HBox end_date_hb = new HBox();
        Label end_date_lb = new Label("End Date (dd/mm/yy): ");
        end_date_tf = new TextField("");
        end_date_hb.getChildren().addAll(end_date_lb, end_date_tf);


        // Court: .........
        HBox hb_3 = new HBox();
        Label court_lb = new Label("Court: ");
        court_cb = new TextField("");
        hb_3.getChildren().addAll(court_lb, court_cb);



        // time block
        HBox hb_4 = new HBox();
        Label time_lb = new Label("Time Slot: ");

        time_cb = new TextField("");
        hb_4.getChildren().addAll(time_lb, time_cb);


        //Button cancel_button = new Button("Cancel");
        submit_button = new Button("Submit");



        // cancel.......submit hb
        HBox cs_hb = new HBox();
        cs_hb.getChildren().add(submit_button);


        // sizing
        root.setPrefSize(300, 300);
        root.setMinSize(100,100);
        root.setMaxSize(500,500);

        //alignment
        root.setAlignment(Pos.CENTER);



        root.getChildren().addAll(start_date_hb, end_date_hb, hb_3, hb_4,cs_hb);
        root.setPadding(new Insets(20));
        this.getChildren().add(root);
    }

    public void setModel(Model newModel) {

        model = newModel;
    }


    public void setController(Controller controller) {

        submit_button.setOnAction(controller::submit_view3_handling);

    }

    public void modelChanged(){

        submit_button.setOnAction((ActionEvent actionevent) -> submit_view3_action(View2.bookings, start_date_tf, end_date_tf, court_cb, time_cb));
    }

    public void submit_view3_action(ArrayList<String[]> bookings, TextField start_date_tf, TextField end_date_tf , TextField court_cb, TextField time_cb){


        String[] submit_add_array = new String[3];
        submit_add_array[0] = start_date_tf.getText() + " - " + end_date_tf.getText();
        submit_add_array[1] = court_cb.getText();
        submit_add_array[2] = time_cb.getText();

        View2.bookings.add(submit_add_array);


        System.out.println("NEW BOOKING: " );
        System.out.println("Date: " + start_date_tf.getText() + " - " + end_date_tf.getText());
        System.out.println("Court: " + court_cb.getText());
        System.out.println("Time SLot: " + time_cb.getText());




        /*
        for (String[] e: bookings){
            System.out.println(e[0]);
            System.out.println(e[1]);
            System.out.println(e[2]);
        }*/

    }
}
