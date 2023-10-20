Feature:
  As an user,
  I want to verify the search module in Lambda Test eCommerce Playground Website.
  So that I can search as iphone or tablets etc and get related search items.

Background:
  Given navigate to Lambda Test eCommerce Playground Website
  And click on "Submit" button


  Scenario: Verify that users can search with valid search query.
   # Given navigate to Lambda Test eCommerce Playground Website
    When enter a predefined search query 'iphone'
   # And click on "Submit" button
    Then user should get relevant search items




  Scenario: Verify that user can search with filter option.
   # Given navigate to Lambda Test eCommerce Playground Website
    When enter a search query 'iphone'
    # And click on "Submit" button
    And click on "Tablets" filter option
    And click on "Search" button
    Then user should get relevant filtered search items




  Scenario: Verify that users can't search with invalid search query.
    # Given navigate to Lambda Test eCommerce Playground Website
    When enter a invalid search as 'dz343434'
   # And click on "Submit" button
    Then user should not get any relevant items
    And capture screenshot to validate


  Scenario: Verify that users can search with search query.
    # Given navigate to Lambda Test eCommerce Playground Website
    When enter search query 'canon EOS 5D'
    # And click on "Submit" button
    Then user should get related search items
    And click one of the search items
    And capture the screenshot to validate

