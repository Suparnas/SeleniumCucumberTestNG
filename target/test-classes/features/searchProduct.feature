Feature: Search and Place the Order for Vegetables
@OffersPage
Scenario Outline: Search Experience for Product Search in both Home and Offers page

Given User is on Green Cart Landing Page
When User searched with shortname <Name> and extracted the actual name of the product
Then User searched for <Name> shortname in Offers page
And Validate product name in Offers Page matches with Landing Page

Examples:

| Name|
| Tom |
| Beet|