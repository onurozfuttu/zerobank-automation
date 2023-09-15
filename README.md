# zerobank-automation

Zero Bank Test Automation Task 1
TANIM
Bu odevde online bir bankacilik uygulamasi ile ilgili test otomasyonu yapacaksiniz. Framework icin
Cucumber BDD ve Selenium kullancaksiniz.
Projenin Kurulumu
1. Maven projesi olusturun. Group-id icin com.zerobank ve artifact-id icin zerobank-automation
kullanin. Pom file icerisinde Cucumber ve Selenium icin gerekli olan tum dependencies ve
Cucumber HTML Report icin eklemelerinizi yapin.
2. src/test/java altinda asagidaki packages olustur:
a. Com.zerobank.pages
b. Com.zerobank.runners
c. Com.zerobank.stepdefinitions
d. Com.zerobank.utilities
3. src/test altinda resources directory olusturun.
4. src/test/resources altinda features klasorunu olusturun.
5. Proje klasorunun atinda configuration.properties dosyasini olusturun.
6. Utilities package altinda:
a. ConfigurationReader
b. BrowserUtils
c. Driver classlarini olusturun
7. Runner package altinda CukesRunner classini olusturun
Feature Dosyalarinin Yazimi
Feature dosyalarini asagidaki gerekliliklere gore yazin. Her gereksinim icin bir feature dosyasi olusturun.
Her feature dosyasinin birden fazla gereksinimi olabilir.
Login
Uygulamaya sadece yetkili kullanicilar giris yapabilir. Kullanici gecerli kimlik bilgileri ile oturum actiginda
Account summary (Hesap ozeti) sayfasini goruntuleyebilmelidir. 
Kullanici adi veya sifresi yanlis olan kullanicilar giris yapmamalidirlar. Kullanaicilarin bos kullanici adi veya
sifre ile de girisleri mumkun olmamalidir. Kullanici gecersiz kullanici bigileri ile giris yapmak istediginde
Login and/or password are wrong seklinde mesaji gorebilmelidirler.
Account summary
Account summary sayfasinin basligi Zero -Account summary olmalidir. Account summary sayfasinda
asagidaki hesap turleri olmalidir:
• Cash Accounts,
• Investment Accounts,
• Credit Accounts,
• Loan Accounts.
Credit Accounts tablosunda:
• Account
• Credit Card
• Balance sutunlari olmalidir.
Account Activity
Account Activity sayfasinin basligi Zero-Account activity olmalidir.
Account menusunde varsayilan secenek Savings olmalidir. Account menusu asagidaki secenekleri de
icermelidir:
• Savings,
• Checking,
• Loan,
• Credit Card,
• Brokerage.
Transactions tablosu ndaki sutun isimleri sunlar olmalidir:
• Date,
• Description,
• Deposit
• Withdrawal
Pay Bills
Account Activity sayfasinin basligi Zero -Pay Bills olmalidir. Kullanici odeme(Pay) islemini
gerceklestirdiginde The payment was successfully submitted mesajini gorebilmelidir. Kullanici odeme
islemi yaparken miktari veya tarihi girmediginde Please fill out this field message! gorebilmelidir. Tutar
(Amount) alani alfabetik veya ozel karakter icermemelidir. Tarih alani alfabetik karakter kabul
etmemelidir.
NOT: input alanlari icin sendKeys kullanabilirsiniz. Date navigetoru click yapmaya gerek yok.
Test Datalari:
browser=chrome
url=http://zero.webappsecurity.com/
userName=username
passWord=password
NOT: Sayfaya verilen url ile girdikten sonra Signin button a basilmali, sonrasinda verilen veriler girilmeli ve
Sign in butona basilmali. Ancak acilan sayfadan tekrar http://zero.webappsecurity.com/bank/accountsummary.html sayfasina gidilmeli.

BONUS Tasks:
AccountActivityNavigation.feature

	Feature: Navigating to specific accounts in Accounts Activity

		Scenario: Savings account redirect
		Given the user is logged in
		When the user clicks on Savings link on the Account Summary page
		Then the Account Activity page should be displayed
		And Account drop down should have Savings selected

		Scenario: Brokerage account redirect
		Given the user is logged in
		When the user clicks on Brokerage link on the Account Summary page
		Then the Account Activity page should be displayed
		And Account drop down should have Brokerage selected
		
		Scenario: Checking account redirect
		Given the user is logged in
		When the user clicks on Checking link on the Account Summary page
		Then the Account Activity page should be displayed
		And Account drop down should have Checking selected
		
		Scenario: Credit Card account redirect
		Given the user is logged in
		When the user clicks on Credit card link on the Account Summary page
		Then the Account Activity page should be displayed
		And Account drop down should have Credit Card selected
		
		Scenario: Loan account redirect
		Given the user is logged in
		When the user clicks on Loan link on the Account Summary page
		Then the Account Activity page should be displayed
		And Account drop down should have Loan selected



FindTransactions.feature

	Feature: Find Transactions in Account Activity
		
		Scenario: Search date range
		Given the user accesses the Find Transactions tab
		When the user enters date range from “2012-09-01” to “2012-09-06”
		And clicks search
		Then results table should only show transactions dates between “2012-09-01” to
		“2012-09-06”
		And the results should be sorted by most recent date
		
		Scenario: Search description
		Given the user accesses the Find Transactions tab
		When the user enters description “ONLINE”
		And clicks search
		Then results table should only show descriptions containing “ONLINE”

		Scenario: Type-1
		Given the user accesses the Find Transactions tab
		And clicks search
		Then results table should show at least one result under Deposit
		Then results table should show at least one result under Withdrawal
		
		Scenario: Type-2
		Given the user accesses the Find Transactions tab
		When user selects type “Deposit” and clicks on Find
		Then results table should show at least one result under Deposit
		But results table should show no result under Withdrawal

		Scenario: Type-3
		Given the user accesses the Find Transactions tab
		When user selects type “Withdrawal” and clicks on Find
		Then results table should show at least one result under Withdrawal
		But results table should show no result under Deposit


Add New Payee.feature

	Feature: Add new payee under pay bills
		
		Scenario: Add a new payee
		Given Add New Payee tab
		And creates new payee using following information
		|Payee Name | The Law Offices of Hyde, Price & Scharks|
		|Payee Address | 100 Same st, Anytown, USA, 10001 |
		|Account | Checking |
		|Payee details | XYZ account |
		Then message The new payee The Law Offices of Hyde, Price & Scharks was should successfully created. should be displayed		




PurchaseForeignCurrency.feature
	
	Feature: Purchase Foreign Currency

		Scenario: Available currencies
		Given the user accesses the Purchase foreign currency cash tab
		Then following currencies should be available
		|Australia (dollar) |
		|Canada (dollar) |
		|Switzerland (franc) |
		|China (yuan) |
		|Denmark (krone) |
		|Eurozone (euro) |
		|Great Britain (pound)|
		|Japan (yen) |
		|Mexico (peso) |
		|Norway (krone) |
		|New Zealand (dollar) |
		|Singapore (dollar) |

		Scenario: Error message for not selecting currency
		Given the user accesses the Purchase foreign currency cash tab
		When user tries to calculate cost without selecting a currency
		Then error message should be displayed
