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
@ItemTests @Regression
Feature: Item Functionality Management
  
  Background: 
  Given As an enrity user, I am logged in
	And I navigate to Items tab
	  
  @VerifyUIComponentsOnItemsPage
  Scenario: As a user, I am able to see UI components on Items Page
     Then I should be navigated to a page titled Items
     And I should see the menu navigation path as Home Items placed under Items
     And I should see a secondary button titled Filter
     And I should see a primary button titled Add Item
     And I should see a table with select all checkbox, NAME, UNIT, PRICE, ADDED ON
     And A link icon showing three dots
     When I click on a link icon with three dots
     Then I should see Edit with an edit icon
     And I should see Delete with a delete icon
     And Verify the pagination text at the bottom of the page
     When I click on right arrow navigation
     Then I should navigate to the next page 
     When I click on left arrow navigation
     Then I should navigate to previous page

    
  @VerifyAddaItemUIcomponents
  Scenario: As a user, I am able to see UI components on New Item page
 		 When I click on Add Item button
 		 Then I should be on New Item page
		 And I should see fields Name, Price, Unit, Description
 	
  
  @ValidCreateItem  @SmokeTest
  Scenario: As a user, I am able to add a item successfully
     When I click on Add Item button
 		 Then I should be on New Item page
		 When I provide item information name "iphone", price "1800", unit "pc", and description "too many iphone"
		 And I click Save Item button
		 Then I should see a flash message success 
     And The Item is added to the Item list table
     And I should be able to see the item in database
	
	@BlankNameFieldforCreateItem
  Scenario: As a user, I am unable to create an item with empty name field
     When I click on Add Item button
 		 Then I should be on New Item page
 		 When I leave the name fild blank
 		 And I click Save Item button
 		 Then I should see field is required error message
 		 And I should still be New Item page
 	
 	@InvalidNameFieldforCreateItem
 	Scenario: As a user, I am unable to create an item with less than three character
 		 When I click on Add Item button
 		 Then I should be on New Item page
 		 When I enter name as "AZ" 
 		 And I click Save Item button
 	 	 Then I should see atleast three letters required error message
 		 And I should still be New Item page
 	
  @FilterNameCreateItem
 	Scenario: As a user, I am able to filter using item Name 
 		When I click on Filter Icon
 		Then I should see Name, Unit, Price boxes 
 		And I should see Clear All link
 		When I type a name "iphone609" in the Name text box
 		Then I should get item matching the name
 		When I click on the ‘Clear All’ link
 		Then the application will display the current list of items
 		When I click on Filter Icon
 		Then I should see the name, unit, price, and clear all options disapear
 	
 	@FilterUnitCreateItem
 	Scenario: As a user, I am able to filter using item unit
 		When I click on Filter Icon
 		Then I should see Name, Unit, Price boxes 
 		And I should see Clear All link
 		When I type a "ton" in the unit text box and click on it
 		Then I should get item matching the unit with name "iphone777"
 		When I click on the ‘Clear All’ link
 		Then the application will display the current list of items
 		When I click on Filter Icon
 		Then I should see the name, unit, price, and clear all options disapear
 		
 		
 	@NoResultFilterCreateItem
 	Scenario: As a user, I am able to filter using item price
 		When I click on Filter Icon
 		Then I should see Name, Unit, Price boxes 
 		And I should see Clear All link
 		When I type a name "ashxxhegfhdgsf" in the Name text box
 		Then I should no result found message
 		When I click on the ‘Clear All’ link
 		Then the application will display the current list of items
 		When I click on Filter Icon
 		Then I should see the name, unit, price, and clear all options disapear
