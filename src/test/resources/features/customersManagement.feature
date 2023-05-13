@customerTest @Regression
Feature: Customer Management

Background:
Given I navigate to Customers tab
Then Validate I am on the Customers page (Header)  

@customerPageValidation
Scenario: As a user, I am able to create a customer and manage customer
And I should be able to see button titled Filter with a filter Icon
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
When I click +New Customer botton, I should directed to New Customer Page
And I should be able to see basic info field
When I click on Primary Currency dropdown, I should be able to see 72 different curencies
When I leave the Display Name field empty, I should see Field is required message
When the Email field does not follow (@domain.com) format, I should see Incorrect Email message
When Website field is not correct format,I should see Invalid url error message 
When I provide Valid input for the required fields and click Save Customer button, I should be directed to Sales & Expenses page

@portalAccessValidation @smoketest
Scenario: As a user, I am able to create a customer and manage customer
When I click +New Customer botton, I should directed to New Customer Page
When I click on the Toggle Switch i should view a text box titled: “Customer Portal Login URL” and “http://invoice.primetech-apps.com/crater-invoice/customer/login “ Url
When I click copy to clipboard button, I should see “Please copy & forward the above given URL to your customer for providing access.” message
And i should be able to see password and confirm password field
When I provide invalid data to password field,i should see Password must contain 8 characters error message
When I provide different password to the confirm password field I should see Passwords must be identical: password 12345678 confirm password 1234567

@billingAddressValidation @smoketest
Scenario: As a user, I am able to create a customer and manage customer
When I click +New Customer botton, I should directed to New Customer Page
Then I should be able to see Billing Address field
And I should be able to see following fields: Name, State, City, Country, Address Street1, Address Street2, Zipcode 

@shippingAddressValidation 
Scenario: As a user, I am able to create a customer and manage customer
When I click +New Customer botton, I should directed to New Customer Page
Then I should be able to see Shipping Address field
And a button titled Copy from Billing

@filteringCustomerTableDataValidation
Scenario: As a user, I am able to create a customer and manage customer
When I click on Filter Icon, I should be able to see Display Name, Contact Name, Phone and clear all link
When I type value in the contact name field, the matching result should return
When I type value in the phone field,the matching result should return
When I type value in the contact name and phone field,the matching result should return
When I enter a value that is not exist in the database I should see the empty table with No Results Found message
When I click clear all, application will display current list of customer
When I click on Filter Icon again, I should be able to see Display Name, Contact Name, Phone and clear all link

