Feature: Validation for Subscription packages for STC TV application

Scenario: 1. Validate the landing page key elements

Given user is on stc tv landing page 
Then user checks all the key buttons and links are visible

Scenario: 2. Validate the language is changed based on the language selector

Given user is on stc tv landing page
When user changes the language to arabic
Then page language is modifed to arabic language
And user change the language back to english

Scenario Outline: 3. Validate currencies and URL is changed based on the selected country

Given user is on stc tv landing page
When user click on country button
Then user select country <Country> checks currency <Currency> URL <URL> is modified

Examples:
| Country | Currency | URL |
| KSA     | SAR      | sa  |
| Kuwait  | KWD      | kw  |
| Bahrain | BHD      | bh  |

Scenario: 4. Validate types of package visible on screen

Given user is on stc tv landing page
Then user checks all the package types are displayed


