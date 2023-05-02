@Regression
Feature: Edit item in Prime Tech Invoice Application

  Background: 
    Given I am an external user of the "Prime Tech Invoice Application"

  @createItemsFP
  Scenario Outline: As a user, I am able to create an item or a service
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information "<name>", "<price>", "<unit>", and "<description>"
    And I click Save Item button
    Then The Item is added to the Item list table

    Examples: 
      | name         | price | unit | description    |
      | Atomic Habit |  1899 | pc   | A novel        |
      | T-shirt      |  1299 | pc   | A cotton shirt |
      | Mug          |  2000 | pc   | A coffee mug   |

  @populationOfAddItemsTable @SmokeTest
  Scenario: As a user, I am able to update an item or a service
    And I navigate to Items tab
    And I click on the more icon represented by three dots for a given item
    And I click on edit
    Then I should be directed to the Edit Item page
    And I should be able to view all the item fields
    And I should be able to edit all the item fields
    And the application should perform the validations for each respective
    When I click on the 'Update Item' button
    Then I should see a flash message "Success! Item updated successfully" with a close button to the right
    And the flash message should disappear within 5 seconds or less
    And I can close the flash message by clicking on the 'X' button
    And I should be directed to the Items Page
    And I should be able to view that the item is updated within the items table
    And the application database should be updated with the Edits made by me for the respective item

  @Test2
  Scenario: Editing an item
    When I click on edit
    Then I should be directed to the Edit Item page.
    When I select the item "Apple EarPods"
    And I should be on item details page
    When I update the item  to 25000 dollars
    And I click Update Item button
    Then the Item price is updated to 25000 dollars
    When I click on the ‘Update Item’ button then
    Then I should see a flash message with the text "Success! Item updated successfully" and a close button to the right
    And the flash message should disappear within 5 seconds or less
    And I should be directed to the Items Page
    And I should be able to view that the item is updated within the items table
    And The application database should be updated with the Edits made by the user for the respective item\

  @Test3
  Scenario: Deleting an item
    When I click on Delete
    Then I should be prompted with the Modal
    And the Modal Title should be Alert Icon "Are you sure?"
    And the Modal Message should be "You will not be able to recover this item"
    And the Modal should have a Button-1 with text ‘Ok'
    And the Modal should have a Button-2 with text ‘Cancel'
    When I click on "Cancel" or anywhere on the page
    Then the alert modal should be closed
    When I click on "Ok"
    Then I should see a flash message with the text "Success! Item deleted successfully" and a close button to the right
    And the user can close the flash message by clicking on the "X" button
    And I should be directed to the items table
    And the item should not be visible within the table
    And the item’s record should be deleted from the application database

  @Test4
  Scenario: Delete Item - Multiple Deletion
    And I should be able to view all the item fields
    And I should be able to edit all the item fields
    And The application should perform the validations for each respective field
    When I click on the "Update Item" button
    Then I should see a flash message with the text "Success! Item updated successfully" and a close button to the right
    And the flash message should disappear within 5 seconds or less
    And I should be directed to the Items Page
    And I should be able to view that the item is updated within the items table
    And the application database should be updated with the Edits made by the user for the respective item
