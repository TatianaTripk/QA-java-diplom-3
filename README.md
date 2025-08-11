# QA-java-diplom_3
Проект автоматизированного тестирования UI веб-приложения Stellar Burgers
## 📦 Технологии
| Компонент           | Версия     |
|---------------------|------------|
| Java                | 11         |
| JUnit               | 4.13.2     |
| Maven               | 3.9.0      |
| Selenium WebDriver  | 4.33.0     |
| WebDriver Manager   | 6.1.0      |
| DataFaker           | 1.8.1      |
| Allure Framework    | 2.24.0     |
| RestAssured         | 5.5.5      |
## 🚀 Запуск тестов
Для Google Chrome:
```bash
mvn clean test
```
Для Yandex Browser:
```bash
Скачать YandexWebDriver версии, соответствующей версии установленного у вас YandexBrowser: 
https://github.com/yandex/YandexDriver

mvn clean test -Dbrowser=yandex
```
## Генерация отчета Allure

```bash
allure serve target/surefire-reports/