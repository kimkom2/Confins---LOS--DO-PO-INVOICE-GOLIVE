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
		
		WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/input_Application Number'), Datahohendy.getValue('ApplicationNo', baris))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/btnSearch'))
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/Entry DO'))
		
		WebUI.delay(3)
		
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/Entry DO_2'))
		
		WebUI.delay(4)
		
		
		WebUI.switchToDefaultContent()
		
		number = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/Get application number'))
		
		//println(number)
		
		WebUI.delay(1)
		
		WebUI.scrollToElement(findTestObject('Object Repository/Menu/Delivery Order/No Mesin'), 3)
		
		WebUI.delay(1)
		
		WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/No Rangka'), number)
		
		WebUI.delay(1)
		
		WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/No Mesin'), number)
		
		WebUI.delay(1)
		
		WebUI.scrollToElement(findTestObject('Object Repository/Menu/Delivery Order/Registration Letter Date'), 3)
		
		// untuk convert dan get bisnis date yang ada pada sistem testing
		String str = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/Binis Date Confins_train'))
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
		
		WebUI.setText(findTestObject('Menu/Delivery Order/Registration Letter Date'), TanggalBisnisdate)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/textarea_Notes_txtNote'))
		
		
		def BPKB = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/BPKB'),FailureHandling.OPTIONAL)
		
		if (BPKB.contains('Yes'))
		{
			WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/Cek BPKB'),FailureHandling.OPTIONAL)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/DocNo BPKB'), number)
		}	
		WebUI.delay(2)
		
		def NOFAKTUR = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/NO FAKTUR'),FailureHandling.OPTIONAL)
		
		if (NOFAKTUR.contains('Yes'))
		{
			WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/CEK NO FAKTUR'),FailureHandling.OPTIONAL)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/DocNo FAKTUR'), number)
		}
		WebUI.delay(2)
		
		def STNK = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/STNK'),FailureHandling.OPTIONAL)
		
		if (STNK.contains('Yes'))
		{
			WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/CEK STNK'),FailureHandling.OPTIONAL)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/DocNo STNK'), number)
		}
		WebUI.delay(2)
		
		def BLOKIRBPKB = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/BLOKIR BPKB'),FailureHandling.OPTIONAL)
		
		if (BLOKIRBPKB.contains('Yes'))
		{
			WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/CEK BLOKIR BPKB'),FailureHandling.OPTIONAL)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Delivery Order/DocNo BLOKIR BPKB'), number)
		}
		WebUI.delay(2)
		
					
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/a_Save'))
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/a_Next'))
		
		WebUI.delay(3)
		
		WebUI.click(findTestObject('Object Repository/Menu/Delivery Order/a_Submit'))
			
	}

}

