Scenario: Test the calculator's ability to calculate 22 percent

Given a calculator in its initial state
When I press 22
And then %
Then I expect the calculator to display .22

Scenario: Test the calculator's ability to calculate 22+2

Given a calculator in its initial state
When I press 22
And then +
And then 2
And then =
Then I expect the calculator to display 24