CREATE DATABASE IF NOT EXISTS otp2_week3
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE otp2_week3;


    CREATE TABLE IF NOT EXISTS calculation_records (
        id INT AUTO_INCREMENT PRIMARY KEY,
        distance DOUBLE NOT NULL,
        consumption DOUBLE NOT NULL,
        price DOUBLE NOT NULL,
        total_fuel DOUBLE NOT NULL,
        total_cost DOUBLE NOT NULL,
        language VARCHAR(10),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS localization (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `key` VARCHAR(100) NOT NULL,
    value VARCHAR(255) NOT NULL,
    language VARCHAR(10) NOT NULL,
    UNIQUE KEY unique_key_lang (`key`, `language`)
);


INSERT INTO localization (`key`, value, language) VALUES
    ('titleLabel', 'Fuel Consumption and Trip Cost Calculator', 'en'),
    ('btnEN', 'English', 'en'),
    ('btnFR', 'Français', 'en'),
    ('btnJP', '日本語', 'en'),
    ('btnIR' , 'فارسی' , 'en'),
    ('lblDistance', 'Distance (km):', 'en'),
    ('lblConsumption', 'Consumption (l/100km):', 'en'),
    ('lblPrice', 'Price per litre:', 'en'),
    ('lblResult', 'Result:', 'en'),
    ('btnCalculate', 'Calculate', 'en'),
    ('txtDistance', 'Distance traveled', 'en'),
    ('txtConsumption', 'Fuel consumption', 'en'),
    ('txtPrice', 'Price of fuel', 'en'),
    ('lblResultText', 'Result shows here', 'en'),
    ('errorMessage', 'Bad input', 'en'),

    ('titleLabel' , 'Calculateur de consommation de carburant et du coût du trajet', 'fr'),
    ('btnEN' , 'English', 'fr'),
    ('btnFR' , 'Français', 'fr'),
    ('btnJP' , '日本語', 'fr'),
    ('btnIR' , 'فارسی' , 'fr'),
    ('lblDistance' , 'Distance (km) :', 'fr'),
    ('lblConsumption' , 'Consommation (l/100 km) :', 'fr'),
    ('lblPrice' , 'Prix par litre :', 'fr'),
    ('lblResult' , 'Résultat :', 'fr'),
    ('btnCalculate' , 'Calculer', 'fr'),
    ('txtDistance' , 'Distance parcourue', 'fr'),
    ('txtConsumption' , 'Consommation de carburant', 'fr'),
    ('txtPrice' , 'Prix du carburant', 'fr'),
    ('lblResultText' , 'Le résultat s’affiche ici', 'fr'),
    ('errorMessage','Mauvaise saisie', 'fr'),

    ('titleLabel',  '燃費と旅行費用の計算機', 'ja'),
    ('btnEN',  'English', 'ja'),
    ('btnFR',  'Français', 'ja'),
    ('btnJP',  '日本語', 'ja'),
    ('btnIR' , 'فارسی' , 'ja'),
    ('lblDistance',  '距離 (km):', 'ja'),
    ('lblConsumption',  '燃費 (l/100km):', 'ja'),
    ('lblPrice',  '1リットルあたりの価格:', 'ja'),
    ('lblResult',  '結果:', 'ja'),
    ('btnCalculate',  '計算する', 'ja'),
    ('txtDistance',  '走行距離', 'ja'),
    ('txtConsumption',  '燃料消費量', 'ja'),
    ('txtPrice',  '燃料の価格', 'ja'),
    ('lblResultText',  '結果がここに表示されます', 'ja'),
    ('errorMessage',  '不正な入力', 'ja'),

    ('titleLabel',  ' محاسبه‌گر مصرف سوخت و هزینه سفر', 'fa'),
    ('btnEN', ' English', 'fa'),
    ('btnFR', ' Français', 'fa'),
    ('btnJP', ' 日本語', 'fa'),
    ('btnIR', ' فارسی', 'fa'),
    ('lblDistance', ' مسافت (کیلومتر):', 'fa'),
    ('lblConsumption', ' مصرف (لیتر در ۱۰۰ کیلومتر):', 'fa'),
    ('lblPrice', ' قیمت هر لیتر:', 'fa'),
    ('lblResult', ' نتیجه:', 'fa'),
    ('btnCalculate', ' محاسبه', 'fa'),
    ('txtDistance', ' مسافت طی‌شده', 'fa'),
    ('txtConsumption', ' میزان مصرف سوخت', 'fa'),
    ('txtPrice', ' قیمت سوخت', 'fa'),
    ('lblResultText', ' نتیجه در اینجا نمایش داده می‌شود', 'fa'),
    ('errorMessage', ' ورودی نامعتبر', 'fa')
;