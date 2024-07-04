from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver :
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    print("Title of the page : ", title)
    actualTtile = "OrangeHRM"
    assert actualTtile == title

    driver.close()
    