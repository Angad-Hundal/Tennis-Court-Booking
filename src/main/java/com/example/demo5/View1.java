package com.example.demo5;





import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class View1 extends StackPane implements InteractionModel{


    Model model;
    Button submit_bt;
    //Button cancel_bt;
    TextField nsid_tf;
    TextField date_tf;
    TextField time_cb;
    TextField court_cb;
    View2 view2 = new View2();


    public View1(){

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(100,100);


        // NSID: ..........
        HBox hb_1 = new HBox();
        Label nsid_lb = new Label("NSID: ");
        nsid_tf = new TextField("");
        hb_1.getChildren().addAll(nsid_lb,nsid_tf);


        // Date: ......
        HBox hb_2 = new HBox();
        Label date_lb = new Label("Date (dd/mm/yy): ");
        date_tf = new TextField("");
        hb_2.getChildren().addAll(date_lb,date_tf);


        // Court: .........
        HBox hb_3 = new HBox();
        Label court_lb = new Label("Court: ");


        court_cb = new TextField("");
        hb_3.getChildren().addAll(court_lb, court_cb);



        // Time: ............
        HBox hb_4 = new HBox();
        Label time_lb = new Label("Time Slot: ");


        time_cb = new TextField("");
        hb_4.getChildren().addAll(time_lb, time_cb);


        // cancel ..... submit
        HBox hb_5  = new HBox();
        //cancel_bt = new Button("Cancel");
        submit_bt = new Button("Submit");
        hb_5.getChildren().addAll(submit_bt);  // cancel include
        //cancel_bt.setPadding(new Insets(20));
        submit_bt.setPadding(new Insets(20));



        // Padding
        hb_1.setPadding(new Insets(10));
        hb_2.setPadding(new Insets(10));
        hb_3.setPadding(new Insets(10));
        hb_4.setPadding(new Insets(10));
        root.setPadding(new Insets(20));
        hb_5.setPadding(new Insets(10));


        // sizing
        root.setPrefSize(300, 300);
        root.setMinSize(100,100);
        root.setMaxSize(500,500);

        //alignment
        root.setAlignment(Pos.CENTER);


        root.getChildren().addAll(hb_1,hb_2,hb_3,hb_4,hb_5);
        this.getChildren().add(root);

    }

    public void setModel(Model newModel) {
        model = newModel;
    }

    public void setController(Controller controller) {

        submit_bt.setOnAction(controller::submit_button_handling);

        //cancel_bt.setOnAction(controller::cancel_button_handling);

    }

    public void modelChanged() {

        /*
        System.out.println(court_cb);
        String [] submit_add_array = new String[3];
        submit_add_array[0] = this.date_tf.getText();
        submit_add_array[1] = this.court_cb.getText();
        submit_add_array[2] = this.time_cb.getText();
        view2.getBookings().add(submit_add_array);*/

        //cancel_bt. setOnAction((ActionEvent event) -> { Platform. exit(); });

        submit_bt.setOnAction((ActionEvent event) ->  submit_button_action(View2.bookings, date_tf, court_cb, time_cb));

    }

    private void submit_button_action(ArrayList<String[]> bookings, TextField date_tf, TextField court_cb, TextField time_cb) {

        String[] submit_add_array = new String[3];
        submit_add_array[0] = this.date_tf.getText();
        submit_add_array[1] = this.court_cb.getText();
        submit_add_array[2] = this.time_cb.getText();
        System.out.println("NEW BOOKING: " );
        System.out.println("Date: " + date_tf.getText());
        System.out.println("Court: " + court_cb.getText());
        System.out.println("Time SLot: " + time_cb.getText());

        View2.bookings.add(submit_add_array);

        //System.out.println(bookings.get(-1)[0]);
        /*
        for (String[] e: bookings){
            System.out.println(e[0]);
            System.out.println(e[1]);
            System.out.println(e[2]);
        }*/


    }


}