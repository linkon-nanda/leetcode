This project automates functional UI tests on Leetcode to ensure the correctness of URLs, question listings, and tab functionalities. The test suite is implemented using Java and Selenium.

Project Overview
The test automation suite performs the following validations on the Leetcode platform:
Verify Homepage URL
Retrieve and Validate First 5 Questions on Problems Page
Open and Verify 'Two Sum' Problem URL
Check Submissions Tab Access Restriction
Tests are organized and executed via:
App.java — the entry point
TestCases.java — holds all test case implementations

✅Test Cases

TestCase01: Verify the Leetcode Homepage URL
Objective: Ensure the homepage URL contains "leetcode"
Steps:
Navigate to https://leetcode.com/
Assert that the URL contains leetcode
Expected Result: URL contains leetcode

TestCase02: Verify Problem Set URL and Display First 5 Questions
Objective: Validate access to the problem set and retrieve details of the first five questions
Steps:
Click the "Questions" link
Check that the URL contains problemset
Retrieve and print the first 5 question titles
Verify the presence of the "Two Sum" problem as the first
Expected Result: Correct titles printed; URL contains problemset

TestCase03: Verify the 'Two Sum' Problem
Objective: Confirm correct redirection to the "Two Sum" problem page
Steps:
Click on the "Two Sum" problem
Validate that the URL contains two-sum
Expected Result: URL includes two-sum

TestCase04: Ensure Submissions Tab Displays "Register or Sign In"
Objective: Check restricted access messaging on the submissions tab
Steps:
Click on the "Submissions" tab
Verify it displays Register or Sign In
Expected Result: Message Register or Sign In is shown

Technologies Used
Java,
Selenium WebDriver,
TestNG / JUnit (Optional based on setup)

