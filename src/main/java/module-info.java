module cupcakes.burtininko_dvikova {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens cupcakes.burtininko_dvikova to javafx.fxml;
    exports cupcakes.burtininko_dvikova;
}