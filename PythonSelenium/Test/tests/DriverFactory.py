class GrandPa:
    def __init__(self):
        print('I\'m GrandPa')


class Father(GrandPa):
    def __init__(self):
        print('I\'m Father!')

class Son(Father):
    """A simple example class"""
    i = 12345
    def __init__(self):
        print('这是构造函数,son')
    def sayHello(self):
        return 'hello world'
    @staticmethod
    def test():
        print("Static m")

if __name__ == '__main__':
    son = Son()
    # 类型帮助信息 
    print('类型帮助信息: ',Son.__doc__)
    #类型名称
    print('类型名称:',Son.__name__)
    #类型所继承的基类
    print('类型所继承的基类:',Son.__bases__)
    #类型字典
    print('类型字典:',Son.__dict__)
    #类型所在模块
    print('类型所在模块:',Son.__module__)
    #实例类型
    print('实例类型:',Son().__class__)
    Son().test()
