module com.ksr2.ksr_2_gui {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.ksr2.ksr_2_gui to javafx.fxml;
    exports com.ksr2.ksr_2_gui;
}