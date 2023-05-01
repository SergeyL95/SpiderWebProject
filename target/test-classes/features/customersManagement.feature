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
