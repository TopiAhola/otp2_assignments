package app.calculator;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//@Disabled
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

    @Test
    void clickButtons(){
        assertDoesNotThrow(()-> controller.clickAllButtons() );
    }

}