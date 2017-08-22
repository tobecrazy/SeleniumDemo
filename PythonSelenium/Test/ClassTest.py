#!/usr/bin/python
class DriverFactory(object):
    temp=""
    def __init__(self):
        print("init DriverFactory")
       
@staticmethod
def test1(temp):
    print("=====================================")
    print(temp)

if __name__ == '__main__':
    print("*************************************")
    DriverFactory().test1("111111111aaa")
