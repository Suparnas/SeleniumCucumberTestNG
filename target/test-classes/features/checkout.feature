Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Place the order for Products from Home Page

Given User is on Green Cart Landing Page
When User searched with shortname <Name> and extracted the actual name of the product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has the ability to enter promo code and place the order

Examples:

| Name|
| Tom |