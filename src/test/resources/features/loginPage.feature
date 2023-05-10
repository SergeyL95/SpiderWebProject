@loginM
    Feature: User with permissions should be able interact with login page
   	
  Background:
  Given I am crater user, I navigate to the “Prime Tech Invoice Application” login page
   	 

@loginUi @WIP
Scenario:  the system should display the Login page with the UI components as follows 
 	And Page title crater
	And text box with label "email*" and text box with label "password*"
	And a link titled forgot password? exist
	And a primary button labeled "Login"
	And a text area with the following "Copyright @ Crater Invoice, Inc. 2023" located on the bottom left 
	And a heading with following text "Simple Invoicing for Individuals Small Businesses" exist
	And a heading with following text "Crater helps you track expenses, record payments & generate beautiful invoices & estimates" exist

@loginWithValidCredentials
Scenario: As a user i should be able to login with valid credentials
And I enter a valid email and password value 
And I click on the login button
Then The system should validate that the username and password combination matches an existing user record in the application database.
And Upon successful login the system should direct the user to the Dashboard page.

@loginWithInvalidCredentials
Scenario: As a user i should not be able to login with invalid credentials
And I enter an invalid email and password value, 
Then System should prompt the user with a flash message in a red box with the following text Error Those credentials do not match our records
And Flash message should have a close button to the right and should disappear from the user’s view in less than or equal to 5 seconds.

@loginWithEmptyFields
Scenario: As a user i should not be able to login with empty field
And I leave the email and password field empty 
And I leave the just email field empty
And I leave the just password field empty 
Then System should prompt the user with the following inline message for the respective scenarios 
When email is required error should appear when a user leaves email is blank 
And password is required error should appear when a user leaves password is blank
      


