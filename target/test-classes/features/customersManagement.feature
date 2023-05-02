@regression
Feature: Customer Management
Background:
 
    Given As a user, I am on the login page
    When I enter valid username and valid password
    And I click on login button
    Then I should be on user profile page
    And I navigate to Customers tab

@customerPageValidation
Scenario: As a user, I am able to vist the customer page 
Then Validate I am on the Customers page (Header)
And I should be able to see button titled filter
And I should be able to see a primary button titled + New Customer
And I should be able to see these columns: Select All checkbox, Name,Phone,Amount Due, Added On
And I should be able to see A link icon showing three dots with the following options:edit, view, delete
And I should be able to see Pagination navigation with left and right controls
When I click on right arrow
Then I should be able to nevegate to the next page
When I click on left arrow
Then I should be able to nevegate to the previous page
When I am on the first page, left arrow should be disabled
When I am on the last page, right arrow should be disabled

@basicInfoValidation
Scenario: As a user, I am able to create a customer and manage customer
Then Validate I am on the Customers page (Header)
When I click +New Customer botton, I should directed to New Customer Page
And I should be able to see basic info field
When I click on Primary Currency dropdown, I should be able to see 72 different curencies
When I leave the Display Name field empty, I should see Field is required message
When I input less the three character for the Dispay Name field,I should be able to see Name must have at least 3 letters message
When the Email field does not follow (@domain.com) format, I should see Incorrect Email message
When I input less the three character for the Prefix field,I should be able to see Name must have at least 3 letters message
When Website field is not correct format,I should see Invalid url error message 
When I provide Valid input for the required fields and click Save Customer button, I should be directed to Sales & Expenses page


