package week4;

import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    static Controller controller;

    @BeforeAll
    static void setUp(){
        View.launch(View.class);
        controller = View.getController();
    }

    @Test
    void initialize() {
        assertDoesNotThrow( ()-> controller.initialize() );
    }

    @Test
    void loadLanguageStrings() {
        assertDoesNotThrow( () -> {
            controller.initialize();
            controller.loadLanguageStrings();
        });
    }

    @Test
    void setLeftToRight() {
        assertDoesNotThrow( () -> {
            controller.initialize();
            controller.setLeftToRight();
        });
    }

    @Test
    void setRightToLeft() {
        assertDoesNotThrow( () -> {
            controller.initialize();
            controller.setRightToLeft();
        });
    }
}