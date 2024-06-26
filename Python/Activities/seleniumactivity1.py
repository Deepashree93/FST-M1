from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/")
    print("Title of the page is : ", driver.title)
    driver.find_element(By.ID,"about-link").click()
    print("Title of the new page : ", driver.title)
