#!/usr/bin/python
#-*-coding:utf-8-*-
from selenium import webdriver
driver=webdriver.Chrome(executable_path="c:/Users/Administrator/Documents/workspace/SeleniumDemo/webDriver/chromedriver.exe")
driver.get("http://www.baidu.com")
inputbox=driver.find_element_by_id("kw")
inputbox.send_keys("python")
search_button=driver.find_element_by_id("su")
search_button.click()
title=driver.title
print(title)
driver.quit()


