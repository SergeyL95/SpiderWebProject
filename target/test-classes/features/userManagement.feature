
@loginAndForgotPassword @regression
Feature: Crater Login/Forgot Password

  Background: 
    Given I am crater user, I navigate to the “Prime Tech Invoice Application” login page
    And I click on the Forget Password? Link
    And I click on the login button

  @forgotPasswordLink
  Scenario: As a user, i should be able to click on the forget password link
    Then I should be directed to a new page
    And I should see text box titled Enter email, Send Reset Link, Back to Login

  @resetPassword
  Scenario: As a user, i should be able to reset password
    And I enter a value for the email value
    Then click on the Send Reset Link
    Then I navigate to my gmail
    And I enter username and password

  @invalidResetPassword
  Scenario: 
    And I enter invalid value for the "email" value amd enter email in the incorrect format "craterusertesting.gmail.com"
    Then I should see error message Incorrect Email
    And If I leave email field " "
    Then I should see error message Field is required

  @resetPasswordviaEmail
  Scenario: As a user, i should be able to reset password via email
    Then I enter valid Email
    And I click on Send Reset Link
    Then I navigate to my gmail
    And I enter "username" and "password"
      | craterusertesting@gmail.com | CraterAppUser123 |
    Then I click on the Reset Password link in the email i received
    Then I should be directed to a new page with Email, Password, Retype Password
    And i enter valid "username" "password" and "retype password"
      | craterusertesting@gmail.com | Password1234@ | Password1234@ |
    Then If i validation passed, i should be able to reset my account password
    And directed to the login page

  @invalidResetPasswordviaEmail
  Scenario: As a user, i should be able to reset password via email
    Then I enter valid Email
    And I click on Send Reset Link
    Then I navigate to my gmail
    And I enter "username" and "password"
      | craterusertesting@gmail.com | CraterAppUser123 |
    Then I click on the Reset Password link in the email i received
    Then I should be directed to a new page with Email, Password, Retype Password
    And i enter invalid "username" "password" and "retype password" and i should see error message
      | craterusertesting@craterss.com | password12343 | password12343 |
      
      

