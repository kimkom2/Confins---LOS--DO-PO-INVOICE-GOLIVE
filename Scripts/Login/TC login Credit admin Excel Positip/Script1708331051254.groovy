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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData Hohendy = findTestData('Data Files/Data login/Excel Login negative')

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

for (int baris = 1; baris <= Hohendy.getRowNumbers(); baris++) { // lebih dinamis
	
	WebUI.setText(findTestObject('Object Repository/Login Confins Credit admin/Confins login page/Input NRK'), Hohendy.getValue('Username',baris))
	
//	String username = WebUI.getText(null)
//	
//	println(username, username)
	
	WebUI.setText(findTestObject('Object Repository/Login Confins Credit admin/Confins login page/Input Password'), Hohendy.getValue('Password',baris))
	
	WebUI.click(findTestObject('Login Confins Credit admin/Confins login page/Button login'))
	
	WebUI.delay(2)
	
	WebUI.verifyTextPresent(Hohendy.getValue('MSG', baris), false)
	
}

//for (int baris = 1; baris <= 3; baris++) {
//	
//	WebUI.setText(findTestObject('Object Repository/Login Confins Credit admin/Confins login page/Input NRK'), Hohendy.getValue('Username',baris))
//	
//	WebUI.setText(findTestObject('Object Repository/Login Confins Credit admin/Confins login page/Input Password'), Hohendy.getValue('Password',baris))
//	
//	WebUI.click(findTestObject('Login Confins Credit admin/Confins login page/Button login'))
//	
//	WebUI.delay(2)
//	
//	WebUI.verifyTextPresent(Hohendy.getValue('MSG', baris), false)
//	
//}

