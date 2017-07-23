Feature: counting votes
  As a BBC television presenter
  I want to see the counts for candidates within a given time frame
  So that I can announce the winner of the competition

  Scenario: partition choices sent to the queue by candidate percentage
    Given 10000000 votes were received
    And votes were distributed against candidates as:
      | candidate   | percentage | count   |
      | candidate-1 | 5          | 500000  |
      | candidate-2 | 10         | 1000000 |
      | candidate-3 | 20         | 2000000 |
      | candidate-4 | 25         | 2000000 |
      | candidate-5 | 40         | 3000000 |
    And no more than 3 votes per user are allowed
    When CountMeUp is asked for the results
    Then it responds in under 1 seconds
    And the final counts are:
      | candidate   | count   |
      | candidate-1 | 500000  |
      | candidate-2 | 1000000 |
      | candidate-3 | 2000000 |
      | candidate-4 | 2000000 |
      | candidate-5 | 3000000 |
