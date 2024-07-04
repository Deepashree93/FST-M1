from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver :
    driver.get("http://alchemy.hguy.co/orangehrm")
    headerImage = driver.find_element(By.XPATH, "//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/"
				+ "themes/default/images/login/logo.png']")
    src = headerImage.get_attribute("src")
    print("Header image is " , src)
    driver.close()