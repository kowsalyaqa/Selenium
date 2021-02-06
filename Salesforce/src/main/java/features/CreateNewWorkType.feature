Feature: Create New Work Type
Scenario: Verify that User can able to Create New Work Type
Given Launch the browser
And Enter the URL as "https://login.salesforce.com/"
And Enter UserName as "nupela@testleaf.com"
And Enter Password as "Bootcamp@1234"
And Click Login
And Click on the App Laucher Icon left to Setup
And Click on View All
And Click on Work Types
And Click on New
And Enter Work Type Name as 'Salesforce Project'
And Enter Description as 'Specimen'
And Create new operating hours by Entering a name as 'UK Shift'
And Select '(GMT+00:00) Greenwich Mean Time (GMT)' for Time Zone
And Click on Save & Verify the success message
And Enter Estimated Duration as '7'
When Click on Save
Then Verify the Created message as 'Salesforce Project'
And Close the browser