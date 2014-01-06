Scenario: Tests the calculator using in-line examples tables.

Given a calculator in its initial state

!-- No problem adding extra whitespace between clauses. 

When I enter these key sequences:
|sequence|
|22 + 2 =|
|4 + 4.35 =|
|100 * 3 % =|
|2 + + + + + =|
|100 ! * 1 ! % % = * 10000 =|

Then I expect these values to be displayed:
|results|
|24|
|8.35|
|3|
|64|
|100|