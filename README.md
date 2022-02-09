# Adidas Web Test Challenge

The framework :
- Gradle
- Java 8
- Serenity BDD

Why I choose this framework :
- Gradle is being used to maintain the library dependencies.
- Another great alternative for Cucumber (beside the one that I used in API Test Challenge).
- Easy BDD implementation and it will produce great reports that is easily read by anyone.
- I am most familiar with Java and it is widely used as a great language in automation testing.

Pre-requisite :
- JDK 8
- Chrome

How to run :
- run this command : ./gradlew clean test -Pdriver=chrome

Report :
inside target/site/serenity/index.html (I attached the report from my previous result)

Logs :
- target/automation.log : internal automation log (can be set by calling Logger from steps class)