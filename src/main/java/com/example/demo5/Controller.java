package com.example.demo5;




import javafx.event.ActionEvent;

public class Controller {

    Model model;

    public Controller() {}

    public void setModel(Model newModel) {
        model = newModel;
    }


    // handle new booking
    public void handle_new_booking(ActionEvent event) {

        //this.model.increment();
        this.model.make_a_booking();


    }

    public void submit_view3_handling(ActionEvent actionEvent){

        this.model.submit_view3();
    }

    public void manage_new_booking(ActionEvent event){

        this.model.manage_bookings();
    }

    /*
    public void cancel_button_handling(ActionEvent actionEvent) {

        this.model.cancel_button(actionEvent);
    }*/

    public void submit_button_handling(ActionEvent actionEvent){


        System.out.println("STEP 1 controller GOOD");
        this.model.new_submit_button();
    }

    public void handle_multiple_bookings(ActionEvent actionEvent){
        this.model.multiple_bookings();
    }

    /*
    public void handleClick(ActionEvent event) {
        model.increment();
    }*/

}
