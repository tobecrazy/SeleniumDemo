# coding:utf-8
# script for python3
import urllib3
import ssl
import unittest
import os, sys
import time


class Test:
    '''
    @author Young
    @verson
    Get page source
    '''

    def getPageSource(url):
        http = urllib3.PoolManager()
        try:
            response = http.request('GET', url)
            print('loading ....')
            print(response.status)
            print(response.status)
            return response.data
        except:
            print('crul' + url)

    if __name__ == "__main__":
        print('open www.baidu.com')
        page = getPageSource("https://www.baidu.com")
        print(page)
