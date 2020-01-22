$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/V5/V5ChannelSFCC.feature");
formatter.feature({
  "name": "The Iconic channel test for V5-NON_Contextual",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@TheIconic"
    }
  ]
});
formatter.scenario({
  "name": "CommerceConnect login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Start"
    }
  ]
});
formatter.before({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteNavigation.to(RemoteWebDriver.java:857)\r\n\tat CucumberTest.stepDefinitions.Hooks.beforeScenario(Hooks.java:27)\r\n\tat sun.reflect.GeneratedMethodAccessor17.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:42)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User navigate to homepage of Comestri",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.userNavigateToHomepageOfComestri()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user logged in using username as \"iantesting5@fusionfactory.com\" and password as \"Fusion123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.login(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should see homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.userShouldSeeHomepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "browser\u0027s URL should be \"https://staging-product.commerceconnect.co/\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.browserSURLShouldBe(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test product CSV upload",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "product CSV for SFCC V5 channel is prepared",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.generateProductCSV(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product CSV file is uploaded",
  "keyword": "When "
});
formatter.match({
  "location": "ProductManagerStepDef.uploadProductCSV()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ProductManagerPage.clickProductsMenu(ProductManagerPage.java:198)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.uploadProductCSV(ProductManagerStepDef.java:120)\r\n\tat ✽.product CSV file is uploaded(file:src/test/features/V5/V5ChannelSFCC.feature:17)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user should be able to search this product in \"V5\" mode",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductManagerStepDef.advancedSearchProduct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "get Product IDs",
  "keyword": "And "
});
formatter.match({
  "location": "ProductManagerStepDef.getProductIDs()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test channel export new products",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "CommerceConnect SFCC channel \u0027Demandware V5\u0027",
  "keyword": "Given "
});
formatter.match({
  "location": "ChannelManagerStepDef.gotoChannel(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript1(LoginPage.java:195)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.gotoChannel(ChannelManagerStepDef.java:95)\r\n\tat ✽.CommerceConnect SFCC channel \u0027Demandware V5\u0027(file:src/test/features/V5/V5ChannelSFCC.feature:23)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "name": "export includes Product, Site Category, Price and Inventory",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job \u003cjobID\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Filter value in \u003cfilterName\u003e and Type as \u0027\u003cjobType\u003e\u0027, \u003cnumberOfItem\u003e new items should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "jobID",
        "jobType",
        "filterName",
        "numberOfItem",
        "result"
      ]
    },
    {
      "cells": [
        "26",
        "",
        "Display name",
        "9",
        "Added"
      ]
    },
    {
      "cells": [
        "29",
        "Site category",
        "External code",
        "1",
        "Added"
      ]
    },
    {
      "cells": [
        "59",
        "Price",
        "External code",
        "12",
        "Added"
      ]
    },
    {
      "cells": [
        "58",
        "Inventory",
        "External code",
        "12",
        "Added"
      ]
    }
  ]
});
formatter.scenario({
  "name": "export includes Product, Site Category, Price and Inventory",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 26",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 26(file:src/test/features/V5/V5ChannelSFCC.feature:27)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in Display name and Type as \u0027\u0027, 9 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes Product, Site Category, Price and Inventory",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 29",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 29(file:src/test/features/V5/V5ChannelSFCC.feature:27)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Site category\u0027, 1 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes Product, Site Category, Price and Inventory",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 59",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 59(file:src/test/features/V5/V5ChannelSFCC.feature:27)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Price\u0027, 12 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes Product, Site Category, Price and Inventory",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 58",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 58(file:src/test/features/V5/V5ChannelSFCC.feature:27)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Inventory\u0027, 12 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test channel export product update",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "V5 product is updated including description",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.updateProductInPIM(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript0(LoginPage.java:178)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.updateProductInPIM(ProductManagerStepDef.java:222)\r\n\tat ✽.V5 product is updated including description(file:src/test/features/V5/V5ChannelSFCC.feature:39)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Product Heartbeat is triggered and wait 120 seconds",
  "keyword": "And "
});
formatter.match({
  "location": "HeartBeatStepDef.triggerHeartbeat(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "switch to SFCC channel \u0027Demandware V5\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.gotoChannelByType(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "name": "export includes price update, product update and inventory update",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job \u003cjobID\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Filter value in \u003cfilterName\u003e and Type as \u0027\u003cjobType\u003e\u0027, \u003cnumberOfItem\u003e new items should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "jobID",
        "jobType",
        "filterName",
        "numberOfItem",
        "result"
      ]
    },
    {
      "cells": [
        "77",
        "Price",
        "External code",
        "3",
        "Added"
      ]
    },
    {
      "cells": [
        "30",
        "",
        "Display name",
        "8",
        "Added"
      ]
    },
    {
      "cells": [
        "62",
        "Inventory",
        "External code",
        "4",
        "Added"
      ]
    }
  ]
});
formatter.scenario({
  "name": "export includes price update, product update and inventory update",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 77",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 77(file:src/test/features/V5/V5ChannelSFCC.feature:45)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Price\u0027, 3 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes price update, product update and inventory update",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 30",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 30(file:src/test/features/V5/V5ChannelSFCC.feature:45)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in Display name and Type as \u0027\u0027, 8 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes price update, product update and inventory update",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 62",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 62(file:src/test/features/V5/V5ChannelSFCC.feature:45)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Inventory\u0027, 4 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test channel export sku delete",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Delete"
    }
  ]
});
formatter.step({
  "name": "V5 product with index of 3 is deleted from PIM",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.v_product_is_delete_from_PIM(String,int)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript0(LoginPage.java:178)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.v_product_is_delete_from_PIM(ProductManagerStepDef.java:344)\r\n\tat ✽.V5 product with index of 3 is deleted from PIM(file:src/test/features/V5/V5ChannelSFCC.feature:56)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Product Heartbeat is triggered and wait 150 seconds",
  "keyword": "And "
});
formatter.match({
  "location": "HeartBeatStepDef.triggerHeartbeat(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "switch to SFCC channel \u0027Demandware V5\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.gotoChannelByType(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "name": "export includes product delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@V5"
    },
    {
      "name": "@Delete"
    }
  ]
});
formatter.step({
  "name": "trigger Export job \u003cjobID\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Filter value in \u003cfilterName\u003e and Type as \u0027\u003cjobType\u003e\u0027, \u003cnumberOfItem\u003e new items should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "jobID",
        "jobType",
        "filterName",
        "numberOfItem",
        "result"
      ]
    },
    {
      "cells": [
        "79",
        "",
        "Display name",
        "1",
        "Deleted"
      ]
    },
    {
      "cells": [
        "81",
        "Price",
        "External code",
        "2",
        "Deleted"
      ]
    },
    {
      "cells": [
        "61",
        "Inventory",
        "External code",
        "2",
        "Deleted"
      ]
    }
  ]
});
formatter.scenario({
  "name": "export includes product delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Delete"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 79",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 79(file:src/test/features/V5/V5ChannelSFCC.feature:62)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in Display name and Type as \u0027\u0027, 1 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes product delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Delete"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 81",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 81(file:src/test/features/V5/V5ChannelSFCC.feature:62)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Price\u0027, 2 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes product delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Delete"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 61",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 61(file:src/test/features/V5/V5ChannelSFCC.feature:62)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Inventory\u0027, 2 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test channel export product deactivation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "each product brand is changed to Performance",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.updateProductBrand(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript0(LoginPage.java:178)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.updateProductBrand(ProductManagerStepDef.java:254)\r\n\tat ✽.each product brand is changed to Performance(file:src/test/features/V5/V5ChannelSFCC.feature:73)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Product Heartbeat is triggered and wait 120 seconds",
  "keyword": "And "
});
formatter.match({
  "location": "HeartBeatStepDef.triggerHeartbeat(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "switch to SFCC channel \u0027Demandware V5\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.gotoChannelByType(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "name": "export includes product delete, site category delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job \u003cjobID\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Filter value in \u003cfilterName\u003e and Type as \u0027\u003cjobType\u003e\u0027, \u003cnumberOfItem\u003e new items should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "jobID",
        "jobType",
        "filterName",
        "numberOfItem",
        "result"
      ]
    },
    {
      "cells": [
        "79",
        "",
        "Display name",
        "8",
        "Deleted"
      ]
    },
    {
      "cells": [
        "80",
        "Site category",
        "External code",
        "1",
        "Deleted"
      ]
    },
    {
      "cells": [
        "81",
        "Price",
        "External code",
        "10",
        "Deleted"
      ]
    },
    {
      "cells": [
        "61",
        "Inventory",
        "External code",
        "10",
        "Deleted"
      ]
    }
  ]
});
formatter.scenario({
  "name": "export includes product delete, site category delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 79",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 79(file:src/test/features/V5/V5ChannelSFCC.feature:79)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in Display name and Type as \u0027\u0027, 8 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes product delete, site category delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 80",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 80(file:src/test/features/V5/V5ChannelSFCC.feature:79)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Site category\u0027, 1 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes product delete, site category delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 81",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 81(file:src/test/features/V5/V5ChannelSFCC.feature:79)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Price\u0027, 10 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "export includes product delete, site category delete, price delete and inventory delete",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "trigger Export job 61",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ChannelManagerPage.gotoConfigurationTab(ChannelManagerPage.java:219)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.triggerExportJob(ChannelManagerStepDef.java:167)\r\n\tat ✽.trigger Export job 61(file:src/test/features/V5/V5ChannelSFCC.feature:79)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Filter value in External code and Type as \u0027Inventory\u0027, 10 new items should be Deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test SFCC channel order import",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Order"
    }
  ]
});
formatter.step({
  "name": "SFCC Admin page URL: \"http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang\u003ddefault\" and username anything and password anything to sign in",
  "keyword": "Given "
});
formatter.match({
  "location": "ChannelManagerStepDef.openAdminPage(String,String,String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript3(LoginPage.java:232)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.openAdminPage(ChannelManagerStepDef.java:580)\r\n\tat ✽.SFCC Admin page URL: \"http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang\u003ddefault\" and username anything and password anything to sign in(file:src/test/features/V5/V5ChannelSFCC.feature:91)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "a new SFCC order is generated",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.generateNewOrder(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "import ocapi_order job is triggered in channel",
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.importOrderOrProduct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "this SFCC order should be imported and job result is Success in Order Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.checkImportResult(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "TearDown",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
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
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:442)\r\n\tat cucumberBase.driverFactory.managers.DriverFactoryManager.closeDriver(DriverFactoryManager.java:76)\r\n\tat CucumberTest.stepDefinitions.Hooks.closeDriver(Hooks.java:46)\r\n\tat sun.reflect.GeneratedMethodAccessor21.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)\r\n",
  "status": "failed"
});
formatter.uri("file:src/test/features/V5/V5ChannelTheIconic.feature");
formatter.feature({
  "name": "The Iconic channel test for V5-NON_Contextual",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@TheIconic"
    }
  ]
});
formatter.scenario({
  "name": "CommerceConnect login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    },
    {
      "name": "@Start"
    }
  ]
});
formatter.before({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteNavigation.to(RemoteWebDriver.java:857)\r\n\tat CucumberTest.stepDefinitions.Hooks.beforeScenario(Hooks.java:27)\r\n\tat sun.reflect.GeneratedMethodAccessor17.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:42)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User navigate to homepage of Comestri",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.userNavigateToHomepageOfComestri()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user logged in using username as \"iantesting5@fusionfactory.com\" and password as \"Fusion123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.login(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should see homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.userShouldSeeHomepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "browser\u0027s URL should be \"https://staging-product.commerceconnect.co/\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.browserSURLShouldBe(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test V5 product CSV upload",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "product CSV for The Iconic V5 channel is prepared",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.generateProductCSV(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product CSV file is uploaded",
  "keyword": "When "
});
formatter.match({
  "location": "ProductManagerStepDef.uploadProductCSV()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:670)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat cucumberBase.helpers.wait.WaitHelper.waitForElementClickable(WaitHelper.java:88)\r\n\tat cucumberBase.pageFactory.ProductManagerPage.clickProductsMenu(ProductManagerPage.java:198)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.uploadProductCSV(ProductManagerStepDef.java:120)\r\n\tat ✽.product CSV file is uploaded(file:src/test/features/V5/V5ChannelTheIconic.feature:17)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user should be able to search this product in \"V5\" mode",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductManagerStepDef.advancedSearchProduct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "get Product IDs",
  "keyword": "And "
});
formatter.match({
  "location": "ProductManagerStepDef.getProductIDs()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test V5 channel export new products",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "CommerceConnect The Iconic channel \u0027TheIconic V5\u0027",
  "keyword": "Given "
});
formatter.match({
  "location": "ChannelManagerStepDef.gotoChannel(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript1(LoginPage.java:195)\r\n\tat CucumberTest.stepDefinitions.ChannelManagerStepDef.gotoChannel(ChannelManagerStepDef.java:95)\r\n\tat ✽.CommerceConnect The Iconic channel \u0027TheIconic V5\u0027(file:src/test/features/V5/V5ChannelTheIconic.feature:23)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "trigger Export job 48",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "In Export Items tab, set filter values using these product indexes",
  "rows": [
    {
      "cells": [
        "2",
        "3",
        "4",
        "6",
        "7",
        "8"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.getQueryProductIDsByDataTable(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Filter values in External code and Type as \u0027Product\u0027, 6 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test V5 channel export product update",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "V5 product is updated excluding description",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.updateProductInPIM(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript0(LoginPage.java:178)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.updateProductInPIM(ProductManagerStepDef.java:222)\r\n\tat ✽.V5 product is updated excluding description(file:src/test/features/V5/V5ChannelTheIconic.feature:31)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Product Heartbeat is triggered and wait 90 seconds",
  "keyword": "And "
});
formatter.match({
  "location": "HeartBeatStepDef.triggerHeartbeat(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "trigger Export job 48",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "In Export Items tab, set filter values using these product indexes",
  "rows": [
    {
      "cells": [
        "6",
        "7",
        "8"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.getQueryProductIDsByDataTable(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Filter values in External code and Type as \u0027Product\u0027, 3 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "In Export Items tab, set filter values using these product indexes",
  "rows": [
    {
      "cells": [
        "2",
        "3",
        "4",
        "6",
        "7",
        "8"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.getQueryProductIDsByDataTable(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Filter values in External code and Type as \u0027Product image\u0027, 6 new items should be Added",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "test V5 channel export product deactivation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
    }
  ]
});
formatter.step({
  "name": "colour product brand is changed to Performance",
  "keyword": "Given "
});
formatter.match({
  "location": "ProductManagerStepDef.updateProductBrand(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getWindowHandles(RemoteWebDriver.java:460)\r\n\tat cucumberBase.pageFactory.LoginPage.executeScript0(LoginPage.java:178)\r\n\tat CucumberTest.stepDefinitions.ProductManagerStepDef.updateProductBrand(ProductManagerStepDef.java:254)\r\n\tat ✽.colour product brand is changed to Performance(file:src/test/features/V5/V5ChannelTheIconic.feature:43)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Product Heartbeat is triggered and wait 120 seconds",
  "keyword": "And "
});
formatter.match({
  "location": "HeartBeatStepDef.triggerHeartbeat(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "trigger Export job 48",
  "keyword": "When "
});
formatter.match({
  "location": "ChannelManagerStepDef.triggerExportJob(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "In Export Items tab, set filter values using these product indexes",
  "rows": [
    {
      "cells": [
        "2",
        "3",
        "4",
        "6",
        "7",
        "8"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ChannelManagerStepDef.getQueryProductIDsByDataTable(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Filter values in External code and Type as \u0027Product\u0027, 6 new items should be Disabled",
  "keyword": "Then "
});
formatter.match({
  "location": "ChannelManagerStepDef.varifyExportResult(String,String,String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "TearDown",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TheIconic"
    },
    {
      "name": "@V5"
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
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.5\u0027, revision: \u0027d54ebd709a\u0027, time: \u00272018-11-06T11:42:16\u0027\nSystem info: host: \u0027LAPTOP-5KQHJ05I\u0027, ip: \u0027192.168.45.126\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:442)\r\n\tat cucumberBase.driverFactory.managers.DriverFactoryManager.closeDriver(DriverFactoryManager.java:76)\r\n\tat CucumberTest.stepDefinitions.Hooks.closeDriver(Hooks.java:46)\r\n\tat sun.reflect.GeneratedMethodAccessor21.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)\r\n",
  "status": "failed"
});
});