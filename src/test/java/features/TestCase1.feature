Feature: Checking amazon functionality

Scenario: Checking E2E flow of a product on amazon website
Given Launch Browser and navigate to amazon website and verify the title
And search for particular product
When user selects and adds a product to the cart
Then Verify whether selected product added to the cart or not