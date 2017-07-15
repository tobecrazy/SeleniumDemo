#!/usr/bin/python
#coding=utf-8
from selenium import webdriver
import os,sys
current_folder=os.getcwd()
print(os.name)
print(current_folder)

if "nt" in os.name:driver=webdriver.Chrome(executable_path=current_folder+"/../../webDriver/chromedriver.exe")
else:driver=webdriver.Chrome(executable_path=current_folder+"/../../webDriver/chromedriver")
driver.get("http://www.baidu.com")
inputbox=driver.find_element_by_id("kw")
inputbox.send_keys("python")
search_button=driver.find_element_by_id("su")
search_button.click()
title=driver.title
#print(title.decode("utf8"))
driver.quit()


