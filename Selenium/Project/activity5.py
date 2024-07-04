from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import Select

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver :
    Action = ActionChains(driver)
    driver.get("http://alchemy.hguy.co/orangehrm")

    username = driver.find_element(By.ID,"txtUsername")
    password = driver.find_element(By.ID,"txtPassword")

    username.send_keys("orange")
    password.send_keys("orangepassword123")

    loginButton = driver.find_element(By.NAME,"Submit")
    loginButton.click()

myInfo = driver.find_element(By.ID,"menu_pim_viewMyDetails")
myInfo.click()
editButton = driver.find_element(By.ID,"btnSave")
editButton.click()
		
fullName = driver.find_element(By.ID , "personal_txtEmpFirstName")
lastName = driver.find_element(By.NAME, "personal[txtEmpLastName]")
gender1 = driver.find_element(By.ID, "personal_optGender_1")
gender2 = driver.find_element(By.ID, "personal_optGender_2")
select = Select(driver.find_element_by_name('personal[cmbNation]'))
doB = driver.find_element(By.ID,"personal_DOB")
		
fullName.clear()
lastName.clear()
doB.clear()
fullName.sendKeys("Peter")
lastName.sendKeys("KT")
gender1.click()
select.selectByVisibleText("Indian")
doB.sendKeys("1997-10-05")
saveButton = driver.find_element(By.ID,"btnSave")
saveButton.click()
print("URL after saving the details is : " + driver.getCurrentUrl())