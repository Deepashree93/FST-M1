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

myInfo = driver.find_element(By.ID,"menu_pim_viewMyDetails")
myInfo.click()
driver.find_element(By.XPATH, "//a[@href='/orangehrm/symfony/web/index.php/pim/viewEmergencyContacts/empNumber/1]").click()

table = driver.find_element(By.XPATH,"//table[@class='emgContactName']")
for row in table.find_element(By.XPATH,".//tr"):
    print([td.text for td in row.find_elements_by_xpath(".//td[@class='check']")])
    driver.close()