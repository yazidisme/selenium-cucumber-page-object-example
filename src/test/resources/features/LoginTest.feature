Feature: As a user, I want to create credentials

  @ValidCase @SomeTags
  Scenario: Successful login using valid account
    Given Login form in login page
    When Submit email using "your_email" and password using "your_password"
    Then Success login to home page with displaying account button

  @InvalidCase @SomeTags
  Scenario Outline: Failed login using invalid account
    Given Login form in login page
    When Submit email using "<email>" and password using "<password>"
    Then Login failed with displaying error message
    Examples:
      | email             | password |
      | qwert             | 123456   |
      |                   | 1234qw   |
      | akutest@email.com |          |