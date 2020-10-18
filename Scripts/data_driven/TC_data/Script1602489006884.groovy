import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Page_CURA Healthcare Service/a_CURA Healthcare_menu-toggle'))

WebUI.click(findTestObject('Page_CURA Healthcare Service/a_Login'))

for(def rowNum=1; rowNum <=findTestData("data1").getRowNumbers(); rowNum++)
{
//WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Username_username'), username)
WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Username_username'), findTestData("data1").getValue(1, rowNum))

//WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Password_password'), password)
WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Password_password'), findTestData("data1").getValue(2, rowNum))

Thread.sleep(3000);
}
WebUI.click(findTestObject('Page_CURA Healthcare Service/button_Login'))

WebUI.waitForElementPresent(findTestObject('Page_CURA Healthcare Service/h2_Make Appointment'), 30)

WebUI.verifyElementText(findTestObject('Page_CURA Healthcare Service/h2_Make Appointment'), 'Make Appointment')

WebUI.closeBrowser()

