@tag=acceptance
Feature: Landing on the Registration Page with a deeplink from aggregator
  In order to usability
  As an unregistered customer
  Using aggregator
  I want to be able to land on the registration page

  Scenario: Landing on the Registration Page
    When the User browsing the Web with deepLink
    Then he should see the registration page