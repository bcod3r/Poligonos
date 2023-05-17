module com.example.hackatoncun {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hackatoncun to javafx.fxml;
    exports com.example.hackatoncun;
}