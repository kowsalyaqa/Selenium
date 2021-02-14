Feature: Assessment
Scenario: Verify all the functionality is working
Given Click on App Launcher
And Click on View All
And  Click on Service 
And Click on Reports
And  Click on New Report SalesForce Classic 
And Click on Leads
And Download the Lead Report Image on the Right side
And Click on Create
And  Select Range as All Time
And Select From date as todays date 
And Selecte To as +5 days From Today
And Verify Whether the Preview is in Tabular Format
And Get the List of Billing State/Province
And Get the Grand Total of Records Availabl
And Click on Save 
And Enter Report name as "kowsalya"
And Enter Report Unique name as "kowsalya_001"
And Enter Report Discussion as Report Updated by "kowsalya"
And Select Report Folder as Unfiled Public Reports
And Click on Save 
And Verify Report has been created successfully
And  Click on Run Report
And Get the total Number of Records
And Click on Edit 
When Click on Close 
Then Get the text of Report Name 
Then Verify the Report Name
Then Get the Date and Time When the Report is Created On