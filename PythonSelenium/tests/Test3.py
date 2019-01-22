#coding:utf-8
import urllib2
import ssl  
import unittest
import os,sys
import time

class Test:
  '''
  @author Young
  @version
  Get page source
  '''
  def getPageSource(url):
    try:
      request = urllib2.Request(url)
      response = urllib2.urlopen(request)
      print "loading ...."
      page = response.read()
    except:
      print "crul ",url
      (status,page)=commands.getstatusoutput("curl "+url)
    finally:
      return page  

  if __name__ == "__main__":
    print "open www.baidu.com" 
    page=getPageSource("https://www.baidu.com")
    print page
    

