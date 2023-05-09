@forgotPassword @regression
Feature: Crater Forgot Password

  Background: 
    Given I am crater user, I navigate to the Login screen
    And I click on the Forget Password? Link

  @forgotPasswordLink
  Scenario: As a user, i should be able to click on the forget password link
    Then I should be directed to a new page
    And I should see text box titled Enter email, Send Reset Link, Back to Login

  @resetPassword
  Scenario: As a user, i should be able to reset password
    And I enter a value for the email value
    Then click on the Send Reset Link
    Then I navigate to my gmail and click on the reset password link in my gmail

  @invalidResetPassword
  Scenario: 
    And I enter invalid value for the email value amd enter email in the incorrect format
    Then I should see error message Incorrect Email
    And If I leave email field blank
    Then I should see error message Field is required

  @resetPasswordviaEmail
  Scenario: As a user, i should be able to reset password via email
    Then I enter valid Email
    And I click on Send Reset Link
    Then I navigate to my gmail and click on the reset password link in my gmail
    Then I should be directed to a new page with Email, Password, Retype Password
    And i enter valid "craterusertesting@gmail.com" "Password1234@" and "Password1234@"
    Then If i validation passed, i should be directed back to login page

  @invalidResetPasswordviaEmail
  Scenario: As a user, i should be able to reset password via email
    Then I enter valid Email
    And I click on Send Reset Link
    Then I navigate to my gmail and click on the reset password link in my gmail
    Then I should be directed to a new page with Email, Password, Retype Password
    And i enter invalid "craterusertesting@gmail.com" "Password1234@" and "Password1234@" and i should see error message
