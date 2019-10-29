from abc import ABC,abstractmethod

import re
class Utils(ABC):
    @staticmethod
    def inputER(arg='',typeC=str,msg=''):
        while True:
            try:
                r=typeC(input(arg))
            except ValueError:
                if msg:
                    print(msg)
                continue
        return r
    @staticmethod
    def getObjDict(obj):
        obj_dict=obj.__dict__
        for i in obj_dict.copy():
            name=re.split("__", i)[-1]
            obj_dict[name]=obj_dict.pop(i)
        return obj_dict