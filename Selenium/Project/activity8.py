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

dashboard = driver.find_element(By.ID,"menu_dashboard_index")
dashboard.click()
applyLeave = driver.find_element(By.XPATH,"//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png']")
applyLeave.click()
apply = driver.find_element(By.ID,"menu_leave_applyLeave")
apply.click()
select = Select(driver.find_element_by_name('applyleave[txtLeaveType]'))
fromDate = driver.find_element(By.ID,"applyleave_txtFromDate")
toDate = driver.find_element(By.ID,"applyleave_txtToDate")
		
select.select_by_visible_text("DayOff")
fromDate.clear()
fromDate.send_keys("2024-07-03")
toDate.clear()
toDate.send_keys("2024-07-05")
applyButton = driver.find_element(By.ID,"applyBtn")
Action.move_to_element(applyButton).click()
myLeave = driver.find_element(By.id("menu_leave_viewMyLeaveList"))
myLeave.click()
fromDate1 = driver.find_element(By.ID,"calFromDate")
to = driver.find_element(By.ID, "calToDate")
fromDate1.clear()
fromDate1.send_keys("2024-07-03")
to.clear()
to.send_keys("2024-07-05")
searchButton = driver.find_element(By.ID,"btnSearch")
searchButton.click()
		
driver.close()