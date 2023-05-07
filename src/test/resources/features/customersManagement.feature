<<<<<<< HEAD

@regression
Feature: Customer Management
Background:
 
=======
	@regression
	Feature: Customer Management
	
	Background:
>>>>>>> 899665560319d64df749cbc5bcf5fff7dee2f6fc
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

<<<<<<< HEAD


#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@createCustomerWebervice @regression
Feature: Crater app customers management
	
	Background: 
		Given I am an authorized customer of Create customer webservice with following credentials
		"""
		{
			"username": "entityadmin@primetechschool.com",
    	"password": "primetech@school",
    	"device_name":"mobile_app"
		}
		"""


  @createCustomerValid @smokeTest
  Scenario: Successful customer creation
  	When I make POST request with following request body
  	"""
  	{
  		"name": "Patrick",
  		"email": "patty.mahomes@gmail.com",
  		"enable_portal": "true",
  		"billing": "[]",
  		"shipping": "[]"
  	}
  	"""
    Then I should get HTTP Status Code 200
    And a customer should be created in app database
    | Patrick | patty.mahomes@gmail.com |

=======
>>>>>>> 899665560319d64df749cbc5bcf5fff7dee2f6fc
