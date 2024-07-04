from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.keys import Keys 

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

myInfo = driver.find_element(By.XPATH, "//a[@href='/orangehrm/symfony/web/index.php/pim/viewMyDetails']")
myInfo.click()
Action.sendKeys(Keys.PAGE_DOWN).build().perform()
		
driver.find_element(By.XPATH,"//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1']").click()
addButton = driver.find_element(By.ID("addWorkExperience"))
addButton.click()
		
company = driver.find_element(By.ID,"experience_employer")
jobTitle = driver.find_element(By.ID, "experience_jobtitle")
fromDate = driver.find_element(By.ID,"experience_from_date")
to = driver.find_element(By.ID,"experience_to_date")
		
company.sendKeys("IBM")
jobTitle.sendKeys("Test Specialist")
fromDate.clear()
to.clear()
fromDate.sendKeys("2022-04-18")
to.sendKeys("2025-12-31")
		
saveButton = driver.find_element(By.ID, "btnWorkExpSave")
saveButton.click()
		
driver.close();   