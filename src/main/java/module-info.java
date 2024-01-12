module wec.wec_2024 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens wec.wec_2024 to javafx.fxml;
    exports wec.wec_2024;
}