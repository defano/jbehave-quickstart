Scenario: Tests the calculator against some unusual inputs using an "Examples" table.

Given a calculator in its initial state
When I enter <sequence>
Then I expect <result> to be displayed

Examples:
|sequence|result|
|7 * 3 % * 100 * 1 ! =|-21|
|1 ! ! ! ! ! !|1|
|2 % % % %|2.0E-8|
|100 = = = = = = * * = |1.0E8|

