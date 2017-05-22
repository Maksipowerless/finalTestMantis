Feature: Work with issues
  Scenario: Scenario test issue
    Given Login with "tester"
      And Click button Report Issue
    When Fill fields issue with "form1"
      And Create issue
      And Click view issues
    Then Check view issues contains create issue with "assigned" and with "form1"
    Given Logout
      And Login with "developer"
    When Click view issue
    Then Check view issues contains create issue with "assigned" and with "form1"
    When Open issue by number with "form1"
    Then Check data in issue with "form1"
    When Change issue status to "resolved"
      And Logout
      And Login with "manager"
      And Click view issue
    Then Check view issues contains create issue with "resolved" and with "form1"
    When Open issue by number with "form1"
      And Change issue status to "closed"
      And Close issue
      And Open resentlty modified issues
    Then Check view issues contains create issue with "closed" and with "form1"