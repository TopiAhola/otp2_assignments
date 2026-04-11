package app.calculator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a class that fetches localized UI strings from the database:
 * • Query localization_strings table based on selected language
 * • Return a map of key-value pairs
 * • Handle database connection properly
 * • Cache loaded strings for performance optimization
 * Required Methods:
 * • loadStrings(String language) – loads all UI strings for a language
 * • getString(String key) – returns a specific localized string
 * • getAllKeys() – returns all available keys for current language
 */
public class LocalizationService {

    private Map<String,String> localizationEn;
    private Map<String,String> localizationFr;
    private Map<String,String> localizationJa;
    private Map<String,String> localizationFa;

    private Map<String,String> currentLocalization;
    private Language currentLanguage;

    public LocalizationService(){
        localizationEn = new HashMap<>();
        localizationFr = new HashMap<>();
        localizationJa = new HashMap<>();
        localizationFa = new HashMap<>();

        currentLocalization = localizationEn;
        currentLanguage = Language.EN;

        //load from database
        loadLocalizations();
    }

    public enum Language{
        EN, FR, JA, FA
    }

    public Language getCurrentLanguage(){
        return currentLanguage;
    }

    public void setCurrentLocalization(Language language) {
        switch (language) {
            case EN:
                currentLocalization = localizationEn;
                currentLanguage = Language.EN;
                break;
            case FR:
                currentLocalization = localizationFr;
                currentLanguage = Language.FR;
                break;
            case JA:
                currentLocalization = localizationJa;
                currentLanguage = Language.JA;
                break;
            case FA:
                currentLocalization = localizationFa;
                currentLanguage = Language.FA;
                break;
            default:
                currentLocalization = localizationEn;
                break;
        }
    }

    public void loadLocalizations(){
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement(); //`id`,`key`,`value`,`language`
                ResultSet result = statement.executeQuery("SELECT `id`,`key`,`value`,`language` FROM localization");
            ) {

            //insert results to maps
            while(result.next()){
                String key = result.getString("key");
                String value = result.getString("value");
                String language = result.getString("language");

                if (language == null || key == null || value == null){
                    Logger.log(new Exception("Null values in database!"));
                    Logger.log("Key: " + key + " Value: " + value + " Language: " + language);
                } else {

                    if (language.equals("en")) {
                        localizationEn.put(key, value);
                    } else if (language.equals("fr")) {
                        localizationFr.put(key, value);
                    } else if (language.equals("ja")) {
                        localizationJa.put(key, value);
                    } else if (language.equals("fa")) {
                        localizationFa.put(key, value);
                    } else {
                        Logger.log("Language");
                    }
                }
            }



        } catch (Exception e) {
            Logger.log(e);
        }
    }

    public String getString(String key){
        return currentLocalization.getOrDefault(key, "default");

    }


}
