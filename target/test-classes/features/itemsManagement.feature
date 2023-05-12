@regression   @itemsTestsS
Feature: Item Functionality Management

  Background: 
    Given As an entity user, I am logged in
    And I navigate to Items tab

  @createItemsFP
  Scenario Outline: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information "<name>", "<price>", "<unit>", and "<description>"
    And I click Save Item button
    Then The Item is added to the Item list table
    When I delete the item created above
    Then The item is no longer in the items list table

    Examples: 
      | name          | price    | unit | description    |
      | House         |  5000000 | pc   | big house      |
      | cave          |  800000  | pc   | big one        |
      | Apple         |  2000    | pc   | red apple      |
      | juice         |  3500    | box  | A good one     |

  @populationOfAddItemsTable @SmokeTest
  Scenario: As a user, I am able to update an item or a service
    And I click on the more icon represented by three dots for a given item
    And I click on edit
    Then I should be directed to the Edit Item page
    And I update the item to 50000 dollars
    When I click on the update item button
    Then I should see a flash message success
    And I should be directed to the Items Page
    And I should be able to view that the item is updated within the items table
    And the application database should be updated with the Edits made by me for the respective item

   @editinganitem
   Scenario: As a user, I am able to update an item or a service
    When I select the item "iphone"
    And I should be on item details page
    When I update the item price to 80000 dollars
    And I click Update Item button
    Then the Item price is updated to 800 dollars
