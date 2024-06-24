from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver :
    actions = ActionChains(driver)
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title of the page : ", driver.title)

    actions.click().perform()
    print("Front side text : ", driver.find_element(By.CLASS_NAME,"active"))

    actions.double_click().perform()
    print("Number is : ", driver.find_element(By.CLASS_NAME,"active"))

    actions.context_click().perform()
    print("Front value shown : ", driver.find_element(By.CLASS_NAME,"active"))

    driver.close()

