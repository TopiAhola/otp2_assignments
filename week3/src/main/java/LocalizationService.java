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

    public Map<String,String> localization_en;
    public Map<String,String> localization_fr;
    public Map<String,String> localization_ja;
    public Map<String,String> localization_fa;

    public Map<String,String> currentLocalization;
    public Language currentLanguage;

    public LocalizationService(){
        localization_en = new HashMap<String,String>();
        localization_fr = new HashMap<String,String>();
        localization_ja = new HashMap<String,String>();
        localization_fa = new HashMap<String,String>();

        currentLocalization = localization_en;
        currentLanguage = Language.en;

        //load from database
        loadLocalizations();
    }

    public enum Language{
        en,fr,ja,fa
    }

    public Language getCurrentLanguage(){
        return currentLanguage;
    }

    public void setCurrentLocalization(Language language) {
        switch (language) {
            case en:
                currentLocalization = localization_en;
                currentLanguage = Language.en;
                break;
            case fr:
                currentLocalization = localization_fr;
                currentLanguage = Language.fr;
                break;
            case ja:
                currentLocalization = localization_ja;
                currentLanguage = Language.ja;
                break;
            case fa:
                currentLocalization = localization_fa;
                currentLanguage = Language.fa;
                break;
            default:
                currentLocalization = localization_en;
                break;
        }
    }

    public void loadLocalizations(){
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM localization");
            ) {

            //insert results to maps
            while(result.next()){
                String key = result.getString("key");
                String value = result.getString("value");
                String language = result.getString("language");

                if (language == null || key == null || value == null){
                    System.out.println("Null values in database!");
                    System.out.println("Key: " + key + " Value: " + value + " Language: " + language);
                } else {

                    if (language.equals("en")) {
                        localization_en.put(key, value);
                    } else if (language.equals("fr")) {
                        localization_fr.put(key, value);
                    } else if (language.equals("ja")) {
                        localization_ja.put(key, value);
                    } else if (language.equals("fa")) {
                        localization_fa.put(key, value);
                    } else {
                        System.out.println("Language");
                    }
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getString(String key){
        return currentLocalization.getOrDefault(key, "default");

    }


}
