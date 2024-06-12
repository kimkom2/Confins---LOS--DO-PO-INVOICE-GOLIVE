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

// tambahan untuk convert tanggal 
import java.text.SimpleDateFormat
import java.util.Date

TestData Datahohendy = findTestData('Data Files/Data invoice/Param')

for (int baris = 1; baris <= Datahohendy.getRowNumbers(); baris++)
{
	if (Datahohendy.getValue('Use', baris) == 'Yes')
	{
		WebUI.switchToDefaultContent()
		
		WebUI.setText(findTestObject('Object Repository/Menu/Purchase Order/input_Application Number'), Datahohendy.getValue('ApplicationNo', baris))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/input_Task Claim'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/Edit'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/Entry'))
		
		WebUI.delay(4)
		
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/a_Save'))
		
		WebUI.delay(4)
		
		WebUI.scrollToElement(findTestObject('Object Repository/Menu/Purchase Order/Copty dAta'), 3)
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/Fiducia/Fiducia '+ Datahohendy.getValue('Fiducia by', baris)))
		
		WebUI.delay(4)
						
		WebUI.click(findTestObject('Object Repository/Menu/Purchase Order/a_Submit'))	
		
		WebUI.delay(5)
		
		WebUI.delay(3)
		
		WebUI.closeBrowser()
		
	}

}
