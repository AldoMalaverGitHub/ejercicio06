module sunat.gob.pe.ejercicio06 {
    requires javafx.controls;
    requires java.base;
    requires javafx.fxml;
    requires java.sql;
    requires retrofit;
    requires converter.scalars;
    requires converter.gson;
    
    opens sunat.gob.pe.ejercicio06;
    opens sunat.gob.pe.ejercicio06.controller;
    exports sunat.gob.pe.ejercicio06;
}
