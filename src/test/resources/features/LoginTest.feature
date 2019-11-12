Feature: Credential Tests

  @ValidCase
  Scenario: Successful login
    Given Login page
    When Submit "YOUR_VALID@EMAIL.COM" and "YOUR_V4L1D_Password"
    Then Login success

  @InvalidCase
  Scenario Outline: Failed login
    Given Login page
    When Submit "<email>" and "<password>"
    Then Login failed
    Examples:
    | email             | password |
    | qwert             | 123456   |
    |                   | 1234qw   |
    | akutest@email.com |          |
