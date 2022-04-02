Feature: GetResponseTest
  This feature deals with the application login

  Scenario: Get single Post
    Given I perform GET operation for "/posts"
    Then I should see the author name as "Marcelo"

  Scenario: Get list of posts authors
    Given I perform GET operation for "/post"
    And I should see authors names

  Scenario: Verify parameter of GET
    Given I perform GET operation for "/post"
    And I should verify GET Parameter