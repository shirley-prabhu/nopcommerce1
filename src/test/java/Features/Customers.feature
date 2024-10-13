Feature: Customer
 @sanity
  Scenario: Add a new customer
    Given User Launch Firefox browser
    And When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And When User Enter Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then user can view page titled  "Dashboard / nopCommerce administration"
    When User Clicks on customer Menu
    And user clicks on customer menu item
    And click Add Customer
    Then user can view add customer page
    When User enters customer info
    And Clicks on save button
    Then user can view confirmation msg "The new customer has been added successfully."
    And Close Browser

 @regression
    Scenario: Search Customer By Email ID
      Given User Launch Firefox browser
      And When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
      And When User Enter Email as "admin@yourstore.com" and password as "admin"
      And Click on Login
      Then user can view page titled  "Dashboard / nopCommerce administration"
      When User Clicks on customer Menu
      And user clicks on customer menu item
      And Enter Customer Email
      When Click on Search button
      Then User should find the email in the search table
      And Close Browser

      Scenario: Search Customer By Name
        Given User Launch Firefox browser
        And When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
        And When User Enter Email as "admin@yourstore.com" and password as "admin"
        And Click on Login
        Then user can view page titled  "Dashboard / nopCommerce administration"
        When User Clicks on customer Menu
        And user clicks on customer menu item
        And Enter Customer First Name
        And Enter Customer Last Name
        When Click on Search button
        Then User should find the Name in the search table
        And Close Browser
