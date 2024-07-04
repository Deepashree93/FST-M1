from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

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

    pimId = driver.find_element(By.ID,"menu_pim_viewPimModule")
    pimId.click()

    addButton = driver.find_element(By.ID,"btnAdd")
    addButton.click()

    fullName = driver.find_element(By.ID,"firstName")
    lastName = driver.find_element(By.ID,"lastName")
    saveButton = driver.find_element(By.ID,"btnSave")

    fullName.send_keys("John")
    lastName.send_keys("K")
    saveButton.click()

    driver.back()
    print("Title is : ", driver.title)
    driver.back()

    empName = driver.find_element(By.ID,"empsearch_employee_name_empName")
    id = driver.find_element(By.ID,"empsearch_id")

    empName.send_keys("John")
    id.clear()

    searchButton = driver.find_element(By.ID,"searchBtn")
    searchButton.click()
    #ActionChains(driver).move_to_element(searchButton).click()