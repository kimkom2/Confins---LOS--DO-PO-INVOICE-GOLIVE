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
		
		WebUI.setText(findTestObject('Object Repository/Menu/Inovice/Application Number'), Datahohendy.getValue('ApplicationNo', baris))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/btnSearch'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/Action'))
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/Currentcy IDR'))
		
		WebUI.delay(1)
		
		WebUI.setText(findTestObject('Object Repository/Menu/Inovice/Application Number'), Datahohendy.getValue('ApplicationNo', baris))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/btnSearch'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/Cek List Invoice'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/a_Add To Temp'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/a_Next'))
		
		WebUI.delay(1)
		
		// untuk convert dan get bisnis date yang ada pada sistem testing
		String str = WebUI.getText(findTestObject('Object Repository/Menu/Inovice/Bisnis Date'))
		String Tanggal = str.substring(8, 21) // This will extract "World" from the original string
		println(Tanggal)
		def inputDateString = Tanggal
		def inputFormat = new SimpleDateFormat("dd MMMM yyyy")
		def outputFormat = new SimpleDateFormat("dd/MM/yyyy")
		def date = inputFormat.parse(inputDateString)
		def TanggalBisnisdate = outputFormat.format(date)
		println(TanggalBisnisdate)
		// untuk convert dan get bisnis date yang ada pada sistem testing
		
		WebUI.delay(2)
		
		WebUI.setText(findTestObject('Object Repository/Menu/Inovice/Invoice date'), TanggalBisnisdate)
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/App_num'))
		
		WebUI.delay(1)
		
		number = WebUI.getText(findTestObject('Object Repository/Menu/Inovice/Get Application Number'))
		
		println(number)
		
		WebUI.setText(findTestObject('Object Repository/Menu/Inovice/App_num'),'INV'+ number)
		
					
		WebUI.click(findTestObject('Object Repository/Menu/Inovice/a_Save'))
				
	}

}

