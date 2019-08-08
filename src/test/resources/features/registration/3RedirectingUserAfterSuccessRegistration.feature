@tag=acceptance
Feature: Redirecting to the ESIA Access Granting Page after success User registration
  In order to be able to grant access to ESIA
  As a successfully registered customer
  I want to be redirected to ESIA Access Granting page

  Scenario Outline: Redirecting to the ESIA Access Granting Page after success User registration
    Given the User browsing the Web with deepLink
    And   user with "<emailAddress>" is absent at IDP
    When  user registers at the Marketplace as "<surname>" "<name>" "<patronymic>" with "<emailAddress>" and "<phoneNumber>"
    Then  he should see the ESIA access granting page

    Examples:
      | surname     | name  | patronymic | emailAddress               | phoneNumber  |
      | Шнипельсон  | Карл  | Мадестович | karl.shnipelson@moex.com   | +77770001122 |