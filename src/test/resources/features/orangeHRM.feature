Feature: OrangeHRM User Management

  Scenario: Add and Delete a User
    Given I am on the login page
    When I log in with "Admin" and "admin123"
    And I navigate to the Admin section
    And I get the number of records
    And I add a new user with "TestUser123" and "Password@123"
    Then I verify the number of records increased by 1
    When I search for "TestUser123"
    And I delete the user
    Then I verify the number of records decreased by 1
