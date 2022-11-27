package com.example.demo5;




import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Model {


    private ArrayList<InteractionModel> subscribers;
    public Boolean new_booking_button_pressed=false;
    public Boolean manage_booking_button_pressed=false;
    public Boolean multiple_bookings_button_pressed =false;

    private ArrayList<InteractionModel> subscribers_2;
    public Model() {
        subscribers = new ArrayList<>(); // v2
    }


    public void make_a_booking() {

        // ++this.count;
        new_booking_button_pressed = true;
        manage_booking_button_pressed = false;
        multiple_bookings_button_pressed =false;
        System.out.println(new_booking_button_pressed);
        this.notifySubscribers();
    }

    public void manage_bookings(){

        manage_booking_button_pressed = true;
        new_booking_button_pressed = false;
        multiple_bookings_button_pressed =false;
        System.out.println(manage_booking_button_pressed);
        this.notifySubscribers();
    }

    public void submit_view3(){

        this.notifySubscribers();
    }

    public void multiple_bookings(){

        multiple_bookings_button_pressed = true;
        new_booking_button_pressed = false;
        manage_booking_button_pressed=false;
        System.out.println(multiple_bookings_button_pressed);
        this.notifySubscribers();
    }


    /*
    public void cancel_button(ActionEvent actionEvent){

        this.notifySubscribers();
    }*/

    public void new_submit_button(){
        this.notifySubscribers();
    }

    //public String

    private void notifySubscribers() {
        subscribers.forEach(s -> s.modelChanged());
    }


    /*
    private void notifySubscribers_2() {
        subscribers_2.forEach(s -> s.modelChanged());
    }*/


    public void addSubscriber(InteractionModel sub) { // for version 2
        subscribers.add(sub);
    }

    /*
    public void addSubscriber_2(InteractionModel sub) { // for version 2
        subscribers_2.add(sub);
    }*/
}
