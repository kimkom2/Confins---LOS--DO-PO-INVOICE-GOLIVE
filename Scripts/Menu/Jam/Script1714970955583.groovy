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

import java.text.SimpleDateFormat
import java.util.Date

	
		// untuk convert dan get bisnis date yang ada pada sistem testing
		String str = WebUI.getText(findTestObject('Object Repository/Menu/Delivery Order/Binis Date Confins_train'))
		println(str)
		String[] parts = str.split(" ")// ambil parameter start buat motong
		String dayBeforeMonday = parts[0].trim()
		int lengthOfString1 = dayBeforeMonday.length()
		int lengthOfString2 = str.length() // ambil parameter start buat motong, total jumlah karakter pada bisnis date
		String Tanggal = str.substring(lengthOfString1, lengthOfString2) // start ambil motong dari bisnis date, ambil tanggal ajah
		println(Tanggal)
		String trimmedDateString = Tanggal.trim() // di trim, di hilangkan space depan nya
		println(trimmedDateString)
		def inputDateString = trimmedDateString
		def inputFormat = new SimpleDateFormat("dd MMMM yyyy")
		def outputFormat = new SimpleDateFormat("dd/MM/yyyy")
		def date = inputFormat.parse(inputDateString)
		def TanggalBisnisdate = outputFormat.format(date)
		println(TanggalBisnisdate)
		// untuk convert dan get bisnis date yang ada pada sistem testing