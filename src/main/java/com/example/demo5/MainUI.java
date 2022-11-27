package com.example.demo5;



import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainUI extends StackPane {

    public MainUI(){

        VBox root = new VBox();


        // CREATE
        View view = new View();
        View1 view1 = new View1();
        View2 view2 = new View2();
        View3 view3 = new View3();
        Model model = new Model();
        Controller controller = new Controller();


        // CONNECT
        view.setModel(model);
        view1.setModel(model);
        view2.setModel(model);
        view3.setModel(model);
        view.new_booking.setModel(model);
        view.multiple_bookings.setModel(model);


        model.addSubscriber(view);
        model.addSubscriber(view1);
        model.addSubscriber(view2);
        model.addSubscriber((InteractionModel) view3);
        model.addSubscriber(view.new_booking);
        model.addSubscriber(view.multiple_bookings);

        //model.addSubscriber(view);
        view.setController(controller);
        view1.setController(controller);
        view2.setController(controller);
        view3.setController(controller);
        view.new_booking.setController(controller);
        view.multiple_bookings.setController(controller);


        controller.setModel(model);


        root.getChildren().addAll(view);
        this.getChildren().add(root);
    }
}
