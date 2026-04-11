package week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {

    LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationService();
    }

    @Test
    void getCurrentLanguage() {
        assertEquals(LocalizationService.Language.EN, localizationService.getCurrentLanguage());
    }

    @Test
    void setCurrentLocalization() {
        localizationService.setCurrentLocalization(LocalizationService.Language.EN);
        localizationService.setCurrentLocalization(LocalizationService.Language.FR);
        localizationService.setCurrentLocalization(LocalizationService.Language.FA);
        localizationService.setCurrentLocalization(LocalizationService.Language.JA);
        assertEquals(LocalizationService.Language.JA, localizationService.getCurrentLanguage());
    }

    @Test
    void loadLocalizations() {
        assertDoesNotThrow( ()-> localizationService.loadLocalizations() );
    }

    @Test
    void getString() {
        localizationService.setCurrentLocalization(LocalizationService.Language.JA);
        assertEquals(LocalizationService.Language.JA, localizationService.getCurrentLanguage());
        assertEquals("default", localizationService.getString(""));

    }
}