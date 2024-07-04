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

driver.find_element(By.XPATH,"//a[@href='/orangehrm/symfony/web/index.php/directory/viewDirectory/reset/1']").click()

header = driver.find_element(By.TAG_NAME,"h1")
actualTitle = "Search Directory"
print("Title of the page is : " , header.text)
assert actualTitle == header.text, "Title match"
driver.close()