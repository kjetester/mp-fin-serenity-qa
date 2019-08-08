@tag=acceptance
Feature: Existing User registration
  In order to avoid to register at the Marketplace with credentials that existing in the IDP
  As System
  I want to prevent registration with a phone number or an Email that has been already used by existing users

  Scenario Outline:  Prevent registration with a phone number or an Email that has been already stored in IDP
    Given the User browsing the Web with deepLink
    When  user registers at the Marketplace as "<surname>" "<name>" "<patronymic>" with "<emailAddress>" and "<phoneNumber>"
    Then  he should see the registration page
#    And   he should see "<message>" on the registration page

    Examples:
      | surname | name  | patronymic  | emailAddress             | phoneNumber  | message                                             |
      | Иванов  | Игорь | Соломонович | karl.shnipelson@moex.com | +77770001122 | Указанный адрес электронной почты уже используется  |
      | Бякин   | Иван  | Самуилович  | ivan.byakin@moex.com     | +77770002233 | Указанный номер телефона уже используется           |