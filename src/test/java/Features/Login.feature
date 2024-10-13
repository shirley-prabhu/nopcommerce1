Feature: Login
  @sanity
  Scenario: Successfully Login with correct credentials
    Given User Launch Firefox browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And When User Enter Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then page titled should be "Dashboard / nopCommerce administration"
    When User clicks on Logout button
    Then page titled "Your store. Login"
    And Close Browser

    @regression
    Scenario Outline: Login Data Driven
      Given User Launch Firefox browser
      When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
      And When User Enter Email as "<email>" and password as "<password>"
      And Click on Login
      Then page titled should be "Dashboard / nopCommerce administration"
      When User clicks on Logout button
      Then page titled "Your store. Login"
      And Close Browser

      Examples:
      | email | password |
      | admin@yourstore.com | admin |
      | admin@yourstore.com | 123admin|