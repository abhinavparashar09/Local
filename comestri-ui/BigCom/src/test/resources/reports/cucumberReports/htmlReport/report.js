$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/V5cm/ChannelBigcommerceV3.feature");
formatter.feature({
  "name": "BigCommerce channel test for V5-Contextual",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@BigCommerceV3"
    }
  ]
});
formatter.scenario({
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@BigCommerceV3"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Contextual"
    },
    {
      "name": "@Start"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigate to homepage of Comestri",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.userNavigateToHomepageOfComestri()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logged in using username as \"iantesting5@fusionfactory.com\" and password as \"Fusion123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.login(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should see homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.userShouldSeeHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "browser\u0027s URL should be \"https://staging-product.commerceconnect.co/\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.browserSURLShouldBe(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "TearDown",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@BigCommerceV3"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Contextual"
    },
    {
      "name": "@last"
    }
  ]
});
formatter.step({
  "name": "User has completed Test",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.userHasCompletedTest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Test completed",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.testCompleted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "log will be in place",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.logWillBeInPlace()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});