#coding:utf-8
import unittest
import os,sys
from selenium import webdriver
class BaiduTestCase(unittest.TestCase):

    def setUp(self):
        current_folder=os.getcwd()
        if "nt" in os.name:
            self.driver=webdriver.Firefox(executable_path=current_folder+"/../../webDriver/geckodriver.exe")
        else:
            self.driver=webdriver.Firefox(executable_path=current_folder+"/../../webDriver/geckodriver")
        self.addCleanup(self.driver.quit)
    def testPageTitle(self):
        self.driver.get('http://www.baidu.com')
        self.assertIn('百度', self.driver.title)

if __name__ == '__main__':
    unittest.main(verbosity=2)
