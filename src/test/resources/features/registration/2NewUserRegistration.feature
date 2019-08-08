@tag=acceptance
Feature: New User Registration in IDP
  In order to work with Marketplace
  As an perspective but unregistered customer
  I want to be able to register

  Scenario Outline: New User Registration in IDP
    Given the User browsing the Web with deepLink
    And   user with "<emailAddress>" is absent at IDP
    When  user registers at the Marketplace as "<surname>" "<name>" "<patronymic>" with "<emailAddress>" and "<phoneNumber>"
    Then  user should be registered at the IDP as "<surname>" "<name>" "<patronymic>" with "<emailAddress>" and "<phoneNumber>"

    Examples:
      | surname     | name  | patronymic | emailAddress               | phoneNumber  |
      | Шнипельсон  | Карл  | Мадестович | karl.shnipelson@moex.com   | +77770001122 |
      | Нюренберчик | Илья  |            | ilya.nurnberchick@moex.com | +77770002233 |